package demo.pageObjects;


import demo.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class POM_BookCart extends Baseclass {

    // Method to enter a search term in the search box
    public void enterSearch(String bookname) throws InterruptedException {
        // WebDriverWait with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Custom condition to wait for the search box element to be both visible and enabled
        WebElement searchBox = wait.until((ExpectedCondition<WebElement>) driver -> {
            // Locate the search input field
            WebElement element = driver.findElement(By.xpath("//input[@aria-label='search']"));

            // Check if the element is displayed and enabled before returning it
            if (element.isDisplayed() && element.isEnabled()) {
                return element; // If element is ready, return it
            }
            return null; // Otherwise, return null
        });

        // Click on the search box to focus it
        searchBox.click();

        // Enter the provided book name into the search box
        searchBox.sendKeys(bookname);
    }

    // Method to click the "Add to Cart" button for the first item
    public void clickAddToCartBtn() throws InterruptedException {
        // WebDriverWait with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the "Add to Cart" button is clickable using the appropriate XPath
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(), 'Add to Cart')])[1]")));

        // Click the "Add to Cart" button
        addToCartBtn.click();
    }

    // Method to click on the shopping cart icon
    public void clickShoppingCartIcon() throws InterruptedException {
        // WebDriverWait with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the shopping cart icon is clickable using the appropriate XPath
        WebElement shoppingCartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-icon[@data-mat-icon-type='font' and text()='shopping_cart'])[1]")));

        // Click on the shopping cart icon
        shoppingCartIcon.click();
    }

    // Method to click the account icon (user profile)
    public void clickAccountIcon() throws InterruptedException {
        // WebDriverWait with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the account icon is clickable using the appropriate XPath
        WebElement accountIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[@role='img' and text()='account_circle']")));

        // Click the account icon
        accountIcon.click();
    }

    // Method to click the logout option from the user account menu
    public void clickLogoutOption() throws InterruptedException {
        //WebDriverWait with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the "Logout" option is clickable
        WebElement logOutOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Logout']")));

        // Click the "Logout" option
        logOutOption.click();
    }

    // Method to verify the shopping cart icon is displayed
    public void verifyShoppingCartIcon() throws InterruptedException {
        // Wait for the shopping cart icon to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shoppingCartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-icon[@data-mat-icon-type='font' and text()='shopping_cart'])[1]")));

        // Check if the shopping cart icon is displayed
        shoppingCartIcon.isDisplayed();

    }
}
