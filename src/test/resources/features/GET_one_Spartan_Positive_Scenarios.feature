@smoke @regression
Feature: Display one spartan information


  Background:
    Given base URL + "/api/spartans"


  Scenario: GET one Spartan with user credentials and valid path parameters
    Given accept ContentType.JSON
    And basic auth with user credentials
    And path parameters "id" 7
    When send GET request
    Then response code 200
    And response Content Type "application/json;charset=UTF-8"
    And response body should be
      | id     | 7          |
      | name   | Hershel    |
      | gender | Male       |
      | phone  | 5278678322 |


  Scenario: GET one Spartan with editor credentials and valid path parameters
    Given accept ContentType.JSON
    And basic auth with editor credentials
    And path parameters "id" 7
    When send GET request
    Then response code 200
    And response Content Type "application/json;charset=UTF-8"
    And response body should be
      | id     | 7          |
      | name   | Hershel    |
      | gender | Male       |
      | phone  | 5278678322 |


    Scenario: GET one Spartan with admin credentials and valid path parameters
      Given accept ContentType.JSON
      And basic auth with admin credentials
      And path parameters "id" 7
      When send GET request
      Then response code 200
      And response Content Type "application/json;charset=UTF-8"
      And response body should be
        | id     | 7          |
        | name   | Hershel    |
        | gender | Male       |
        | phone  | 5278678322 |

