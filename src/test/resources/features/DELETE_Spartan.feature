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

