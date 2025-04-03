package demo.stepdefinition;

import com.github.javafaker.Faker;
import demo.base.Baseclass;
import demo.pageObjects.POM_Login;
import demo.pageObjects.POM_Registration;
import io.cucumber.java.en.Then;

public class StepDef_Register {

    POM_Registration registration = new POM_Registration();
    POM_Login login = new POM_Login();
    Faker faker = new Faker();

    @Then("I register a new user in Demo Application")
    public void i_register_new_user_in_Demo_Application() throws InterruptedException {

        String name = faker.name().fullName();
        String password = faker.internet().password(8, 16, true, true);

        registration.clickRegister();
        registration.enterFirstName(name);
        registration.enterLastName(name);
        registration.enterUserName(name);
        registration.enterPassword(password);
        registration.enterConfirmPassword(password);
        registration.clickGender();
        registration.clickRegister();

        // Storing data for future use
        Baseclass.ScenarioContext.set("name", name);
        Baseclass.ScenarioContext.set("password", password);

    }



}
