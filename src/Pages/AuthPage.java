package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getDropDownBtn () {
		return this.driver.findElement(By.xpath("//*[@class=\"accounts-link accounts-popup\"]/ul/li/a"));
	}
	
	public WebElement getMyAccount () {
		return this.driver.findElement(By.xpath("//*[@class=\"my-account-dropdown\"]/ul/li/a"));
	}
	
	public void logOutUser () {
		this.getDropDownBtn().click();
		this.driver.findElement(By.xpath("//*[@class=\"my-account-dropdown\"]/ul/li[2]/a")).click();
	}

}
