package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class SearchTest extends BasicTest {

	
	@Test 
	public void searchResult () throws IOException, InterruptedException {
		driver.navigate().to(baseUrl + "meals");
		popUpPage.setLocation("City Center - Albany");
		File file = new File("data/Data(1).xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");
		Thread.sleep(5000);
		
		for (int i = 1; i < 7; i++) {
			String url = sheet.getRow(i).getCell(1).getStringCellValue();
			this.driver.get(url);
			Thread.sleep(3000);

			String location = sheet.getRow(i).getCell(0).getStringCellValue();
            popUpPage.getLocationHeader().click();
            Thread.sleep(5000);
			this.popUpPage.setLocation(location);

			int resultNo = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
			int numberOfMeals = this.searchResultPage.getMealNo();
			Thread.sleep(3000);
			
			softAssert.assertEquals(numberOfMeals, resultNo, "Number of products doesn't match");
			Thread.sleep(4000);

			for (int j = 3; j < 3 + resultNo; j++) {
				String meal = sheet.getRow(i).getCell(j).getStringCellValue();
				String name = searchResultPage.getNames().get(j - 3);
				Thread.sleep(3000);
				softAssert.assertTrue(name.contains(meal), "Product names do not match. ");

			}
			Thread.sleep(3000);
		}
		softAssert.assertAll();
	}
	
 }
