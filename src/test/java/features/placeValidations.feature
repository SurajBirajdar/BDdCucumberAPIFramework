Feature: Validating place API
  Scenario: Verify is place is being added successfully using AddPlaceAPI
    Given Add place payload
    When user calls "AddPlaceAPI" with POST http request
    Then API call gets success with 200 status code
    And "status" in response body is "OK"
    And "scope" in response body is "APP"


