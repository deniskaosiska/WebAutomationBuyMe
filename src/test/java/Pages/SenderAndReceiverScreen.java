package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SenderAndReceiverScreen extends BasePage{

    public static WebDriver driver;

    public SenderAndReceiverScreen(){
        this.driver=SingletonDriver.getDriverInstance();
    }
    public void receiverInfo(){
        clickElement(By.xpath("//*[@id=\"ember1733\"]"));
        sendKeysToElement(By.id("friendName"), "אסתר");
        clickElement(By.xpath("//*[@id=\"ember1821\"]/div/div[1]/span"));
        clickElement(By.xpath("//*[@id=\"ember1867\"]/span"));
        sendKeysToElement(By.xpath("//*[@id=\"ember1750\"]/textarea"), "מזל טוב לחתונה");
        //Place to upload picture
        driver.findElement(By.xpath("//*[@id=\"ember1733\"]")).submit();
    }
    public void senderInfo(){
        clickElement(By.xpath("//*[@id=\"ember1906\"]/div[2]/div[1]/svg/path[2]"));
        sendKeysToElement(By.xpath("//*[@id=\"email\"]"),Constants.UserName);
        sendKeysToElement(By.xpath("//*[@id=\"ember1926\"]"),"דניס");
    }
    public void assertSenderName(){
        String SenderName = driver.findElement(By.xpath("//*[@id=\"ember1926\"]")).getText();
        Assert.assertEquals(SenderName, "דניס");
    }
    public void assertReceiverName(){
        String ReceiverName = driver.findElement(By.id("friendName")).getText();
        Assert.assertEquals(ReceiverName, "אסתר");
    }
}
