package NopecommerceProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by welcome on 21/11/2016.
 */
public class DriverManager {

    protected static WebDriver driver;

    public DriverManager (){PageFactory.initElements(driver,this);}



    public static void openBrowser (String browserName) throws Exception {
        BrowserFactory browserFactory =new BrowserFactory();
        browserFactory.GetBrowser(browserName);
        driver.get(LoadProperties.getProperty("URL1"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeBrowser(){
        driver.quit();
    }



    public static void zoomIn(){
        //To zoom In page 6 time using CTRL and + keys.
        for(int i=0; i<6; i++){
            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
        }
    }

    public static void zoomOut(){
        //To zoom out page 6 time using CTRL and - keys.
        for(int i=0; i<6; i++){
            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        }
    }

    public static void set100(){
        //To set browser to default zoom level 100%
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
    }

//    public static void main(String[] args) {
//
//        set100();
//        System.out.println(driver.manage().window().getSize());
//    }

}
