package demo.stepdefinition;

import demo.base.Baseclass;
import demo.pageObjects.POM_BookCart;
import demo.pageObjects.POM_ShoppingCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.io.IOException;


import static demo.base.Hookclass.scenario;

public class StepDef_VerifyCart extends Baseclass {

    // Initializing Page Object Models
    POM_BookCart bookCart = new POM_BookCart();
    POM_ShoppingCart shoppingCart = new POM_ShoppingCart();


    @And("user enters the {string} in Search Text box")
    public void user_enter_the_search_text_box(String searchValue) throws IOException, InterruptedException {
        // Enter the search value in the search box
        bookCart.enterSearch(searchValue);

        // Attaching a screenshot to verify the search result
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @Then("user clicks on the Add to Cart button")
    public void user_click_addToCart_Btn() throws IOException, InterruptedException {
        // Added Sleep for 2 seconds due to time constraints
        Thread.sleep(2000);

        // Clicking on the "Add to Cart" button
        bookCart.clickAddToCartBtn();

        // Attaching a screenshot to verify the addition to the cart
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @Then("user clicks on the Shopping cart icon")
    public void user_click_shoppingCart_Icon() throws IOException, InterruptedException {
        // Clicking on the shopping cart icon
        bookCart.clickShoppingCartIcon();

        // Attach a screenshot to verify the Shopping cart page is opened
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @Then("user should be able to click on Clear cart icon")
    public void user_click_clearCart_Icon() throws IOException, InterruptedException {
        // Click on the "Clear cart" icon to empty the shopping cart
        shoppingCart.clickClearCartIcon();

        // Attaching a screenshot to verify the cart is cleared
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @And("user should be able to see the Shopping Cart Page Header as {string}")
    public void user_should_be_able_to_see_shoppingCart_pageHeader(String expPageTitle) throws IOException, InterruptedException {
        // Method to check the page header
        shoppingCart.verifyShoppingCartPageHeader(expPageTitle);

        // Attaching a screenshot after verifying the page header
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }


    @And("user should verify the Shopping cart icon")
    public void user_should_verify_the_shopping_cart_icon() throws IOException, InterruptedException {
        //Method to check the visibility of the shopping cart icon
        bookCart.verifyShoppingCartIcon();

        // Attach a screenshot to verify the cart icon is visible and accessible
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

}
