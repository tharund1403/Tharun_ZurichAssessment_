package demo.stepdefinition;

import demo.base.Baseclass;
import demo.pageObjects.POM_BookCart;
import demo.pageObjects.POM_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

import static demo.base.Hookclass.scenario;

public class StepDef_Login extends Baseclass {

    POM_Login login = new POM_Login();
    POM_BookCart bookCart = new POM_BookCart();

    @Given("user launches the Demo Application")
    public void user_launch_Application() throws IOException {
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @Given("user is on the Demo Application")
    public void user_is_on_Demo_Application() throws IOException {
        String actUrl = driver.getCurrentUrl();
//        Assert.assertEquals("Correct landing page verification", getPropertyFilevalue("URL"), actUrl);
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }
    @Then("user should be able to see the Login Page Header as {string}")
    public void user_should_be_able_to_see_login_pageHeader(String expPageTitle) throws IOException {
        String actPageTitle = login.loginPage.getText();
        Assert.assertEquals ( actPageTitle, expPageTitle );
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @And("user enters the {string} in the Username Text box")
    public void user_enter_the_username(String username) throws IOException, InterruptedException {
        login.enterUserName(username);
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @And("user enters the {string} in the Password Text box")
    public void user_enter_the_password(String password) throws IOException, InterruptedException {
        login.enterPassword(password);
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @And("user clicks on the login button")
    public void user_click_login_button() throws IOException, InterruptedException {
        login.clickLoginBtn();
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @And("user should be able to see the Book Cart Page Header as {string}")
    public void user_should_be_able_to_see_bookCart_pageHeader(String expPageTitle) throws IOException {
        String actPageTitle = login.bookCartPage.getText();
        Assert.assertEquals(actPageTitle , expPageTitle);
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @Then("user clicks on Account Name")
    public void user_click_Account_Name() throws IOException, InterruptedException {
        bookCart.clickAccountIcon();
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @Then("user clicks on the logout button")
    public void user_click_logOut_Btn() throws IOException, InterruptedException {
        bookCart.clickLogoutOption();
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @Then("I login the Demo application with the registered user")
    public void i_Login_The_Demo_Application_With_The_RegisteredUser() throws InterruptedException {

        String username = ScenarioContext.get("name").toString();
        String password = ScenarioContext.get("password").toString();

        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginBtn();
    }

    @And("I logout the Demo Application")
    public void iLogoutTheDemoApplication() throws InterruptedException {
//        bookCart.verifyBookCartPage();
        bookCart.clickAccountIcon();
        bookCart.clickLogoutOption();
    }
}
