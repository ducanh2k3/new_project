package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    By backButtonLocator = By.className("inventory_details_back_button");
    By addToCartButtonLocator = By.xpath("//button[normalize-space()='ADD TO CART']");

    WebElement backButton = findElement(backButtonLocator);
    WebElement addToCartButton = findElement(addToCartButtonLocator);
WebElement myCart = findElement(myCartLocator);


    public void addToCart() {
        click(addToCartButton);
     checkAddToCart(addToCartButton,"REMOVE");
    }

    public void backToHome() {
        click(backButton);
    }

    public void navigateToCart() {
        click(myCart);
    }

}
