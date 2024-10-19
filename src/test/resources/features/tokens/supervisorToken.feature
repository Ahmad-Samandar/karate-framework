@Regression
Feature: Generate Token for Supervisor User

  Scenario: Generate valid token for supervisor
    Given url baseUrl
    And path '/api/token'
    And request
      """
      {
        "username": "supervisor",
        "password": "tek_supervisor"
      }
      """
    When method post
    Then status 200
    And match response != null
    And def authToken = response.token
