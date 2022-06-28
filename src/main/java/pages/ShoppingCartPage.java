package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = ".remove-from-cart [name='updatecart']")
    WebElement removeIcon;
    @FindBy(css = ".common-buttons [name='updatecart']")
    WebElement updateCartBtn;
    @FindBy(css = "td.quantity input")
    public WebElement quantityTxt;
    @FindBy(css = "td.subtotal")
    public WebElement totalLbl;
    @FindBy(id="checkout")
    WebElement checkoutBtn;
    @FindBy(id="termsofservice")
    WebElement agreeCheckbox;
    @FindBy(css = ".checkout-as-guest-or-register-block .buttons button.checkout-as-guest-button")
    public WebElement guestBtn;

    public void removeProductFromCart(){
        clickButton(removeIcon);
    }
    public void updateProductQuantityInCart(String quantity){
        clearText(quantityTxt);
        setTextElementText(quantityTxt,quantity);
        clickButton(updateCartBtn);
    }
    public void openCheckoutPage(){
        clickButton(agreeCheckbox);
        clickButton(checkoutBtn);
    }
    public void openCheckoutPageAsGuest()
    {
        clickButton(agreeCheckbox);
        clickButton(checkoutBtn);
        clickButton(guestBtn);
    }
}