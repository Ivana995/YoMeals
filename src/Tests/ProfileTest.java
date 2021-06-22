package Tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	@Test (priority = 0)
	public void editProfile () throws InterruptedException {
		
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		popUpPage.closeDialog();
		loginPage.logIn("customer@dummyid.com", "12345678a");
		Thread.sleep(5000);
		String loginMessage = notification.getMessageText();
		Assert.assertTrue(loginMessage.contains("Login Successfull"), "Message for successful log in is not displayed");
		
		driver.get("http://demo.yo-meals.com/member/profile");
		profilePage.changeInformations("Tom", "Willson", "Downtown Street 15", "2322333", "23122", "United States", "Alabama", "Ashville");
		profilePage.getSaveBtn().click();
		String setUpMessage = notification.getMessageText();
		Assert.assertTrue(setUpMessage.contains("Setup Successful"), "Message for successful setup is not displayed");
		
		authPage.logOutUser();
		String logOut = notification.getMessageText();
		Assert.assertTrue(logOut.contains("Logout Successfull!"), "Message for successful logout is not displayed");
		
	}
	
	@Test (priority = 1)
		public void changeProfilImg () throws InterruptedException, IOException {
		
		    driver.navigate().to(baseUrl + "guest-user/login-form");
			popUpPage.closeDialog();
			loginPage.logIn("customer@dummyid.com", "12345678a");
			Thread.sleep(5000);
			String loginMessage = notification.getMessageText();
			Assert.assertTrue(loginMessage.contains("Login Successfull"), "Message for successful log in is not displayed");
			Thread.sleep(5000);
			driver.navigate().to(baseUrl + "member/profile");
			String imgPath = new File("img/postman1.png").getCanonicalPath();
			this.profilePage.uploadImg(imgPath);
			String uploadedImg = notification.getMessageText();
			Assert.assertTrue(uploadedImg.contains("Profile Image Uploaded Successfully"), "Message is not displayed");
			notification.waitUntilNotificationDisapear();
			profilePage.deleteImg();
			String deleteImg = notification.getMessageText();
			Assert.assertTrue(deleteImg.contains("Profile Image Deleted Successfully"), "Message is not displayed");
			authPage.logOutUser();
			String logOut = notification.getMessageText();
			Assert.assertTrue(logOut.contains("Logout Successfull!"), "Message is not displayed");
			
		}
	
		
	//	popUpPage.goToPage("");
	//	popUpPage.getLocationHeader().click();
	//	popUpPage.getCloseElement().click();
	//	
	
	//	popUpPage.goToPage("");
	//	popUpPage.openPopUpDialog();
	//	popUpPage.setLocation("Burlington");
	//	popUpPage.closeDialog();
		
		
	//	loginPage.goToPage("guest-user/login-form");
	//	popUpPage.closeDialog();
	//	loginPage.logIn("customer@dummyid.com", "12345678a");
		
	//	notification.goToPage("member/account");
	//	notification.getMessage();
	//	notification.getMessageText();
	//	notification.waitUntilNotificationDisapear();
		
	//	loginPage.goToPage("guest-user/login-form");
	//	popUpPage.closeDialog();
	 //   loginPage.logIn("customer@dummyid.com", "12345678a");
	//	profilePage.goToPage("member/profile");
	//	popUpPage.closeDialog();
	//	Thread.sleep(5000);
	//	profilePage.getUploadImgBtn();
	//	profilePage.getProfileImg("C:\\Users\\User\\Desktop\\postman2.png");
	//	profilePage.deleteImg();
		
	//	authPage.goToPage("member/profile");
	//	authPage.logOutUser();
		
	//mealPage.goToPage("meal/baked-caldereta-provinÃ§ale");
	//	popUpPage.closeDialog();
	//	Thread.sleep(5000);
	//	mealPage.getQuantity().clear();
	//	mealPage.AddMealToCart(4);
	//	mealPage.addToFavorite();
		
	//	cartSummary.goToPage("meal/baked-caldereta-provinÃ§ale");
	 //   cartSummary.clearCart();
	
	}

