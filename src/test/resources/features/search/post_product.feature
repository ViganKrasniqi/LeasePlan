@Leaseplan_TaskID_1009341
Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/demo/{product} for getting the products.
### Available products: "orange", "apple", "pasta", "cola"
### Prepare Positive and negative scenarios

  Scenario Outline: Check for the endpoint response for different products
    When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/<product>"
    Then he should get the 200 status code
    Then he sees the results displayed for product

    Examples:
      | product |
      | apple   |
      | orange  |
      | cola    |

  Scenario: Check if bad request gives the right status code
    When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/ad"
    Then he should get the 404 status code
    Then he doesn't see the results of "ad"

