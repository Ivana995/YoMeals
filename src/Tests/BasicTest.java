package Tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import Pages.AuthPage;
import Pages.CartSummaryPage;
import Pages.LocationPopUpPage;
import Pages.LoginPage;
import Pages.MealPage;
import Pages.NotificationSistemPage;
import Pages.ProfilePage;
import Pages.SearchResultPage;

	
	public abstract class BasicTest {
		
		protected WebDriver driver;
		protected LocationPopUpPage popUpPage;
		protected LoginPage loginPage;
		protected NotificationSistemPage notification;
		protected ProfilePage profilePage;
		protected WebDriverWait waiter;
		protected JavascriptExecutor js;
		protected AuthPage authPage;
		protected MealPage mealPage;
		protected CartSummaryPage cartSummary;
		protected SearchResultPage searchResultPage;
		protected String baseUrl = "http://demo.yo-meals.com/";
		protected String email = "customer@dummyid.com";
		protected String password = "12345678a";
		protected SoftAssert softAssert;

		@BeforeMethod
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
			this.driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			this.waiter = new WebDriverWait (driver,10);
			js = (JavascriptExecutor) driver;
			popUpPage = new LocationPopUpPage (driver,waiter,js);
			loginPage = new LoginPage (driver,waiter,js);
			notification = new NotificationSistemPage (driver,waiter,js);
			profilePage = new ProfilePage (driver,waiter,js);
			authPage = new AuthPage (driver,waiter,js);
			mealPage = new MealPage (driver,waiter,js);
			cartSummary = new CartSummaryPage (driver,waiter,js);
			searchResultPage = new SearchResultPage (driver,waiter,js);
			SoftAssert softAssert = new SoftAssert();
			
		}

	@AfterMethod
	public void cleanup(ITestResult results) throws IOException {
		if (ITestResult.FAILURE == results.getStatus()) {

			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.png'").format(new Date());
			FileHandler.copy(source, new File("screenshots/" + results.getName() + "--" + fileName));
		}
		
	      this.driver.quit();

	}
}
