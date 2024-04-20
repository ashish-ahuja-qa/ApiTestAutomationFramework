Feature: Currency Conversion API Testing


  Scenario: Verify successful API call and valid price
    Given I have a valid API end-point for currency USD
    When I make a GET request to the API
  	Then the API call is successful and returns success
   	And the response contains a valid price
   
  Scenario: Verify the API returns 162 currency pairs	
   	Given I have a valid API end-point for currency USD
    When I make a GET request to the API
    Then the response contains 162 currency pairs
    
    
  Scenario: Verify USD price against the AED 
    Given I have a valid API end-point for currency USD
    When I make a GET request to the API
    Then the status code is within the range
    And the response contains a valid price range for AED
    
   Scenario: Verify API response with the given JSON schema
   	Given I have a valid API end-point for currency "USD"
    When I make a GET request to the API
    Then the API response should matches the JSON schema  
 