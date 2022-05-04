@smoke @regression
Feature: Update one spartan information


  Background:
    Given base URL + "/api/spartans/{id}"


  Scenario: send a PUT request with invalid credentials,
  valid path parameters and valid request body
    Given accept ContentType.JSON
    And basic auth with invalid credentials
    And contentType ContentType.JSON
    And "valid" path parameters
    And "valid" request body
    When user send PUT request
    Then response code 401

  Scenario: send a PUT request with invalid credentials,
  valid path parameters and invalid request body
    Given accept ContentType.JSON
    And basic auth with invalid credentials
    And contentType ContentType.JSON
    And "valid" path parameters
    And "invalid" request body
    When user send PUT request
    Then response code 401

  Scenario: send a PUT request with invalid credentials,
  invalid path parameters and valid request body
    Given accept ContentType.JSON
    And basic auth with invalid credentials
    And contentType ContentType.JSON
    And "invalid" path parameters
    And "valid" request body
    When user send PUT request
    Then response code 401

  Scenario: send a PUT request with invalid credentials,
  invalid path parameters and invalid request body
    Given accept ContentType.JSON
    And basic auth with invalid credentials
    And contentType ContentType.JSON
    And "invalid" path parameters
    And "invalid" request body
    When user send PUT request
    Then response code 401

