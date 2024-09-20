package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    By first_nameLocator = By.xpath("//input[@id='first-name']");
    By last_nameLocator = By.xpath("//input[@id='last-name']");
    By zip_codeLocator = By.xpath("//input[@id='postal-code']");
    By cancelBtnLocator = By.xpath("//a[normalize-space()='CANCEL']");
    By countinueBtnLocator = By.xpath("//input[@value='CONTINUE']");


    WebElement first_nameInput = findElement(first_nameLocator);
    WebElement last_nameInput= findElement(last_nameLocator);
    WebElement Zip_codeInput = findElement(zip_codeLocator);
    WebElement cancelBtn = findElement(cancelBtnLocator);
    WebElement countinuebtn = findElement(countinueBtnLocator);




}
