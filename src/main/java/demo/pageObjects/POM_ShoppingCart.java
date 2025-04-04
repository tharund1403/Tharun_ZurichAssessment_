package demo.pageObjects;

import demo.base.Baseclass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class POM_ShoppingCart extends Baseclass {

    // Method to click on the "Clear cart" icon to clear the shopping cart
    public void clickClearCartIcon() throws InterruptedException {

        // WebDriverWait with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the "Clear cart" icon is clickable
        WebElement clearCartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Clear cart ']")));

        // Click on the "Clear cart" icon
        click(clearCartIcon);
    }

    public void verifyShoppingCartPageHeader(String expPageTitle) throws InterruptedException {

        // Wait for the shopping cart page header to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shoppingCartPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-card-title[text()=' Shopping cart ']")));

        // Get the actual page title from the shopping cart page
        String actPageTitle = shoppingCartPage.getText();

        // Verify if the actual title matches the expected title
        Assert.assertEquals(actPageTitle, expPageTitle);
    }


}
