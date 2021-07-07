package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {
    private WebElement getWebElement(By locator) {
        return SingletonDriver.getDriverInstance().findElement(locator);
    }

    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }
}
