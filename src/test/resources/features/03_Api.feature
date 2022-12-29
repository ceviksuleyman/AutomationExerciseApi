Feature: Get All Brands List

  @api03
  Scenario: Get All Brands List
    Given C_API URL "brandsList"
    When C_Request Method GET
    Then C_Response Code 200
    And C_Response JSON All brands list