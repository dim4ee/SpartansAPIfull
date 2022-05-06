@smoke @regression
Feature: Delete A Spartan | Only Admin is allowed to delete


  Background:
    Given base URL + "/api/spartans/{id}"

  @wip
  Scenario: send a delete request with admin credentials with valid path param
    Given accept ContentType.JSON
    And basic auth with admin credentials
    And valid path id parameters
    When user send DELETE request
    Then response code 204

#Negative Scenarios

  Scenario: send a delete request with invalid credentials and valid path param
    Given accept ContentType.JSON
    And basic auth with invalid credentials
    And "valid" path parameters
    When user send DELETE request
    Then response code 401


  Scenario: send a delete request with user credentials and valid path param
    Given accept ContentType.JSON
    And basic auth with user credentials
    And "valid" path parameters
    When user send DELETE request
    Then response code 403

    Scenario: send a delete request with editor credentials and valid path param
      Given accept ContentType.JSON
      And basic auth with admin credentials
      And "valid" path parameters
      When user send DELETE request
      Then response code 403

      Scenario: send a delete request with user credentials and invalid path param
        Given accept ContentType.JSON
        And basic auth with user credentials
        And "invalid" path parameters
        When user send DELETE request
        Then response code 403
