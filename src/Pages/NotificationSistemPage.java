package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	public NotificationSistemPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);	
	}
	
	public WebElement getMessage () {
		return this.waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]")));
	}
	
	public String getMessageText () {
		return this.getMessage().getText();
	}
	
	public void waitUntilNotificationDisapear () {
		this.waiter.until(ExpectedConditions.attributeContains(By.xpath(" //*[contains(@class, 'system_message')]"), "style", "display: none;"));
				
	}

}
