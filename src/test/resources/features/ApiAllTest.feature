@all
Feature: All API

  @api01
  Scenario: Get All Products List

    Given A_API URL "productsList"
    When A_API Request Method GET
    Then A_API Response Code 200
    And A_API Response JSON All products list

  @api02
  Scenario: POST To All Products List
    Given B_API URL "productsList"
    When B_API Request Method POST
    Then B_API Response Code 405
    And B_API Response Message This request method is not supported.

  @api03
  Scenario: Get All Brands List
    Given C_API URL "brandsList"
    When C_Request Method GET
    Then C_Response Code 200
    And C_Response JSON All brands list

  @api04
  Scenario: PUT To All Brands List
    Given D_API URL "brandsList"
    When D_Request Method PUT
    Then D_Response Code 405
    And D_Response Message This request method is not supported.

  @api14
  Scenario: GET user account detail by email
    Given Z_API URL "getUserDetailByEmail" query "automation01@gmail.com"
    When Z_Request Method GET
    Then Z_Response Code 200
    And Z_Response JSON User Detail

  @restful
  Scenario: Restful Book Post
    Given Restful Api URL "booking"

