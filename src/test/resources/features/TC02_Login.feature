@Demo @Regression
Feature: TC02 Login into Application

  # The @login tag indicates that this scenario is related to the login functionality of the application.
  @Login
  Scenario Outline: Login to the Application
    # Step 1: Launch the Demo Application
    # This step ensures that the demo application is launched
    Given user launches the Demo Application

    # Step 2: Verify Login Page Header
    # This step checks login page is displayed properly by verifying the page header as "Login".
    Then user should be able to see the Login Page Header as "Login"

    # Step 3: Enter the Username
    # This step fills in the username field with the value provided in the Examples table
    # The username is passed dynamically from the Scenario Outline's Examples section.
    And user enters the "<username>" in the Username Text box

    # Step 4: Enter the Password
    # This step fills in the password field with the value provided in the Examples table
    # The password is passed dynamically from the Scenario Outline's Examples section.
    And user enters the "<password>" in the Password Text box

    # Step 5: Click the Login Button
    # This step simulates clicking the login button for login.
    Then user clicks on the login button

    # Step 6: Verify Book Cart Page Header
    # This step verifies if the user is successfully redirected to the Book Cart page
    And user should be able to see the Book Cart Page Header as "Book Cart"

    Examples:
      # The Examples section provides the test data for the login Outline.
      # It can contains different combinations of username and password that will be used to run the test case.
      | username | password    |
      | TharunD  | Test@12345  |



