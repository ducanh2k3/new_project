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

    //    (//div[@class='inventory_item'])[1]//div[2]//a
    By itemsLocator = By.xpath("(//div[@class='inventory_item'])");

    List<WebElement> items = findElements(itemsLocator);

    public void clickItemByIndex(int index) {
        if (index >= 0 && index < items.size()) {
            WebElement item = items.get(index);
            // Find the link within the selected item and click it
            WebElement itemLink = item.findElement(By.xpath(".//div[2]//a"));

            // Example: Output the href or other action before clicking
            System.out.println("Clicking on item URL: " + itemLink.getAttribute("href"));

            // Perform the click action
            click(itemLink);
//            checkUrl("https://www.saucedemo.com/v1/inventory-item.html?id=4");
        } else {
            System.out.println("Index out of bounds: " + index);
        }
    }
}
