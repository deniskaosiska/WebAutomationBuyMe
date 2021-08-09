import Extra.Extra;
import Pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




/**
 * This is sanity tests for website Buyme.
 */
public class MainTest  {
    private static ExtentReports extent;
    private static ExtentTest test;
    public static WebDriver driver;
    HomeScreen homeScreen = new HomeScreen();
    SelectBusiness selectBusiness = new SelectBusiness();
    SenderAndReceiverScreen senderAndReceiverScreen = new SenderAndReceiverScreen();
    Extra extra = new Extra();


    @BeforeTest

    public  void beforeClass() throws Exception {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test=extent.createTest("MyFirstWebTestAutomation", "Sanity Test of website Buyme");
        test.log(Status.INFO, "before test method");
        try {
            SingletonDriver singletonDriver = new SingletonDriver();
            this.driver = singletonDriver.getDriverInstance();
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }
    }
    //
//    @Test
//    public void registration(){
//        test.log(Status.INFO, "Test of registration");
//        try {
//        RegistrationScreen registrationScreen = new RegistrationScreen();
//        registrationScreen.register();
//        test.log(Status.PASS, "Test is successful");
//        }catch(Exception e){
//            test.log(Status.FAIL, "Failed: " + e.getMessage());
//        }
//    }
    //Test of home screen: Log in, pick present
    @Test
    public void homeScreen(){
        test.log(Status.INFO, "Test of home screen: Log in, pick present, Log out");
        try {
        //getSizeOfSpinner();
        homeScreen.logIn();
        homeScreen.pickPresent();
        homeScreen.logOut();
        test.log(Status.INFO, "Text color of step name: "+driver.findElement(By.cssSelector("div[class='label bottom-xs']")).getCssValue("color"));
        test.log(Status.PASS, "Test is successful");
        }catch(Exception e){
            test.log(Status.FAIL, "Failed: " + e.getMessage());
        }

    }
    // Test of choosing business
    @Test
    public void pickBusiness(){
        test.log(Status.INFO, "Test of choosing business");
        try {
        homeScreen.pickPresent();
        selectBusiness.assertUrl();
        selectBusiness.pickBusiness();
        extra.scrollPage();
        test.log(Status.PASS, "Test is successful");
        }catch(Exception e){
            test.log(Status.FAIL, "Failed: " + e.getMessage());
        }

    }
    //Test of Sender and Receiver information data fill
    @Test
    public void receiverInfo() throws InterruptedException {
        test.log(Status.INFO, "Test of Sender and Receiver information data fill and assert sender and receiver names");
        try {
            //pickBusiness();//If user want to run only this test
            senderAndReceiverScreen.receiverInfo();
            senderAndReceiverScreen.senderInfo();
            test.log(Status.PASS, "Test is successful");
        }catch(Exception e){
            test.log(Status.FAIL, "Failed: " + e.getMessage());
        }
    }
    //Getting size of spinner. I tried to find how can I catch some element before disappear, actually using explacity/fluent, but i didn't..
    @Test
    public void getSizeOfSpinner(){
        Extra extra = new Extra();
        extra.spinnerSize();
    }
    //Assert Log error of Log in failed
    @Test
    public void assertErrorMessageLogIn(){
        test.log(Status.INFO, "Assert Log error if Log in failed");
        try {
        extra.assertHomeScreen();
        test.log(Status.PASS, "Test is successful");
        }catch(Exception e){
            test.log(Status.FAIL, "Failed: " + e.getMessage());
        }
    }
//Scroll down of pick business page
//    @Test
//    public void scrollDownPage() throws IOException {
//        test.log(Status.INFO, "Scroll down of pick business page");
//        try {
//        extra.scrollPage();
//        }catch(Exception e){
//            test.log(Status.FAIL, "Failed: " + e.getMessage());
//        }
//    }
    //Getting color of label Step name
//    @Test
//    public void  getColorStepName(){
//        test.log(Status.INFO, "Getting color of label Step name");
//        try {
//        extra.colorStepName();
//        }catch(Exception e){
//            test.log(Status.FAIL, "Failed: " + e.getMessage());
//        }
//    }


    @AfterClass
    public void afterClass(){
        extent.flush();
        driver.close();
        driver.quit();
    }
}
