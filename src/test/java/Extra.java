import Pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class Extra extends BasePage {
    private WebDriver driver;

    //Getting driver from SingeltonDriver
    public Extra(){
        this.driver = SingletonDriver.getDriverInstance();
    }
    // Getting size of spinner
    public void spinnerSize(){

    System.out.println(driver.findElement(By.xpath("//*[@id=\"app-loading-img\"]/div")).getRect().getWidth());
    System.out.println(driver.findElement(By.xpath("//*[@id=\"app-loading-img\"]/div")).getRect().getHeight());
}
        public void assertHomeScreen(){

            clickElement(Constants.LogIn);
            driver.findElement(By.cssSelector(".ember-view[placeholder='סיסמה']")).submit();
            String errorActualMail = driver.findElement(By.xpath("//*[@id=\"parsley-id-12\"]/li")).getText();
            String errorActualPass = driver.findElement(By.xpath("//*[@id=\"parsley-id-14\"]/li")).getText();
            String errorExcepted = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
            Assert.assertEquals(errorActualMail, errorExcepted);
            Assert.assertEquals(errorActualPass, errorExcepted);
        }

        public void scrollPage() throws IOException {
            SelectBusiness selectBusiness = new SelectBusiness();
            selectBusiness.pickBusiness();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            timestamp();
            FileUtils.copyFile(scrFile, new File("element-screenshot"+ timestamp()+".png"));
        }


}

