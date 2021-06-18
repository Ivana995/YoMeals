package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopUpPage extends BasicPage {

	public LocationPopUpPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getLocationHeader () {
		return this.driver.findElement(By.xpath("//*[@class=\"location-search-wrapper\"]"));

	}
	
	public WebElement getCloseElement () {
		return waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='close-btn close-btn-white']")));
	}
	
	public WebElement getKeyword () {
		return this.driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement getLocationItem (String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput () {
		return this.driver.findElement(By.id("location_id"));
	}
	
	public WebElement getSubmit () {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	public void openPopUpDialog () {
		this.getLocationHeader().click();
	}
	
	public void setLocation (String locationName) {
		this.getKeyword().click();
		String locationValue = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", getLocationInput(), locationValue);
		js.executeScript("arguments[0].click()", this.getSubmit());
	}
	
	public void closeDialog () {
		this.getCloseElement().click();
	}
	
	
	

}
