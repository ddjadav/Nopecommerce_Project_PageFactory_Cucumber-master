package Test_Runner.Steps;

import NopecommerceProject.Utilities.DriverManager;
import NopecommerceProject.Utilities.LoadProperties;
import NopecommerceProject.Page.LoginPage;
import NopecommerceProject.Page.Registrationpage;
import NopecommerceProject.Utilities.Utils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by kaival on 30/11/2016.
 */
public class LoginSteps extends DriverManager{

//    @Before
//    public static void open() throws Exception {
        // String browser = LoadProperties.getProperty("Browser");
//        String browser = System.getProperty("browser");
//        System.out.println(browser);
//        if (browser.equalsIgnoreCase("IE")) {
//            DriverManager.openBrowser(browser);
//
//        } else {
//            DriverManager.openBrowser(browser);
//        }
//    }

//    @After
//    public static void close(){
//
//
//        DriverManager.closeBrowser();
//
//    }

    @Given("^user open browser and goto Nopecommerce website$")
    public void user_open_browser_and_goto_Nopecommerce_website() throws Throwable {
        String browser = System.getProperty("browser");
        DriverManager.openBrowser(browser);
        Registrationpage registrationpage=new Registrationpage();

        registrationpage.clickonregistrationlink();
        registrationpage.register();
        registrationpage.clickOnRegisterBtn();
        registrationpage.logout();
    }

    @When("^user click on Login link$")
    public void user_click_on_Login_link() throws Throwable {
        LoginPage loginPage = new LoginPage();
        loginPage.login_nopecommerce();
    }

    @When("^user enter valid Username and valid Password$")
    public void user_enter_valid_Username_and_valid_Password() throws Throwable {
        LoginPage loginPage = new LoginPage();
        loginPage.EnterLoginDetails();
    }

    @When("^user click on Login button$")
    public void user_click_on_Login_button() throws Throwable {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnLoginBtn();
    }

    @Then("^user should successfully logged in$")
    public void user_should_successfully_logged_in() throws Throwable {
        LoginPage loginPage = new LoginPage();
        Registrationpage registration =new Registrationpage();
        Utils.webDriverWaitImplicitly(10);
        Assert.assertEquals(loginPage.getLoginAccountInfo(),registration.actext,"\n User Successfully Logged in");
        registration.logout();
        DriverManager.closeBrowser();

    }
}
