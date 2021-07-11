import Pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * This is sanity tests for website Buyme.
 */
public class MainTest {
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstWebTestAutomation", "Sanity Test of website Buyme");
    public static WebDriver driver;

    @BeforeTest
    public  void beforeClass(){
        SingletonDriver singletonDriver = new SingletonDriver();
        this.driver = singletonDriver.getDriverInstance();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");
    }

//    @Test
//    public void registration(){
//        RegistrationScreen registrationScreen = new RegistrationScreen();
//        registrationScreen.register();
//    }
    //Test of home screen: Log in, pick present
    @Test
    public void homeScreen(){
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.logIn();
        homeScreen.pickPresent();
    }
    // Test of choosing business
    @Test
    public void pickBusiness(){
        SelectBusiness selectBusiness = new SelectBusiness();
        selectBusiness.assertUrl();
        selectBusiness.pickBusiness();
    }
    //Test of Sender and Receiver information data fill
    @Test
    public void receiverInfo(){
        SenderAndReceiverScreen senderAndReceiverScreen= new SenderAndReceiverScreen();
        senderAndReceiverScreen.receiverInfo();
        senderAndReceiverScreen.senderInfo();

    }
    //Getting size of spinner
    //@Test
    public void getSizeOfSpinner(){
        Extra extra = new Extra();
        extra.spinnerSize();
    }
    //Assert Log error of Log in failed
    //@Test
    public void assertErrorMessageLogIn(){
        Extra extra = new Extra();
        extra.assertHomeScreen();
    }
//Scrool down of pick business page
    //@Test
    public void scrollDownPage() throws IOException {
        Extra extra = new Extra();
        extra.scrollPage();
    }



//    @AfterClass
//    public void afterClass(){
//        driver.close();
//        driver.quit();
//    }
}
