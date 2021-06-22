package Tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	@Test(priority = 0)
	public void editProfile() throws InterruptedException {

		driver.navigate().to(baseUrl + "guest-user/login-form");
		popUpPage.closeDialog();
		loginPage.logIn("customer@dummyid.com", "12345678a");
		Thread.sleep(5000);
		String loginMessage = notification.getMessageText();
		Assert.assertTrue(loginMessage.contains("Login Successfull"), "Message for successful log in is not displayed");

		driver.get("http://demo.yo-meals.com/member/profile");
		profilePage.changeInformations("Tom", "Willson", "Downtown Street 15", "2322333", "23122", "United States",
				"Alabama", "Ashville");
		profilePage.getSaveBtn().click();
		String setUpMessage = notification.getMessageText();
		Assert.assertTrue(setUpMessage.contains("Setup Successful"), "Message for successful setup is not displayed");

		authPage.logOutUser();
		String logOut = notification.getMessageText();
		Assert.assertTrue(logOut.contains("Logout Successfull!"), "Message for successful logout is not displayed");

	}

	@Test(priority = 1)
	public void changeProfilImg() throws InterruptedException, IOException {

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

}
