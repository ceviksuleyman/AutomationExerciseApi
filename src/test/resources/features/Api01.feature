Feature: Get All Products List

  @api01
  Scenario: Get All Products List

    Given API URL: "productsList"
    When Request Method: GET
    Then Response Code: 200
    And Response JSON: All products list