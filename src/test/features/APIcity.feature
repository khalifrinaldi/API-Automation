Feature: Get Details by City

  Scenario: User calls web service to get a details by City
    Given a user retrieves the details by "London"
    Then the status code is "200"
    And response content type is JSON

  Scenario: Failed to get a details by City
    Given a user retrieves the details by "asdfsdf"
    Then the status code is "200"
    And response content type is JSON