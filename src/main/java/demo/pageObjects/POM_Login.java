package demo.pageObjects;

import demo.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Login extends Baseclass {


// Using the @FindBy annotation to locate elements using the XPath selectors

    // Locator for the "Login" button
    @FindBy(xpath="//span[text()='Login']")
    public WebElement loginBtn;

    // Locator for the "Username" input field
    @FindBy(xpath="//input[@placeholder='Username']")
    public WebElement userNameTxtbox;

    // Locator for the "Password" input field
    @FindBy(xpath="//input[@placeholder='Password']")
    public WebElement passwordTxtbox;

    // Locator for the login page header
    @FindBy(xpath="//div[@class='mat-mdc-card-header-text']")
    public WebElement loginPage;

    // Locator for the "Book Cart" page header
    @FindBy(xpath="//span[text()=' Book Cart ']")
    public WebElement bookCartPage;

    // Constructor for the Page Object Model
    // Initializes the elements located by @FindBy annotations using PageFactory
    public POM_Login() {
        // Initializing the PageFactory
        PageFactory.initElements(driver, this);
    }

    // Method to enter a username into the "Username" input field
    public void enterUserName(String username) throws InterruptedException {
        // Wait for the username text box to be interactable
        explicitWait(userNameTxtbox);

        // Click on the username text box
        userNameTxtbox.click();

        // Enter the provided username
        userNameTxtbox.sendKeys(username);
    }

    // Method to enter a password into the "Password" input field
    public void enterPassword(String password) throws InterruptedException {
        // Wait for the password text box to be interactable
        explicitWait(passwordTxtbox);

        // Click on the password text box
        passwordTxtbox.click();

        // Enter the provided password
        passwordTxtbox.sendKeys(password);
    }

    // Method to click the "Login" button after entering credentials
    public void clickLoginBtn() throws InterruptedException {
        // Wait for the login button to be displayed
        explicitWait(loginBtn);

        // Click the login button to initiate the login
        click(loginBtn);
    }

    // Method to verify that the login page is displayed
    public void verifyLoginPage() throws InterruptedException {
        // Wait for the login page element to be displayed
        explicitWait(loginPage);

        // Check if the login page is visible on the screen
        loginPage.isDisplayed();
    }

    // Method to verify that the "Book Cart" page is displayed
    public void verifyBookCartPage() throws InterruptedException {
        // Wait for the book cart page element to be displayed
        explicitWait(bookCartPage);

        // Check if the book cart page is visible on the screen
        loginPage.isDisplayed();
    }
}
