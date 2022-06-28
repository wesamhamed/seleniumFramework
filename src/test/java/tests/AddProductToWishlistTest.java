package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase{
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    WishlistPage wishlistPage;

    @Test(priority =1)
    public void userCanSearchWithAutoSuggest(){
        searchPage = new SearchPage(driver);
        productDetailsPage =new ProductDetailsPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        Assert.assertTrue(productDetailsPage.productNameBreadcrumb.getText().equalsIgnoreCase(productName));
    }
    @Test(priority=2)
    public void userCanAddProductToWishlist(){
        productDetailsPage= new ProductDetailsPage(driver);
        productDetailsPage.addProductToWishlist();
        productDetailsPage.navigateToWishlistPage();
        wishlistPage=new WishlistPage(driver);
        driver.navigate().to("https://demo.nopcommerce.com"+"/wishlist");
        Assert.assertTrue(wishlistPage.wishlistHeader.isDisplayed());
        Assert.assertTrue(wishlistPage.productCell.getText().contains(productName));
    }
    @Test(priority=3)
    public void userCanRemoveProductFromCart(){
        wishlistPage=new WishlistPage(driver);
        wishlistPage.removeProductFromWishlist();
        Assert.assertTrue(wishlistPage.emptyCartLb1.getText().contains("The wishlist is empty!"));
    }
}