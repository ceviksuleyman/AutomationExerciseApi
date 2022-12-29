Feature: Get All Products List

  @api01
  Scenario: Get All Products List

    Given A_API URL "productsList"
    When A_API Request Method GET
    Then A_API Response Code 200
    And A_API Response JSON All products list