Feature: Produk

  @Regression @Positive
  Scenario: Produk Detail
    Given User already on dashboard
    When User click product name
    Then User see product details