package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css="strong.current-item")
    public WebElement productNameBreadcrumb;
    @FindBy(css="button.button-2.email-a-friend-button")
    WebElement emailFriendBtn;
    @FindBy(id="price-value-4")
    public WebElement productPriceLbl;
    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;
    @FindBy(id="add-to-wishlist-button-4")
    WebElement addToWishlistBtn;
    @FindBy(css = ".content a[href*='wishlist']")
    WebElement wishlistLink;
    @FindBy(css = "button.button-2.add-to-compare-list-button")
    WebElement addToCompareBtn;
    @FindBy(id="add-to-cart-button-4")
    WebElement addToCartBtn;

    public void openSendEmail(){
        clickButton(emailFriendBtn);
    }
    public void openAddReviewPage(){
        clickButton(addReviewLink);
    }
    public void addProductToWishlist(){
        clickButton(addToWishlistBtn);
    }
    public void navigateToWishlistPage(){
        clickButton(wishlistLink);
    }
    public void addProductToCompare(){
        clickButton(addToCompareBtn);
    }
    public void addToCart(){
         clickButton(addToCartBtn);
    }
}