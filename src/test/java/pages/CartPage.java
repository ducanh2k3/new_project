package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By countinueBtnLocator = By.xpath("//a[normalize-space()='Continue Shopping']");
    By checkOutBtnLocator = By.xpath("//a[normalize-space()='CHECKOUT']");

    WebElement countinueShoppingBtn = findElement(countinueBtnLocator);
    WebElement checkoutBtn = findElement(checkOutBtnLocator);

    public void removeItemByIndex(int index) {
        By removeBtnLocatorByIndex = By.xpath("//div[@id='cart_contents_container']//div[" + index + "]//div[2]//button");
        WebElement removeBtnByIndex = findElement(removeBtnLocatorByIndex);
        click(removeBtnByIndex);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(removeBtnLocatorByIndex));
        // Assert that the element is no longer visible or present
        boolean isButtonInvisible = driver.findElements(removeBtnLocatorByIndex).isEmpty();
        Assert.assertTrue(isButtonInvisible);
    }

    public void backToMenu() {
        click(countinueShoppingBtn);
    }

    public void navigateToCheckOut() {
        click(checkoutBtn);
    }


}
