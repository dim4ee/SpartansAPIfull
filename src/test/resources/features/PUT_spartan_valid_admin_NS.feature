@smoke @regression
Feature: Update one spartan information


  Background:
    Given base URL + "/api/spartans/{id}"

  Scenario: send a PUT request with valid admin credentials,
  valid path parameters and invalid request body
    Given accept ContentType.JSON
    And basic auth with admin credentials
    And contentType ContentType.JSON
    And "valid" path parameters
    And "invalid" request body
    When user send PUT request
    Then response code 500

  Scenario: send a PUT request with valid admin credentials,
  invalid path parameters and valid request body
    Given accept ContentType.JSON
    And basic auth with admin credentials
    And contentType ContentType.JSON
    And "invalid" path parameters
    And "valid" request body
    When user send PUT request
    Then response code 204
    #bug: when you send a PUT request with editor or admin credentials
    # with invalid path param status code is 204 but need to be 500

  Scenario: send a PUT request with valid admin credentials,
  invalid path parameters and invalid request body
    Given accept ContentType.JSON
    And basic auth with admin credentials
    And contentType ContentType.JSON
    And "invalid" path parameters
    And "invalid" request body
    When user send PUT request
    Then response code 204
    #bug: when you send a PUT request with editor or admin credentials
    # with invalid path param status code is 204 but need to be 500