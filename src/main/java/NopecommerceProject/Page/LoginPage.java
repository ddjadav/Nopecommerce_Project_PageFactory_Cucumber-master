package NopecommerceProject.Page;

import NopecommerceProject.Utilities.DriverManager;
import NopecommerceProject.Utilities.LoadProperties;
import NopecommerceProject.Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by welcome on 21/11/2016.
 */
public class LoginPage extends DriverManager {

    @FindBy (className = "ico-login")
    private WebElement _Loginbtn;

    @FindBy (id="Email")
    public WebElement _Enteremail;

    @FindBy (id= "Password")
    private WebElement _EnterPassword;

    @FindBy (xpath ="//input[@value='Log in']")
    private WebElement _Submitbtn;

    @FindBy (xpath = "//div[@class='page-title']/h1")
    private WebElement _getPageTitle;

    @FindBy (xpath = "//a[@class='ico-account']")
    private WebElement _getLoginAccount;

    String Password= LoadProperties.getProperty("Password");

    public String getpageTitle (){
       return Utils.get_Text(_getPageTitle);
    }

    public  void login_nopecommerce (){

        Utils.clickOnElement(_Loginbtn);
    }

    public void EnterLoginDetails() {
        Registrationpage registration = new Registrationpage();
        String acText = registration.actext;
        Utils.enterText(_Enteremail,acText);
        Utils.enterText(_EnterPassword,Password);
    }

    public void clickOnLoginBtn() {
        Utils.clickOnElement(_Submitbtn);
    }

    public String getLoginAccountInfo(){
        return Utils.get_Text(_getLoginAccount);
    }



}
