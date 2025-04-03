package demo.pageObjects;

import demo.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class POM_ShoppingCart extends Baseclass {

    @FindBy(xpath="//mat-card-title[text()=' Shopping cart ']")
    public WebElement shoppingCartPage;

    @FindBy(xpath="//a[text()='Robbie']")
    public WebElement bookName;

    @FindBy(xpath="//span[text()=' Clear cart ']")
    public WebElement clearCartIcon;


    public void verifyShoppingCartPage() throws InterruptedException {
        explicitWait(shoppingCartPage);
        shoppingCartPage.isDisplayed();
    }


    public void clickClearCartIcon() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clearCartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Clear cart ']")));
        click(clearCartIcon);
    }
}
