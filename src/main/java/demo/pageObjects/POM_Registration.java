package demo.pageObjects;

import demo.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class POM_Registration extends Baseclass {

    // Using the @FindBy annotation to locate elements using the XPath selectors

    // Locator for the "First Name" input field on the Registration page
    @FindBy(xpath = "//input[@placeholder='First name']")
    WebElement firstNameField;

    // Locator for the "Last Name" input field on the Registration page
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;

    // Locator for the "Username" input field on the Registration page
    @FindBy(xpath = "//input[@placeholder='User name']")
    WebElement userNameField;

    // Locator for the "Password" input field on the Registration page
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    // Locator for the "Confirm Password" input field on the Registration page
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    WebElement confirmPasswordField;

    // Locator for the "Male" gender radio button on the Registration page
    @FindBy(xpath = "//*[@value='Male']")
    WebElement genderMaleOption;

    // Locator for the "Female" gender radio button on the Registration page
    @FindBy(xpath = "//input[@value='Female']")
    WebElement genderFemaleOption;

    // Locator for the "Register" button on the Registration page
    @FindBy(xpath = "//span[text()='Register']")
    WebElement registerBtn;

    // Constructor for the Page Object Model
    // Initializes the elements located by @FindBy annotations using PageFactory
    public POM_Registration() {
        // Assigning the driver passed to the constructor to the class variable
        this.driver = driver;
        // Initializing the PageFactory
        PageFactory.initElements(driver, this);
    }

    // Method to enter the first name into the "First Name" input field
    public void enterFirstName(String firstname) {
        // Waiting for the element to be visible
        explicitWait(firstNameField);

        // Entering the provided first name
        firstNameField.sendKeys(firstname);
    }

    // Method to enter the last name into the "Last Name" input field
    public void enterLastName(String lastname) {
        // Waiting for the element to be visible and interactable
        explicitWait(lastNameField);

        // Entering the provided last name
        lastNameField.sendKeys(lastname);
    }

    // Method to enter the username into the "Username" input field
    public void enterUserName(String username) {
        // Waiting for the element to be visible and interactable
        explicitWait(userNameField);

        // Entering the provided username
        userNameField.sendKeys(username);
    }

    // Method to enter the password into the "Password" input field
    public void enterPassword(String password) {
        // Waiting for the element to be visible and interactable
        explicitWait(passwordField);

        // Entering the provided password
        passwordField.sendKeys(password);
    }

    // Method to enter the confirm password into the "Confirm Password" input field
    public void enterConfirmPassword(String password) {
        // Waiting for the element to be visible and interactable
        explicitWait(confirmPasswordField);

        // Entering the provided password
        confirmPasswordField.sendKeys(password);
    }

    // Method to select the gender (Male) from the radio buttons
    public void clickGender() {
        // Creating a WebDriverWait object to wait for visibility of the Male gender option
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Explicitly waiting until the Male gender option is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Male']")));

        // Clicking on the Male gender option
        genderMaleOption.click();
    }

    // Method to click the "Register" button after filling out the form
    public void clickRegister() throws InterruptedException {
        // Uses Thread.sleep() to wait for 2 seconds before clicking the "Register" button
        // Added due to time constraints
        Thread.sleep(2000);

        // Creating a WebDriverWait object to wait for the "Register" button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Waiting until the "Register" button is clickable
        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Register']")));

        // Clicking the "Register" button
        registerBtn.click();
    }

}

