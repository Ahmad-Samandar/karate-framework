@Regression
Feature: Generate Token for Operator User

  Scenario: Generate valid token for operator
    Given url baseUrl
    And path '/api/token'
    And request
      """
      {
        "username": "operator_readonly",
        "password": "Tek4u2024"
      }
      """
    When method post
    Then status 200
    And match response != null
    And def authToken = response.token
