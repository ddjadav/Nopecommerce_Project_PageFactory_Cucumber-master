package NopecommerceProject.Page;

import NopecommerceProject.Utilities.DriverManager;
import NopecommerceProject.Utilities.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by welcome on 22/11/2016.
 */
public class ElectronicsPage extends DriverManager {

    @FindBy (linkText = "Electronics")
    private WebElement _electronics;

    @FindBy (xpath = "//ul[@class='sublist']/li/a")
    private WebElement _camera;

    @FindBy (xpath = "//a[text()='Apple iCam']")
    private WebElement _appleicam;

    @FindBy (id = "addtocart_17_EnteredQuantity")
    private WebElement _quantityicam;

    @FindBy (id="add-to-cart-button-17")
    private WebElement _addicam;

    @FindBy (xpath = "//div[@id='bar-notification']/p")
    private WebElement _confirmationmessagewindowofitemaddition;

    @FindBy (xpath = "//div[@id='bar-notification']/span")
    private WebElement _closeconfirmation;

    @FindBy (xpath = "//li[3]/span/a/span")
    private WebElement _backtocamera;

    @FindBy (xpath="//a[text()='Leica T Mirrorless Digital Camera']")
    private WebElement _DGcam;

    @FindBy(id = "addtocart_16_EnteredQuantity")
    private WebElement _quantityDGcam;

    @FindBy (id="add-to-cart-button-16")
    private WebElement _addDGcam;


    @FindBy (className = "cart-label")
    private WebElement _shoppingbasket;

    @FindBy (xpath = "//h1[text()='Shopping cart']")
    private WebElement _textshoppingcart;

    @FindBy (linkText = "Nikon D5500 DSLR")
    private WebElement _nikon;

    @FindBy (id = "addtocart_15_EnteredQuantity")
    private WebElement _nikonred;

    @FindBy (id = "add-to-cart-button-15")
    private WebElement _nikonredaddbtn;

    @FindBy (xpath = "//tr/td/input")
    private WebElement _removeNikon;

    @FindBy(xpath = "//tr[2]/td[5]/input")
    private WebElement _updateicamquantiy;

    @FindBy(xpath ="//div[@class='cart-options']/div/input" )
    private WebElement _updatecartbtn;

    @FindBy (xpath = "//tr/td[6]/span")
    private WebElement _totalOfItem1;

    @FindBy (xpath="//tr[2]/td[6]/span")
    private WebElement _totalOfItem2;

    @FindBy (xpath = "//tr/td[2]/span")
    private WebElement _subtotal;

    public void addtocart () throws InterruptedException {

        Utils.clickOnElement(_electronics);
        Thread.sleep(2000);
        Utils.clickOnElement(_camera);
        //Utils.clickOnElement(_camera);
        Utils.clickOnElement(_nikon);
        Utils.enterText(_nikonred,"1");
        Utils.driverWaitUntilElementisClickable(_nikonredaddbtn,5);
        Utils.clickOnElement(_nikonredaddbtn);
        Utils.driverWaitUntilElementisClickable(_confirmationmessagewindowofitemaddition,5);
        Assert.assertEquals(Utils.get_Text(_confirmationmessagewindowofitemaddition),"The product has been added to your shopping cart");
        Utils.driverWaitUntilElementisClickable(_closeconfirmation,10);
        Utils.clickOnElement(_closeconfirmation);
        Utils.clickalert();
        Thread.sleep(1500);
        Utils.clickOnElement(_backtocamera);
        Utils.clickOnElement(_appleicam);
        Utils.enterText(_quantityicam,"6");
        Utils.clickOnElement(_addicam);
        Assert.assertEquals(Utils.get_Text(_confirmationmessagewindowofitemaddition),"The product has been added to your shopping cart");
        Utils.clickOnElement(_closeconfirmation);
        Utils.clickalert();
        Thread.sleep(1500);
        Utils.clickOnElement(_backtocamera);
        Utils.clickOnElement(_DGcam);
        Utils.enterText(_quantityDGcam,"1");
        Utils.clickOnElement(_addDGcam);
        Assert.assertEquals(Utils.get_Text(_confirmationmessagewindowofitemaddition),"The product has been added to your shopping cart");
        Utils.clickOnElement(_closeconfirmation);
        Utils.clickalert();

    }
    public void goToCart () throws InterruptedException {
        Thread.sleep(1500);
        Utils.clickOnElement(_shoppingbasket);
        Assert.assertEquals(Utils.get_Text(_textshoppingcart),"Shopping cart");
        Utils.clickOnElement(_removeNikon);             // Checking if item reove function works
        Utils.enterText(_updateicamquantiy,"1");        //checking if update quantity function works
        Utils.clickOnElement(_updatecartbtn);

    }
    public  void cart_SubTotal (){
        float subtotal =Utils.cartSubTotal(_totalOfItem1)+ Utils.cartSubTotal(_totalOfItem2);
      //  System.out.println(subtotal);
        float actualtotal = Utils.cartSubTotal(_subtotal);   // This checks if the total of added items is correct or not before delivery charges.
        Assert.assertEquals(actualtotal,subtotal);
        System.out.println("Total of two items added is correct."+"\n" +
                "(Item 1) "+Utils.cartSubTotal(_totalOfItem1)+" + (Item 2)"+ Utils.cartSubTotal(_totalOfItem2)+" ="+actualtotal);


    }
}






