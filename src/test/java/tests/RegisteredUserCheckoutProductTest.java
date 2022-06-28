package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


import java.time.Duration;

public class RegisteredUserCheckoutProductTest extends TestBase{
        /*
        * 1- Register user
        * 2- Search for product
        * 3- Add to cart
        * 4- checkout
        * 5- Logout
        * */
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    OrderDetailPage orderDetailPage;
    String firstName="wesam";
    String lastName="hamad";
    String email="test@test9.com";
    String password="12345678";

    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
        Assert.assertTrue(userRegistrationPage.successMessage.isDisplayed());
    }
    @Test(priority = 2)
    public void userCanSearchWithAutoSuggest(){
        searchPage = new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.productNameBreadcrumb.getText().equalsIgnoreCase(productName));
    }
    @Test(priority = 3)
    public void userCanAddProductToShoppingCart(){
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));
        driver.navigate().to("https://demo.nopcommerce.com/cart");
    }
    @Test(priority = 4)
    public void userCanCheckoutProduct() throws InterruptedException{
        checkoutPage = new CheckoutPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openCheckoutPage();
        checkoutPage.checkoutProduct("Palestine","test address",
                                            "123456789","32445566677","Cairo",productName);
        Assert.assertTrue(checkoutPage.productNameLink.isDisplayed());
        Assert.assertTrue(checkoutPage.productNameLink.getText().contains(productName));
        checkoutPage.confirmOrder();
        Assert.assertTrue(checkoutPage.successMessage.isDisplayed());
        checkoutPage.viewOrderDetails();
        Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
        orderDetailPage =new OrderDetailPage(driver);
        orderDetailPage.downloadPDFInvoice();
        orderDetailPage.printOrderDetails();
    }

    @Test(priority = 5)
    public void RegisteredUserCanLogout(){
        userRegistrationPage.userLogout();
    }
}