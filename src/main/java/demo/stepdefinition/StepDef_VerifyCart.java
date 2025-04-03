package demo.stepdefinition;

import demo.base.Baseclass;
import demo.pageObjects.POM_BookCart;
import demo.pageObjects.POM_ShoppingCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;

import static demo.base.Hookclass.scenario;

public class StepDef_VerifyCart extends Baseclass {

    POM_BookCart bookCart = new POM_BookCart();
    POM_ShoppingCart shoppingCart = new POM_ShoppingCart();

    @And("user enters the {string} in Search Text box and select the search result")
    public void user_enter_the_search_text_box(String searchValue) throws IOException, InterruptedException {
        bookCart.enterSearch(searchValue);
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @Then("user clicks on the Add to Cart button")
    public void user_click_addToCart_Btn() throws IOException, InterruptedException {
       Thread.sleep(2000);
        bookCart.clickAddToCartBtn();
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @Then("user clicks on the Shopping cart icon")
    public void user_click_shoppingCart_Icon() throws IOException, InterruptedException {
       bookCart.clickShoppingCartIcon();
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @Then("user should be able to click on Clear cart icon")
    public void user_click_clearCart_Icon() throws IOException, InterruptedException {
        shoppingCart.clickClearCartIcon();
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @And("user should be able to see the Shopping Cart Page Header as {string}")
    public void user_should_be_able_to_see_shoppingCart_pageHeader(String expPageTitle) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shoppingCartPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-card-title[text()=' Shopping cart ']")));
        String actPageTitle = shoppingCartPage.getText();
        Assert.assertEquals(actPageTitle , expPageTitle);
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }

    @And("user should verify the Shopping cart icon")
    public void user_should_verify_the_shopping_cart_icon() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shoppingCartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-icon[@data-mat-icon-type='font' and text()='shopping_cart'])[1]")));
        shoppingCartIcon.isDisplayed();
        AttachScreenshot(String.valueOf(scenario.getStatus()));
    }




}
