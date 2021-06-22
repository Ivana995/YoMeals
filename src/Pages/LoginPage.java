package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
	super(driver, waiter, js);
	}
	
	public WebElement getEmail () {
		return this.driver.findElement(By.name("username"));
}
	
	public WebElement getPassword () {
		 return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getSubmitBtn () {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	public void logIn (String email, String password) {
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getSubmitBtn().click();
	}
}
