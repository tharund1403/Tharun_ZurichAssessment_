@Demo  @Regression
Feature: TC01 User Registration with login and logout

  @Register

      # The @Register tag indicates this scenario is related to user registration functionality.
      # This scenario verifies if a user can successfully register, login, and logout in the demo application.

  Scenario: Verify User able to Login with new registration and logout

    # Step 1: Launch the Demo Application
    # This step ensures that the demo application is launched
    Given user launches the Demo Application

    # Step 2: Verify Login Page Header
    # This step checks login page is displayed properly by verifying the page header as "Login".
    Then user should be able to see the Login Page Header as "Login"

    # Step 3: Register a New User in the Demo Application
    # This step registers a new user on the demo application by entering user details like  username, password, etc.
    Then user register new user in Demo Application

    # Step 4: Log in to the Demo Application with the Registered User
    # This step allows the registered user to log in using the registered credentials.
    Then user login the Demo application with the registered user

    # Step 5: Log out of the Demo Application
    # This step verifies if the user can log out after successfully logging into the application.
    And user logout the Demo Application

