package NopecommerceProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by kaival on 30/11/2016.
 */
public class BrowserFactory extends DriverManager{
    public static WebDriver GetBrowser(String browserName)throws Exception {
        if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }

        else if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/test/resources/BrowserDrivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if(browserName.equalsIgnoreCase("ie")){
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            System.setProperty("webdriver.ie.driver","src/test/resources/BrowserDrivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver(capabilities);
        }

        else{
            throw new Exception("Browser is not correct");

        }

        return driver;
    }
    public static void zoomIn(){
        //To zoom In page 6 time using CTRL and + keys.
        for(int i=0; i<6; i++){
            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
        }
    }
}
