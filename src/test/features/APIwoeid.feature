Feature: Get Details by woeid

  Scenario: User calls web service to get a details by woeid
    Given a user retrieves the details by entering woeid "44418"
    Then the status code is "200"
    And response content type is JSON

  Scenario: Failed to get a details by woeid
    Given a user retrieves the details by entering woeid "42131"
    Then the status code is "200"
    And response content type is JSON