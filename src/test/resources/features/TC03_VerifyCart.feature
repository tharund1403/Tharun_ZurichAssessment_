@Demo  @Regression
Feature: TC03 Verify the Clear Cart

  # The @ClearCart tag indicates that this scenario is related to the functionality of clearing the shopping cart.

  Scenario Outline: Verify user able to clear the added items in the cart
    # Step 1: Launch the Demo Application
    # This step ensures that the demo application is launched
    Given user launches the Demo Application

    # Step 2: Verify Login Page Header
    # This step checks login page is displayed properly by verifying the page header as "Login".
    When user should be able to see the Login Page Header as "Login"

    # Step 3: Register a new user
    # This step performs the process of user registration.
    Then user register new user in Demo Application

    # Step 4: Log in with the registered user
    # This step ensures the user logs into the application with the credentials provided during registration.
    And user login the Demo application with the registered user

    # Step 5: Verify Book Cart Page Header
    # This step verifies that the user is successfully redirected to the "Book Cart" page.
    Then user should be able to see the Book Cart Page Header as "Book Cart"

    # Step 6: Search for a book using search box
    # This step enters the book name into the search box
    And user enters the "<Book Name>" in Search Text box

    # Step 7: Add the book to the cart
    # This step clicks the "Add to Cart" button to add the book to the shopping cart.
    Then user clicks on the Add to Cart button

    # Step 8: Verify the Shopping Cart Icon
    # This step verifies that the shopping cart icon is visible and accessible
    And user should verify the Shopping cart icon

    # Step 9: Click on the Shopping Cart Icon
    # This step simulates the user clicking on the shopping cart icon, opening the shopping cart page.
    And user clicks on the Shopping cart icon

    # Step 10: Verify Shopping Cart Page Header
    # This step checks that the user is correctly redirected to the shopping cart page by verifying the page header text.
    And user should be able to see the Shopping Cart Page Header as "Shopping cart"

    # Step 11: Clear the cart
    # This step simulates clicking on the "Clear Cart" icon to remove all items from the shopping cart.
    Then user should be able to click on Clear cart icon

    # Step 12: Click on Account Name
    # This step simulates clicking on the account name or icon to open the account options or settings.
    Then user clicks on Account Name

    # Step 13: Click on the Logout Button
    # After interacting with the account options, this step simulates clicking the logout button to log out of the application.
    And user clicks on the logout button

    # Step 14: Verify Login Page Header After Logout
    # This step checks that the user is successfully logged out by verifying that the login page header is displayed again.
    And user should be able to see the Login Page Header as "Login"


    # This section provides the test data for the scenario.
    # It contains the book name that will be used in the search
    Examples:
      | Book Name |
      | robbie   |
