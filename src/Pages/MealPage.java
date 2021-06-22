package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}

	public WebElement getQuantity() {
		return this.driver.findElement(By.name("product_qty"));
	}

	public WebElement getAddToCart() {
		return this.driver.findElement(
				By.xpath("//div[@class='d-flex align-items-center justify-content-between flex-lg--col']/a"));
	}

	public void AddMealToCart(int quantity) throws InterruptedException {
		String qt = Integer.toString(quantity);
		Thread.sleep(5000);
		this.getQuantity();
		this.getQuantity().sendKeys(Keys.DELETE);
		this.getQuantity().sendKeys(qt);
		this.getAddToCart().click();
	}

	public void addToFavorite() {
		WebElement favoriteBtn = this.driver.findElement(By.id("item_119"));
		favoriteBtn.click();

	}

}
