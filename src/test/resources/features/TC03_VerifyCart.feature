@Demo  @Regression
Feature: TC02 Verify the Clear Cart

  @ClearCart
  Scenario Outline: Verify user able to clear the added items in the cart
    Given user launches the Demo Application
    When user should be able to see the Login Page Header as "Login"
    Then I register a new user in Demo Application
    And I login the Demo application with the registered user
    Then user should be able to see the Book Cart Page Header as "Book Cart"
    And user enters the "<Search>" in Search Text box and select the search result
    Then user clicks on the Add to Cart button
    And user should verify the Shopping cart icon
    And user clicks on the Shopping cart icon
    And user should be able to see the Shopping Cart Page Header as "Shopping cart"
    Then user should be able to click on Clear cart icon
    Then user clicks on Account Name
    And user clicks on the logout button
    And user should be able to see the Login Page Header as "Login"

    Examples:
      | Search |
      | robbie  |