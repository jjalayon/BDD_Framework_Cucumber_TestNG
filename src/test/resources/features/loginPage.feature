Feature: User Login Functionality
  Background:
    Given that User is on the login page

  Scenario: Successful login with valid credentials
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks the Login Button
    Then user should be navigated to Item list page

  Scenario: Failed login with invalid username
    When user enters username "standard"
    And user enters password "secret_sauce"
    And user clicks the Login Button
    Then error message should be visible
    And error message should be "Epic sadface: Username and password do not match any user in this service"

  Scenario: Failed login with invalid password
    When user enters username "standard_user"
    And user enters password "secret"
    And user clicks the Login Button
    Then error message should be visible
    And error message should be "Epic sadface: Username and password do not match any user in this service"

  Scenario: Failed login with invalid credentials
    When user enters username "standard"
    And user enters password "secret"
    And user clicks the Login Button
    Then error message should be visible
    And error message should be "Epic sadface: Username and password do not match any user in this service"