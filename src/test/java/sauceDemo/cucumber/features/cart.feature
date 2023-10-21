Feature: Cart

  @Regression @Positive
  Scenario: Order 1 Item
    Given User on dashboard
    When User click add to chart button
    And User click cart icon
    Then User redirect to cart page