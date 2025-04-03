@Demo @login @Regression
Feature: TC01 Register the user

  @login
  Scenario: Verify User Registration
    Given user launches the Demo Application
    Then user should be able to see the Login Page Header as "Login"
    Then I register a new user in Demo Application
    Then I login the Demo application with the registered user
    And I logout the Demo Application

