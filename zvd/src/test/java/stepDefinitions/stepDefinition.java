package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;

public class stepDefinition extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add place playload")
	public void add_place_playload() throws IOException {
		
		res=given().spec(requestSpecification())
		.body(data.add_place_payload());

	}
	
	@When("user calls {string} with Post http request")
	public void user_calls_with_http_request(String resource) {
		APIResources apiResource=APIResources.valueOf(resource);
		
		 response =res.when().post(apiResource.getResource()).
				then().spec(resspec).extract().response();
		
	}

	@Then("the API call is success the verify status code {int}")
	public void the_api_call_is_success_the_verify_status_code(Integer int1) {
	    assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} is response body is {string}")
	public void status_code_is_response_body_is(String key, String val) {
	   String resp=response.asString();
	   JsonPath js=new JsonPath(resp);
	   assertEquals(js.get(key),val);
	}

}
