Feature: Login

  @Regression @Positive
  Scenario: Success Login
    Given User Open the Website
    When User input valid username
    And User input valid password
    And User click Login Button
    Then User redirect to dashboard page

  @Regression @Negative
  Scenario:  Failed Login
    Given User Open Website
    When User input invalid username
    And User input invalid password
    And click Login Button
    Then Error message
