package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelectBusiness extends BasePage {
    public static WebDriver driver;

    public SelectBusiness(){
        this.driver = SingletonDriver.getDriverInstance();
    }

    public void assertUrl(){
        String CurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(CurrentUrl, "https://buyme.co.il/search?budget=2&category=8&region=11");
    }
    public void pickBusiness(){
        clickElement(By.xpath("//*[@id=\"ember1645\"]/div[2]"));
        clickElement(By.id("ember1824"));
    }

}
