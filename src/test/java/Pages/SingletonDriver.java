package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class SingletonDriver {

    private static WebDriver driver;
//Singelton of driver and getting info from data.xml
    public static WebDriver getDriverInstance(){
        if(driver == null){
            try {
                String URL = getData("websiteURL");
                String BrowserType = getData("browserType");
                if(BrowserType.equals("Chrome")){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.get(URL);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }else if(BrowserType.equals("FireFox")){
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.get(URL);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
    //Getting info from data.xml by tag
    private static String getData (String keyName) throws Exception{
        ClassLoader classLoader = SingletonDriver.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
