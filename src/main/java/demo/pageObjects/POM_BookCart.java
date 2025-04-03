package demo.pageObjects;


import demo.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class POM_BookCart extends Baseclass {

    @FindBy(xpath="//span[@class='mdc-button__label' and text()=' Book Cart ']")
    public WebElement bookCartPageHeader;

    @FindBy(xpath="//input[@placeholder='Search books or authors']")
    public WebElement searchBox;

    @FindBy(xpath="//mat-option[.//*[contains(text(), 'Robbie')]]")
    public WebElement searchResult;

    @FindBy(xpath="(//span[contains(text(), 'Add to Cart')])[1]")
    public WebElement addToCartBtn;

    @FindBy(xpath="(//mat-icon[@data-mat-icon-type='font' and text()='shopping_cart'])[1]")
    public WebElement shoppingCartIcon;

    @FindBy(xpath="//mat-icon[@data-mat-icon-type='font' and text()='account_circle']")
    public WebElement accountIcon;

    @FindBy(xpath="//span[text()='Logout']")
    public WebElement logOutOption;

    public void verifyBookCartPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Home"));
     //   explicitWait(bookCartPageHeader);
        bookCartPageHeader.isDisplayed();
    }


    public void enterSearch(String bookname) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Custom condition to wait for the element to be both visible and enabled
        WebElement searchBox = wait.until((ExpectedCondition<WebElement>) driver -> {
            WebElement element = driver.findElement(By.xpath("//input[@aria-label='search']"));
            // Check if the element is displayed and enabled
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }
            return null;
        });
        searchBox.click();
        searchBox.sendKeys(bookname);

    }

    public void clickAddToCartBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(), 'Add to Cart')])[1]")));
        addToCartBtn.click();
    }

    public void clickShoppingCartIcon() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shoppingCartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-icon[@data-mat-icon-type='font' and text()='shopping_cart'])[1]")));
        shoppingCartIcon.click();
    }

    public void clickAccountIcon() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[@role='img' and text()='account_circle']")));
        accountIcon.click();
    }

    public void clickLogoutOption() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logOutOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Logout']")));
        logOutOption.click();
    }
}
