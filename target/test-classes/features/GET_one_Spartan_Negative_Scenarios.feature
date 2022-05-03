Feature: Display one spartan information


  Background:
    Given base URL + "/api/spartans"

    @smoke @regression
  Scenario: GET one Spartan with user credentials and invalid path parameters
    Given accept ContentType.JSON
    And basic auth with user credentials
    And path parameters "id" -300
    When send GET request
    Then response code 404

  @smoke @regression
  Scenario: GET one Spartan with editor credentials and invalid path parameters
    Given accept ContentType.JSON
    And basic auth with editor credentials
    And path parameters "id" -300
    When send GET request
    Then response code 404

  @smoke @regression
  Scenario: GET one Spartan with admin credentials and invalid path parameters
    Given accept ContentType.JSON
    And basic auth with admin credentials
    And path parameters "id" -300
    When send GET request
    Then response code 404

  @smoke @regression
  Scenario: GET one Spartan with invalid credentials and valid path parameters
    Given accept ContentType.JSON
    And basic auth with invalid credentials
    And path parameters "id" 7
    When send GET request
    Then response code 401

  @smoke @regression
  Scenario: GET one Spartan with invalid credentials and invalid path parameters
    Given accept ContentType.JSON
    And basic auth with invalid credentials
    And path parameters "id" -300
    When send GET request
    Then response code 401