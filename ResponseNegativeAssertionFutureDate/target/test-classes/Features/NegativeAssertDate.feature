Feature: RestAssured Script Response Negative Scenario Assertion for Future Date

  Scenario: Validation of response code when future date is passed
    Given API for foreign Exchange
    When posted with future date information
    Then validate positive response code received
