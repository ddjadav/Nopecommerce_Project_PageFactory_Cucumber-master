package NopecommerceProject.Utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by welcome on 21/11/2016.
 */
public class Utils extends DriverManager {
    public static void enterText(WebElement element,String text){
      //  element.clear();
        element.sendKeys(text);

    }
    public static void clickOnElement (WebElement element){
        element.click();
    }
    public static String get_Text(WebElement element){
       return element.getText();
    }
    public static boolean isElement_Present(WebElement element){
         return element.isDisplayed();
    }

    public static void driverWaitExplicitly(WebElement element , int time){
        WebDriverWait explicitlyWait = new WebDriverWait(driver,time);
        explicitlyWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void driverWaitUntilElementisClickable(WebElement element,int time){
        WebDriverWait explicitlyWait = new WebDriverWait(driver,time);
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void webDriverWaitImplicitly(int time) {
        driver.manage().timeouts().implicitlyWait(time, SECONDS);
    }
    public static void selectElementByValue(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);

    }



    public static void selectElementByVisibletext(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);

    }

    public static void selectElementByIndex(WebElement element, int integer) {
        Select select = new Select(element);
        select.selectByIndex(integer);
    }
    public static String randomdate () {
        DateFormat format = new SimpleDateFormat("ddMMMyyHHmmss");
        return format.format(new Date());
    }
    public static void mousehover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
    public static void clickalert(){
        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling

        }
    }

    public  static float cartSubTotal (WebElement element){
        String totalofItem1 = Utils.get_Text(element);

        String result = totalofItem1.replaceAll("[$ ,]",""); // This will remove charechers from String and convert it to float whichcan be used for arithmatic

        float t =Float.parseFloat(result);


        return t;

    }

}
