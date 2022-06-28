package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "td.product")
    public WebElement productCell;
    @FindBy(css = "h1")
    public WebElement wishlistHeader;
    @FindBy(name="updatecart")
    WebElement updateWishlistBtn;
    @FindBy(css = "td.remove-from-cart [name='updatecart']")
    WebElement removeFromCartIcon;
    @FindBy(css = "div.no-data")
    public WebElement emptyCartLb1;
    public void removeProductFromWishlist(){
        clickButton(removeFromCartIcon);

    }
}