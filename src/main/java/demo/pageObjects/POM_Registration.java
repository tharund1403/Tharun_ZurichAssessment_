package demo.pageObjects;

import demo.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class POM_Registration extends Baseclass {


        @FindBy(xpath = "//input[@placeholder='First name']")
        WebElement firstNameField;

       @FindBy(xpath = "//input[@placeholder='Last Name']")
        WebElement lastNameField;

        @FindBy(xpath = "//input[@placeholder='User name']")
        WebElement userNameField;

       @FindBy(xpath = "//input[@placeholder='Password']")
        WebElement passwordField;

       @FindBy(xpath = "//input[@placeholder='Confirm Password']")
       WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    WebElement genderField;

    @FindBy(xpath = "//*[@value='Male']")
    WebElement genderMaleOption;

    @FindBy(xpath = "//input[@value='Female']")
    WebElement genderFemaleOption;

    @FindBy(xpath = "//span[text()='Register']")
    WebElement registerBtn;


        public POM_Registration() {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void enterFirstName(String firstname) {
            explicitWait(firstNameField);
            firstNameField.sendKeys(firstname);
        }

    public void enterLastName(String lastname) {
        explicitWait(lastNameField);
        lastNameField.sendKeys(lastname);
    }

    public void enterUserName(String username) {
        explicitWait(userNameField);
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        explicitWait(passwordField);
        passwordField.sendKeys(password);
    }

        public void enterConfirmPassword(String password)
        {
            explicitWait(confirmPasswordField);
            confirmPasswordField.sendKeys(password);
        }

    public void clickGender()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Male']")));
        genderMaleOption.click();
    }
        public void clickRegister() throws InterruptedException {
// Tried multiple explicit but this register button requires sleep time hence leaving it as such due to time constraint
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Register']")));
            registerBtn.click();
        }

        }

