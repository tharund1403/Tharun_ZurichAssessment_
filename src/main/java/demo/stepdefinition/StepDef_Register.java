package demo.stepdefinition;

import com.github.javafaker.Faker;
import demo.base.Baseclass;
import demo.pageObjects.POM_Registration;
import io.cucumber.java.en.Then;

public class StepDef_Register {

    // Initializing Page Object Model
    POM_Registration registration = new POM_Registration();

    // Faker library used to generate random user data
    Faker faker = new Faker();

    @Then("user register new user in Demo Application")
    public void user_register_new_user_in_Demo_Application() throws InterruptedException {
        // Generate random name and password using Faker
        String name = faker.name().fullName(); // Generates a random full name
        String password = faker.internet().password(8, 16, true, true); // Generates a random password between 8 and 16 characters with a mix of letters and digits

        // Click the register button to initiate User Registration
        registration.clickRegister();

        // Enter user details in the registration page
        registration.enterFirstName(name);
        registration.enterLastName(name);
        registration.enterUserName(name);
        registration.enterPassword(password);
        registration.enterConfirmPassword(password);
        registration.clickGender();

        // Clicking the register button
        registration.clickRegister();

        // Storing the generated name and password in the ScenarioContext for future login
        Baseclass.ScenarioContext.set("name", name);
        Baseclass.ScenarioContext.set("password", password);

    }

}
