package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {
	
	
	@Test(priority = 1)
	public void addMealToCart() throws InterruptedException {
		driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		popUpPage.closeDialog();
		mealPage.AddMealToCart(3);
		String errorMessage = notification.getMessageText();
		Assert.assertTrue(errorMessage.contains("The Following Errors Occurred:"), "Message is not displayed");
		Assert.assertTrue(errorMessage.contains("Please Select Location"), "Message is not displayed");
		notification.waitUntilNotificationDisapear();
		popUpPage.setLocation("City Center - Albany");
		mealPage.AddMealToCart(3);
		String addedMeal = notification.getMessageText();
		Assert.assertTrue(addedMeal.contains("Meal Added To Cart"), "Message is not displayed");
	}
	 
	@Test(priority = 2)
	public void addMealToFavorite() {
		driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		popUpPage.closeDialog();
		mealPage.addToFavorite();
		String loginMessage = notification.getMessageText();
		Assert.assertTrue(loginMessage.contains("Please login first!"), "Message is not displayed");
		driver.navigate().to(baseUrl + "guest-user/login-form");
		loginPage.logIn("customer@dummyid.com", "12345678a");
		driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addToFavorite();
		String favoriteMessage = notification.getMessageText();
		Assert.assertTrue(favoriteMessage.contains("Product has been added to your favorites."),
				"Message is not displayed");
	} 
	

	@Test(priority = 3)
	public void clearCart() throws IOException, InterruptedException {
		driver.navigate().to(baseUrl + "meals");
		popUpPage.closeDialog();
		popUpPage.setLocation("City Center - Albany");
		File file = new File("data/Data (3).xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");

		for (int i = 1;  i<6; i++) {
			XSSFRow row = sheet.getRow(i);
			String meal = row.getCell(0).getStringCellValue();
			int quantity = (int) row.getCell(1).getNumericCellValue();
			driver.navigate().to(meal);
			mealPage.AddMealToCart(quantity);
			String addedMessage = notification.getMessageText();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(addedMessage.contains("Meal Added To Cart"), "Message is not displayed");
			softAssert.assertAll();

		}

		cartSummary.clearCart();
		String deleteMessage = notification.getMessageText();
		Assert.assertTrue(deleteMessage.contains("All meals removed from Cart successfully"),
				"Message is not displayed");

	} 
}
