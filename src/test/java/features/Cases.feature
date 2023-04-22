Feature: Case

  @addproducttocart
  Scenario: Add Product to Cart
    Given User open the homepage
    When Search "Sneakers"
    Then Open the "2" product
    Then Add to selected product
    And Close driver

