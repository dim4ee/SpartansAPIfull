Feature: Display list of all Spartans


  Background:
    Given base URL + "/api/spartans"

  @smoke @regression
  Scenario: GET request with user credentials
    When send GET request with user credentials
    Then response code 200
    And response Content Type "application/json;charset=UTF-8"

  @smoke @regression
  Scenario: GET request with admin credentials
    When send GET request with admin credentials
    Then response code 200
    And response Content Type "application/json;charset=UTF-8"

  @smoke @regression
  Scenario: GET request with editor credentials
    When GET request with editor credentials
    Then response code 200
    And response Content Type "application/json;charset=UTF-8"

  @smoke @regression
  Scenario: GET request with invalid credentials
    When GET request with invalid credentials
    Then response code 401

  @smoke @regression
  Scenario: GET request with no credentials
    When GET request with no credentials
    Then response code 401
    And response Content Type "application/json;charset=UTF-8"
    And response body "Unauthorized"