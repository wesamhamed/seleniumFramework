package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

import java.time.Duration;

public class AddProductToShoppingCartTest extends TestBase{
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    String productName ="Apple MacBook Pro 13-inch";
    @Test(priority = 1)
    public void userCanSearchWithAutoSuggest(){
        searchPage = new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.productNameBreadcrumb.getText().equalsIgnoreCase(productName));
    }
    @Test(priority = 2)
    public void userCanAddProductToShoppingCart(){
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));
        driver.navigate().to("https://demo.nopcommerce.com/cart");
    }
    @Test(priority = 3)
    public void userCanRemoveProductFromCart(){
        shoppingCartPage = new ShoppingCartPage(driver);
         shoppingCartPage.removeProductFromCart();
    }
}