package NopecommerceProject.Page;

import NopecommerceProject.Utilities.DriverManager;
import NopecommerceProject.Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by welcome on 23/11/2016.
 */
public class PaymentPage extends DriverManager {
    @FindBy (id="termsofservice")
    private WebElement _termsofService;

    @FindBy (id="checkout")
    private WebElement _checkbtn;

    @FindBy (xpath = "//div/div/div/div/h1")
    private WebElement _checktext;

    @FindBy (id ="BillingNewAddress_CountryId")
    private WebElement _country;

    @FindBy (id = "BillingNewAddress_City")
    private WebElement _city;

    @FindBy (id="BillingNewAddress_Address1")
    private WebElement _adressline1;

    @FindBy (id="BillingNewAddress_ZipPostalCode")
    private WebElement _zipcode;

    @FindBy (id = "BillingNewAddress_PhoneNumber")
    private WebElement _phone;

    @FindBy (xpath = "//div[@id='billing-buttons-container']/input")
    private WebElement _continuebtn;

    @FindBy (xpath = "//div[@id='shipping-method-buttons-container']/input")
    private WebElement _continuebtnshipping;

    @FindBy (xpath = "//input[@id='paymentmethod_1']")
    private WebElement _creditcard;

    @FindBy (xpath = "//div[@id='payment-method-buttons-container']/input")
    private WebElement _continuecreditcard;

    @FindBy (id = "CreditCardType")
    private WebElement _creditcardtype;

    @FindBy (id="CardholderName")
    private WebElement _cardholdername;

    @FindBy (id ="CardNumber")
    private WebElement _cardnumber;

    @FindBy (id="ExpireMonth")
    private WebElement _expirymonth;

    @FindBy (id="ExpireYear")
    private WebElement _expyear;

    @FindBy (id="CardCode")
    private WebElement _cardcode;

    @FindBy (xpath = "//div/input[@onclick='PaymentInfo.save()']")
    private WebElement _continuepayment;

    @FindBy (xpath = "//div/input[@onclick='ConfirmOrder.save()']")
    private WebElement _confirmbtn;

    @FindBy (xpath = "//div[@class='center-1']/div/div[2]/div/div/strong")
    private WebElement _confirmationmessage;

    public void checkout () throws InterruptedException {
        Utils.clickOnElement(_termsofService);
        Utils.clickOnElement(_checkbtn);
        Assert.assertEquals(Utils.get_Text(_checktext),"Checkout");
        Utils.selectElementByValue(_country,"82");
        Utils.enterText(_city,"Wembley");
        Utils.enterText(_adressline1, "153 Explace");
        Utils.enterText(_zipcode,"HA8 9OF");
        Utils.enterText(_phone,"07654329887");
        Utils.clickOnElement(_continuebtn);
        Thread.sleep(1000);
        Utils.clickOnElement(_continuebtnshipping);
        Utils.clickOnElement(_creditcard);
        Utils.clickOnElement(_continuecreditcard);
        Utils.selectElementByValue(_creditcardtype,"MasterCard");
        Utils.enterText(_cardholdername, "Laxmi venepalli");
        Utils.enterText(_cardnumber,"5381240999027964");
        Utils.selectElementByValue(_expirymonth,"4");
        Utils.selectElementByValue(_expyear,"2017");
        Utils.enterText(_cardcode,"476");
        Utils.clickOnElement(_continuepayment);
        Thread.sleep(1000);
        Utils.clickOnElement(_confirmbtn);

    }
    public String getconfirmationmessage () throws InterruptedException {
        Thread.sleep(1000);
       return Utils.get_Text(_confirmationmessage);

    }
}
