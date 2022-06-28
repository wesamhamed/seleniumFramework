package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id="BillingNewAddress_FirstName")
    WebElement firstNameTxt;
    @FindBy(id="BillingNewAddress_LastName")
    WebElement lastNameTxt;
    @FindBy(id="BillingNewAddress_Email")
    WebElement emailTxt;
    @FindBy(id="BillingNewAddress_CountryId")
    WebElement countryList;
    @FindBy(id="BillingNewAddress_City")
    WebElement cityTxt;
    @FindBy(id="BillingNewAddress_Address1")
    WebElement address1Txt;
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    WebElement zipCodeTxt;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement phoneTxt;
    @FindBy(css = "#billing-buttons-container [name='save']")
    WebElement continueBtn;
    @FindBy(id="shippingoption_1")
    WebElement shippingMethodRdo;
    @FindBy(css = "#shipping-method-buttons-container button")
    WebElement continueShippingBtn;
    @FindBy(css="#payment-method-buttons-container button")
    WebElement continuePaymentBtn;
    @FindBy(css="#payment-info-buttons-container button")
    WebElement continueInfoBtn;
    @FindBy(css="a.product-name")
    public WebElement productNameLink;
    @FindBy(css = "#confirm-order-buttons-container button")
    WebElement confirmBtn;
    @FindBy(tagName = "h1")
    public WebElement thankYouLbl;
    @FindBy(css = ".order-completed .title strong")
    public WebElement successMessage;
    @FindBy(css = ".details .details-link a")
    WebElement orderDetailsLink;
    @FindBy(css="input.button-1.checkout-as-guest-button")
    WebElement guestBtn;

    public void checkoutProduct(String countryName,String address,
                                              String zipCode,String phone,String city,String productName)
                                                throws InterruptedException{
        select = new Select(countryList);
        select.selectByVisibleText(countryName);
        setTextElementText(cityTxt,city);
        setTextElementText(address1Txt,address);
        setTextElementText(zipCodeTxt,zipCode);
        setTextElementText(phoneTxt,phone);
        clickButton(continueBtn);
        clickButton(shippingMethodRdo);
        clickButton(continueShippingBtn);
        Thread.sleep(1000);
        clickButton(continuePaymentBtn);
        Thread.sleep(1000);
        clickButton(continueInfoBtn);
    }

    public void checkoutProduct(String firstName,String lastName,String countryName,String email,String address,
                                              String zipCode,String phone,String city,String ProductName)
                                                throws InterruptedException{
        setTextElementText(firstNameTxt,firstName);
        setTextElementText(lastNameTxt,lastName);
        setTextElementText(emailTxt,email);
        select = new Select(countryList);
        select.selectByVisibleText(countryName);
        setTextElementText(cityTxt,city);
        setTextElementText(address1Txt,address);
        setTextElementText(zipCodeTxt,zipCode);
        setTextElementText(phoneTxt,phone);
        clickButton(continueBtn);
        clickButton(shippingMethodRdo);
        clickButton(continueShippingBtn);
        Thread.sleep(1000);
        clickButton(continuePaymentBtn);
        Thread.sleep(1000);
        clickButton(continueInfoBtn);
    }
    public void confirmOrder() throws InterruptedException {
        Thread.sleep(1000);
        clickButton(confirmBtn);
    }
    public void viewOrderDetails() {
        clickButton(orderDetailsLink);
    }
    public void printOrder(){

    }
}