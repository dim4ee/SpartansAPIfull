Feature: Update one spartan information


  Background:
    Given base URL + "/api/spartans"

    @smoke @regression @wip
    Scenario: send a PUT request with valid user credentials,
    valid path parameters and valid request body
      Given accept ContentType.JSON

      And basic auth with user credentials

      And contentType ContentType.JSON

      And valid path parameters

      And valid request body

      When user send PUT request

      Then response code 204