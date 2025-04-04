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

    // Initializing Page Object Models
    POM_Login login = new POM_Login();
    POM_BookCart bookCart = new POM_BookCart();


    @Given("user launches the Demo Application")
    public void user_launch_Application() throws IOException {
        // Attach screenshot of the demo application landing page
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @Then("user should be able to see the Login Page Header as {string}")
    public void user_should_be_able_to_see_login_pageHeader(String expPageTitle) throws IOException {
        // Get the actual page title from the Login page
        String actPageTitle = login.loginPage.getText();
        // Validate if the actual page title matches the expected page title
        Assert.assertEquals(actPageTitle, expPageTitle);
        // Attach screenshot showing the page title
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @And("user enters the {string} in the Username Text box")
    public void user_enter_the_username(String username) throws IOException, InterruptedException {
        // Enter username in the username field
        login.enterUserName(username);
        // Attach screenshot showing the username field after input
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @And("user enters the {string} in the Password Text box")
    public void user_enter_the_password(String password) throws IOException, InterruptedException {
        // Enter password in the password field
        login.enterPassword(password);
        // Attach screenshot showing the password field after input
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @And("user clicks on the login button")
    public void user_click_login_button() throws IOException, InterruptedException {
        // Click the login button
        login.clickLoginBtn();
        // Attach screenshot showing the login action
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @And("user should be able to see the Book Cart Page Header as {string}")
    public void user_should_be_able_to_see_bookCart_pageHeader(String expPageTitle) throws IOException {
        // Get the actual page title from the Book Cart page
        String actPageTitle = login.bookCartPage.getText();
        // Validate if the actual title matches the expected title
        Assert.assertEquals(actPageTitle, expPageTitle);
        // Attach screenshot showing the page title verification result
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @Then("user clicks on Account Name")
    public void user_click_Account_Name() throws IOException, InterruptedException {
        // Click on the Account icon to navigate to account options
        bookCart.clickAccountIcon();
        // Attach screenshot showing the Account icon clicked
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @Then("user clicks on the logout button")
    public void user_click_logOut_Btn() throws IOException, InterruptedException {
        // Click on the logout button
        bookCart.clickLogoutOption();
        // Attach screenshot showing the logout action
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @Then("user login the Demo application with the registered user")
    public void user_login_the_demo_application_with_the_registered_user() throws InterruptedException {
        // Retrieve registered user's credentials from the ScenarioContext
        String username = ScenarioContext.get("name").toString();
        String password = ScenarioContext.get("password").toString();
        // Log in using the registered credentials
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginBtn();
        // Attach screenshot showing the login with registered user
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @And("user logout the Demo Application")
    public void user_logout_the_demo_application() throws InterruptedException {
        // Click on Account icon and then log out of the application
        bookCart.clickAccountIcon();
        bookCart.clickLogoutOption();
        // Attach screenshot showing the logout action
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }
}
