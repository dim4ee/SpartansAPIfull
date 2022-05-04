@smoke @regression
Feature: Create a new Spartan

  Background:
    Given base URL + "/api/spartans"


  Scenario: using editor credentials send POST request
    When send POST request using editor credentials with valid request body
    Then response code 201
    And response Content Type "application/json"
    And response body should contain "A Spartan is Born!"


  Scenario: using admin credentials send POST request
    When send POST request using admin credentials with valid request body
    Then response code 201
    And response Content Type "application/json"
    And response body should contain "A Spartan is Born!"


  Scenario: using invalid credentials send POST request
    When send POST request using invalid credentials with valid request body
    Then response code 401

