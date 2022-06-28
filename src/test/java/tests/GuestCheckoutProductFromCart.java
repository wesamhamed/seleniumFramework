package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class GuestCheckoutProductFromCart extends TestBase{
    SearchPage searchPage;
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    OrderDetailPage orderDetailPage;
    String productName="Apple MacBook Pro 13-inch";
    String firstName="test";
    String lastName="user";
    String countryName ="Palestine";
    String email="test@test6.com";
    String address= "test address";
    String zipCode="123456789";
    String phone ="32445566677";
    String city ="Cairo";


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
    public void userCanCheckoutProduct() throws InterruptedException{
        checkoutPage = new CheckoutPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openCheckoutPageAsGuest();
        checkoutPage.checkoutProduct(firstName,lastName,countryName,email,
                address, zipCode,phone,city,productName);
        Assert.assertTrue(checkoutPage.productNameLink.isDisplayed());
        Assert.assertTrue(checkoutPage.productNameLink.getText().contains(productName));
        checkoutPage.confirmOrder();
        Assert.assertTrue(checkoutPage.successMessage.isDisplayed());
    }
    @Test(priority = 4)
    public void userCanViewOrderDetails() throws InterruptedException{
        checkoutPage.viewOrderDetails();
        Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
        orderDetailPage = new OrderDetailPage(driver);
        orderDetailPage.downloadPDFInvoice();
        Thread.sleep(2000);
        orderDetailPage.printOrderDetails();
    }
}