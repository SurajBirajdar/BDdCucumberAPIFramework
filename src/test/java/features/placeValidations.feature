Feature: Validating place API
  Scenario Outline: Verify whether place is being added successfully using AddPlaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with POST http request
    Then API call gets success with 200 status code
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Examples:
      | name    | language | address            |
      | AAhouse | English  | World cross center |
      | BBhouse | Spanish  | Sea cross center   |




