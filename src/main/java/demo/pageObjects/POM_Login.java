package demo.pageObjects;

import demo.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Login extends Baseclass {

    // Locators using FindBy
    @FindBy(xpath="//span[text()='Login']")
    public  WebElement loginBtn;

    @FindBy(xpath="//input[@placeholder='Username']")
    public WebElement userNameTxtbox;

    @FindBy(xpath="//input[@placeholder='Password']")
    public  WebElement passwordTxtbox;

    @FindBy(xpath="//div[@class='mat-mdc-card-header-text']")
    public  WebElement loginPage;

    @FindBy(xpath="//span[text()=' Book Cart ']")
    public  WebElement bookCartPage;

    public POM_Login() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) throws InterruptedException {
        explicitWait(userNameTxtbox);
        userNameTxtbox.click();
        userNameTxtbox.sendKeys(username);
    }

    public void enterPassword(String password) throws InterruptedException {
        explicitWait(passwordTxtbox);
        passwordTxtbox.click();
        passwordTxtbox.sendKeys(password);
    }

    public void clickLoginBtn() throws InterruptedException {
        explicitWait(loginBtn);
        click(loginBtn);
    }

    public void verifyLoginPage() throws InterruptedException {
        explicitWait(loginPage);
        loginPage.isDisplayed();
    }

    public void verifyBookCartPage() throws InterruptedException {
        explicitWait(bookCartPage);
        loginPage.isDisplayed();
    }
}
