@Demo @login @Regression
Feature: TC01 Login into Application

  @login
  Scenario Outline: Login to the Application
    Given user launches the Demo Application
    Then user should be able to see the Login Page Header as "Login"
    And user enters the "<username>" in the Username Text box
    And user enters the "<password>" in the Password Text box
    Then user clicks on the login button
    And user should be able to see the Book Cart Page Header as "Book Cart"

    Examples:
      | username | password|
      | TharunD | Test@12345 |



