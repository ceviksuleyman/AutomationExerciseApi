Feature:PUT To All Brands List

  @api04
  Scenario: PUT To All Brands List
    Given D_API URL "brandsList"
    When D_Request Method PUT
    Then D_Response Code 405
    And D_Response Message This request method is not supported.