@Demo  @Regression
Feature: TC02 Verify the Order Placement

  @PlaceOrder
  Scenario : Verify user able to place the order
    Given user is on the Demo Application
    Then user should be able to see the Book Cart Page Header as {string}
    And user enters the "value" in Search Text box
    And user should be able to select the search result
    Then user clicks on the Add to Cart button
    And user should be able to see the Add Cart Success Message
    And user clicks on the Shopping cart icon
    And user should be able to see the Shopping cart Page Header as "Shopping Cart"
    And user clicks on the Checkout button
    And user should be able to see the Check Out Page Header as "Check Out"
    And user enters the Name in Name Text box
    And user enters the Address in Address Line 1 Text box
    And user enters the Pincode in Pincode Text box
    And user enters the State in State Text box
    Then user clicks on the Place order button
    And user should be able to see the Cart Cleared Success Message
    And user should be able to see the My Order cart Page Header as "Shopping Cart"
    Then user clicks on Account Name
    And user clicks on the logout button
    And user should be able to see the Login Page Header as {string}