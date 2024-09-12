package test;

import base.TestBase;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;

public class ItemPageTest extends TestBase {
    private ItemPage itemPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUpLogin() {
        loginPage = new LoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");

        homePage = new HomePage(driver);
        homePage.clickItemByIndex(0);

        // Initialize itemPage after navigating to the item
        itemPage = new ItemPage(driver);
    }


    @Test
    public void addToCart() {
        itemPage.addToCart();
    }

    @Test
    public void backToHome() {
        itemPage.backToHome();
        checkUrl("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void navigateToCart() {
        itemPage.navigateToCart();
        checkUrl("https://www.saucedemo.com/v1/cart.html");
    }
    @Test
    public void clickMenu(){
        homePage.LogOut();
    }
}
