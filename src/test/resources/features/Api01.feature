@api01
Feature: Get All Products List

  Scenario: Get All Products List

    Given API URL: "https://automationexercise.com/api/" "productsList"
    When Request Method: GET
    Then Response Code: 200
    And Response JSON: All products list