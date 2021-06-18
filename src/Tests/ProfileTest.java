package Tests;

import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	@Test
	public void test () {
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
		
		notification.goToPage("member/account");
		notification.getMessage();
		notification.getMessageText();
		notification.waitUntilNotificationDisapear();
	
	}

}