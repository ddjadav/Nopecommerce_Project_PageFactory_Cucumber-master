package NopecommerceProject;

import NopecommerceProject.Page.ElectronicsPage;
import NopecommerceProject.Page.LoginPage;
import NopecommerceProject.Page.PaymentPage;
import NopecommerceProject.Page.Registrationpage;
import NopecommerceProject.Utilities.DriverManager;
import NopecommerceProject.Utilities.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by welcome on 21/11/2016.
 */
public class TestSuit extends DriverManager {



    @BeforeMethod
    public static void open() throws Exception {
       // String browser = LoadProperties.getProperty("Browser");
          String browser = System.getProperty("browser");

            DriverManager.openBrowser(browser);

    }

    @AfterMethod
    public void tearDown(ITestResult result){
    // Here will compare if test is failing then only it will enter into if condition
        String browser = System.getProperty("browser");
        if(ITestResult.FAILURE==result.getStatus()){
            try{
                // Create refernce of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)driver;
                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("src/test/resources/Screenshots/"+result.getName()+Utils.randomdate()+"("+browser+").png"));
                //System.out.println("Screenshots taken");
            }
            catch (Exception e){
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
            // close application
        DriverManager.closeBrowser();
    }

//    public static void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("src/test/resources/Screenshots/"));
//            DriverManager.closeBrowser();
//        }
//        DriverManager.closeBrowser();
//
//    }


    @Test
    public static void useronHomepage(){
        Registrationpage registration = new Registrationpage();
        Assert.assertEquals(registration.homepage(),"Welcome to our store");
    }

    @Test
    public void userIsabletoRegister(){

        Registrationpage registration = new Registrationpage();
        registration.clickonregistrationlink();
        Assert.assertEquals(registration.registrationPage(),"Register");
        registration.register();
        registration.clickOnRegisterBtn();
        Assert.assertTrue(registration.registrationSuccessfulMessage(),"Your registration completed");
        registration.logout();
    }



    @Test
    public static void userLoggedin (){
        Registrationpage registration =new Registrationpage();
        LoginPage loginpage = new LoginPage();
        registration.clickonregistrationlink();
        registration.register();
        registration.clickOnRegisterBtn();
        registration.logout();
        loginpage.login_nopecommerce();
        Assert.assertEquals(loginpage.getpageTitle(),"Welcome, Please Sign In!","\n User on Login page");
        loginpage.EnterLoginDetails();
        loginpage.clickOnLoginBtn();
        Utils.webDriverWaitImplicitly(5);
        Assert.assertEquals(loginpage.getLoginAccountInfo(),registration.actext,"\n User Successfully Logged in");

    }

    @Test
    public static void itemsinCart () throws InterruptedException {
        Registrationpage registration =new Registrationpage();
        registration.clickonregistrationlink();
        registration.register();
        registration.clickOnRegisterBtn();
        ElectronicsPage electronicsPage = new ElectronicsPage();
        electronicsPage.addtocart();
        electronicsPage.goToCart();
        electronicsPage.cart_SubTotal();


    }

    @Test
    public static void payment () throws InterruptedException {
        Registrationpage registration =new Registrationpage();
        registration.clickonregistrationlink();
        registration.register();
        registration.clickOnRegisterBtn();
        ElectronicsPage electronicsPage = new ElectronicsPage();
        electronicsPage.addtocart();
        electronicsPage.goToCart();
        electronicsPage.cart_SubTotal();
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.checkout();
       // paymentPage.getconfirmationmessage();
       // System.out.println(paymentPage.getconfirmationmessage());
        Assert.assertEquals(paymentPage.getconfirmationmessage(),"Your order has been successfully processed!");
        registration.logout();
    }

    @Test
    public void thomascook() throws InterruptedException {
        driver.findElement(By.id("accept-cookies")).click();
        Assert.assertEquals("Thomas Cook | Package Holidays, Hotels and Flights, Cheap holidays",driver.getTitle());

        driver.findElement(By.xpath("//div[@id='SearchbarForm-originContainer']/div/div/div/tc-typeahead/div/div[2]")).click();
        WebElement departFrom = driver.findElement(By.id("SearchbarForm-origin"));
        //Utils.driverWaitExplicitly(element,5);
        Utils.enterText(departFrom,"lon");
       // Thread.sleep(3000);
        Utils.mousehover(driver.findElement(By.xpath("//tc-typeahead/div/div/div/ul/li")));
        driver.findElement(By.xpath("//div[@id='SearchbarForm-destinationContainer']/div/div/div/tc-typeahead/div/div[2]")).click();
        WebElement arriveTo = driver.findElement(By.id("SearchbarForm-goingTo"));
        Utils.enterText(arriveTo,"por");
        Thread.sleep(1000);
        Utils.mousehover(driver.findElement(By.xpath("//div[@id='SearchbarForm-destinationContainer']/div/div/div/tc-typeahead/div/div/div/div/ul/li")));
        Thread.sleep(1000);
        Utils.clickOnElement(driver.findElement(By.id("when")));
       // Utils.clickOnElement(driver.findElement(By.xpath("//a[2]/span")));
       // Utils.clickOnElement(driver.findElement(By.xpath("//a[2]/span")));
        Utils.selectElementByVisibletext(driver.findElement(By.className("ui-datepicker-month")),"Aug");

        Utils.clickOnElement(driver.findElement(By.xpath("//tr[4]/td[6]/a")));
        Utils.selectElementByIndex(driver.findElement(By.id("SearchbarRooms-adults0")),1);
        Utils.selectElementByValue(driver.findElement(By.id("SearchbarRooms-children0")),"number:2");
        Utils.selectElementByVisibletext(driver.findElement(By.id("SearchbarChildAge-age0-0")),"10");
        Utils.selectElementByVisibletext(driver.findElement(By.id("SearchbarChildAge-age0-1")),"5");
        Utils.clickOnElement(driver.findElement(By.id("SearchbarChildAge-apply")));
       // Utils.clickOnElement(driver.findElement(By.xpath("//div[3]/div/label")));
        Utils.clickOnElement(driver.findElement(By.id("SearchbarForm-submitBtn")));
        Thread.sleep(5000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.id("SearchbarReadonly-origin")).getText(),"Any London","Flying From is Not Correct");
        softAssert.assertEquals(driver.findElement(By.id("SearchbarReadonly-goingTo")).getText(),"Portugal, Any","Where To is Not Correct");
        softAssert.assertEquals(driver.findElement(By.id("SearchbarReadonly-when")).getText(),"26 Aug 2017","Date is Not Correct");
        softAssert.assertEquals(driver.findElement(By.id("SearchbarReadonly-value0")).getText(),"Room 1: 2 Adults, 2 Children","Rooms and Passanger count is Not Correct");
//        Assert.assertEquals(driver.findElement(By.id("SearchbarReadonly-origin")).getText(),"Any London","Flying From is Not Correct");
//        Assert.assertEquals(driver.findElement(By.id("SearchbarReadonly-goingTo")).getText(),"Portugal, Any","Where To is Not Correct");
//        Assert.assertEquals(driver.findElement(By.id("SearchbarReadonly-when")).getText(),"26 Aug 2017","Date is Not Correct");
//        Assert.assertEquals(driver.findElement(By.id("SearchbarReadonly-value0")).getText(),"Room 1: 2 Adults, 2 Children","Rooms and Passanger count is Not Correct");
        List<WebElement>hotelNames = driver.findElements(By.xpath("//div[@id='searchResults']/div"));
        for (int i =2 ; i <=hotelNames.size()-1 ; i++) {
            System.out.println("("+(i-1)+") "+driver.findElement(By.xpath("//div[@id='searchResults']/div["+i+"]/div/div/h4/div")).getText());
        }
        System.out.println("Total "+(hotelNames.size()-2)+" Hotels Found on this page");
        Utils.clickOnElement(driver.findElement(By.xpath("//div/div/div[2]/div[2]/div/label")));

        Thread.sleep(5000);
        softAssert.assertAll();
        System.out.println("git");
    }



}
