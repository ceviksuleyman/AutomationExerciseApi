Feature:

  @api14
  Scenario: GET user account detail by email
    Given Z_API URL "getUserDetailByEmail" "automation01@gmail.com"
    When Z_Request Method GET
    Then Z_Response Code 200
    And Z_Response JSON User Detail