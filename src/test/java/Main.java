import Pages.HomeScreen;
import Pages.SelectBusiness;
import Pages.RegistrationScreen;
import Pages.SenderAndReceiverScreen;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Main {
    public static WebDriver driver;

//    @Test
//    public void registration(){
//        RegistrationScreen registrationScreen = new RegistrationScreen();
//        registrationScreen.register();
//    }
    @Test
    public void homeScreen(){
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.logIn();
        homeScreen.pickPresent();
    }
    @Test
    public void pickBusiness(){
        SelectBusiness selectBusiness = new SelectBusiness();
        selectBusiness.assertUrl();
        selectBusiness.pickBusiness();
    }
    @Test
    public void receiverInfo(){
        SenderAndReceiverScreen senderAndReceiverScreen= new SenderAndReceiverScreen();
        senderAndReceiverScreen.receiverInfo();
        senderAndReceiverScreen.senderInfo();

    }
}
