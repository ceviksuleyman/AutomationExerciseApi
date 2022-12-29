Feature: POST To All Products List

  @api02
  Scenario: POST To All Products List
  Given B_API URL "productsList"
  When B_API Request Method POST
  Then B_API Response Code 405
  And B_API Response Message This request method is not supported.