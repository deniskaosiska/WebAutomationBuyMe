package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreen extends BasePage{
    public static WebDriver driver;
    public HomeScreen(){
        this.driver = SingletonDriver.getDriverInstance();
    }

    public void logIn(){
        new HomeScreen();
        clickElement(Constants.LogIn);
        sendKeysToElement(Constants.Mail, Constants.UserName);
        sendKeysToElement(Constants.Password, Constants.Pass);
        driver.findElement(By.cssSelector(".ember-view[placeholder='סיסמה']")).submit();
    }
    public void pickPresent(){
        clickElement(By.xpath("//*[@id=\"ember978_chosen\"]/a"));
        clickElement(By.xpath("//*[@id=\"ember978_chosen\"]/div/ul/li[3]"));
        clickElement(By.xpath("//*[@id=\"ember993_chosen\"]/a"));
        clickElement(By.xpath("//*[@id=\"ember993_chosen\"]/div/ul/li[3]"));
        clickElement(By.xpath("//*[@id=\"ember1003_chosen\"]/a"));
        clickElement(By.xpath("//*[@id=\"ember1003_chosen\"]/div/ul/li[5]"));
        clickElement(By.xpath("//*[@id=\"ember1038\"]"));
    }

}
