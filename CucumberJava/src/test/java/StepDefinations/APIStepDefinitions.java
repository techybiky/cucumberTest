package StepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIStepDefinitions {

	private Response response;
	private String endpoint;
	private static Logger logger = Logger.getLogger(APIStepDefinitions.class.getName());

	@Given("the base URL is {string}")
	public void theBaseURLIs(String baseURL) {
		RestAssured.baseURI = baseURL;
	}

	@Given("the API endpoint is {string}")
	public void theApiEndpointIs(String url) {
		this.endpoint = url;
	}

	@When("I make a GET request to {string}")
	public void iMakeAGETRequestTo(String endpoint) {
		response = given().get(endpoint);
	}

	@Then("the response status code should be {int}")
	public void theResponseStatusCodeShouldBe(int statusCode) {
		Assert.assertEquals(statusCode, response.statusCode());
	}

	@Then("the response should contain {string} with value {int}")
	public void theResponseShouldContainWithValue(String key, int value) {
		response.then().body(key, equalTo(value));
		System.out.println(response.then().body(key, equalTo(value)));
	}

	@Then("the response should contain {string} and {string}")
	public void the_response_should_contain_and(String string, String string2) {
		response.then().body("data[0].first_name", equalTo(string)).body("data[0].last_name", equalTo(string2));
	}

	@Then("the response should contain key {string} with value {int}")
	public void the_response_should_contain_key_with_value(String key, Integer value) {
		response.then().body("data[0]." + key, equalTo(value));

	}

	@Then("create a post request using below data")
	public void create_a_post_request_using_below_data(DataTable table) {
		Map<String, String> map = table.asMap(String.class, String.class);
		response = given().header("Contain-Type", "application/json").body(map).post(endpoint);
		logger.info("JSON Map" + map);
	}

	@When("I send a PUT request with the following data")
	public void i_send_a_put_request_with_the_following_data(DataTable table) {
		Map<String, String> map = table.asMap(String.class, String.class);
		response = given().header("Contain-Type", "application/json").body(map).post(endpoint);
		logger.info("JSON Map" + map);
	}

	@Then("response should contain")
	public void response_should_contain(DataTable table) {
		Map<String, String> expectedData = table.asMap(String.class, String.class);

	    // Loop through the map and validate the response against expected data
	    for (Map.Entry<String, String> entry : expectedData.entrySet()) {
	        // Extract the actual value from the JSON response body using JSONPath
	        String actualValue = response.jsonPath().getString(entry.getKey());

	        // Assert that the actual value matches the expected value
	        assertEquals("The " + entry.getKey() + " does not match", entry.getValue(), actualValue);
	    }
	}

	@When("I send a Delete Request")
	public void i_send_a_delete_request() {
		response = given().delete(endpoint);
		logger.info("Endpoint Deleted");
	}

}
