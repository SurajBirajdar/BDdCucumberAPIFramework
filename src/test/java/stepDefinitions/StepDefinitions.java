package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import pojo.googlePlaceApiPojo.AddPlaceApi;
import pojo.googlePlaceApiPojo.Location;
import resources.TestDataBuild;
import resources.Utils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefinitions extends Utils {
    RequestSpecification response;
    Response res;
    TestDataBuild testData = new TestDataBuild();
    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) {
        response = given()
                .spec(requestSpecification())
                .body(testData.addPlacePayload(name, language, address));
    }
    @When("user calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
        res = response.when().post("/maps/api/place/add/json")
                .then()
                .extract()
                .response();
    }
    @Then("API call gets success with {int} status code")
    public void api_call_gets_success_with_status_code(Integer int1) {
        Assert.assertEquals(res.getStatusCode(),200);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        String resp = res.asString();
        JsonPath js = new JsonPath(resp);
        Assert.assertEquals(js.get(keyValue),expectedValue);
    }
}
