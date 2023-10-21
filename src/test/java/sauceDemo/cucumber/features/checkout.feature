Feature: Checkout

  @Regression @Positive
  Scenario: Checkout Product
    Given User already add 1 product
    When User click checkout button
    And User input shipping info
    And User click continue button
    And User see checkout overview
    And User click finish button
    Then User checkout complete