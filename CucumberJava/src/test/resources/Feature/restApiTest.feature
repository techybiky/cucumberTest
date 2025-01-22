Feature: API Testing using Cucumber and REST Assured

  @instance_1
  Scenario: Validate the GET endpoint
    Given the base URL is "https://jsonplaceholder.typicode.com"
    When I make a GET request to "/posts/1"
    Then the response status code should be 200
    And the response should contain "userId" with value 1
    And the response should contain "id" with value 1

  @instance_2
  Scenario: Valdiate the GET endpoint
    Given the base URL is "https://reqres.in"
    When I make a GET request to "/api/users"
    Then the response status code should be 200
    And the response should contain "George" and "Bluth"
    And the response should contain key "id" with value 1

  @instance_3
  Scenario: Validiate the POST request
  	Given the API endpoint is "https://reqres.in/api/register"
  	Then create a post request using below data
  	|email|password|
  	|bikram@gmail.com|bikram@123|
  	
  @instance_4
  Scenario: Validate the PUT request
  	Given the API endpoint is "https://reqres.in/api/users/2"
  	When I send a PUT request with the following data
  	| email | first_name |
  	| bikramDas@gmail.in | Bikram |
  	Then the response status code should be 201
  	And response should contain
  	| email | first_name |
  	| bikramDas@gmail.in | Bikram |
  	
  @instance_5
  Scenario: Validate the DELETE request
  	Given the API endpoint is "https://reqres.in/api/users/2"
  	When I send a Delete Request
  	Then the response status code should be 204