@smoke @regression
Feature: Update one spartan information


  Background:
    Given base URL + "/api/spartans/{id}"

#  Scenario Outline: send a PUT request with valid user credentials,
#  valid path parameters and invalid request body
#    Given accept ContentType.JSON
#    And basic auth with valid <username> and <password>
#    And contentType ContentType.JSON
#    And "valid" path parameters
#    And "invalid" request body
#    When user send PUT request
#    Then response code 403
#
#    Examples:
#      | username          | password          |
#      | "user_username"   | "user_username"   |
#      | "editor_username" | "editor_username" |
#      | "admin_username"  | "admin_password"  |

  Scenario: send a PUT request with valid user credentials,
  valid path parameters and invalid request body
    Given accept ContentType.JSON
    And basic auth with user credentials
    And contentType ContentType.JSON
    And "valid" path parameters
    And "invalid" request body
    When user send PUT request
    Then response code 403

  Scenario: send a PUT request with valid user credentials,
  invalid path parameters and valid request body
    Given accept ContentType.JSON
    And basic auth with user credentials
    And contentType ContentType.JSON
    And "invalid" path parameters
    And "valid" request body
    When user send PUT request
    Then response code 403

  Scenario: send a PUT request with valid user credentials,
  invalid path parameters and invalid request body
    Given accept ContentType.JSON
    And basic auth with user credentials
    And contentType ContentType.JSON
    And "invalid" path parameters
    And "invalid" request body
    When user send PUT request
    Then response code 403