package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By itemsLocator = By.xpath("(//div[@class='inventory_item'])");


    List<WebElement> items = findElements(itemsLocator);
    WebElement myCart = findElement(myCartLocator);

    public void clickItemByIndex(int index) {
        if (index >= 0 && index < items.size()) {
            WebElement item = items.get(index);

            WebElement itemLink = item.findElement(By.xpath(".//div[2]//a"));

            System.out.println("Clicking on item URL: " + itemLink.getAttribute("href"));

            click(itemLink);

        } else {

            System.out.println("Index out of bounds: " + index);
        }
    }

    public void addItemToCartByIndex(int index) {
        By addToCartButtonLocator = By.xpath("(//div[2]//div[3]//button[1])" + "[" + index + "]");
        WebElement addToCartButton = findElement(addToCartButtonLocator);
        System.out.println(addToCartButton.getText());
        click(addToCartButton);
        System.out.println(addToCartButton.getText());
        checkAddToCart(addToCartButton,"REMOVE");
    }

    public void navigateToMyCart() {
        click(myCart);
    }
}
