package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.LocationPopUpPage;
import Pages.LoginPage;
import Pages.NotificationSistemPage;

	
	public abstract class BasicTest {
		
		protected WebDriver driver;
		protected LocationPopUpPage popUpPage;
		protected LoginPage loginPage;
		protected NotificationSistemPage notification;
		protected WebDriverWait waiter;
		protected JavascriptExecutor js;
		

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
			
		}

	//	@AfterMethod
	//	public void cleanup() {
	//		this.driver.quit();
	//	}

	}

