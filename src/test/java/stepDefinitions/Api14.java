package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static baseUrl.AutoExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Api14 {

    Response response;
    JsonPath json;

    @Given("Z_API URL {string} query {string}")
    public void z_apiURL(String pathParam, String queryParam) {

        spec.pathParams("1", pathParam).queryParam("email", queryParam);
    }

    @When("Z_Request Method GET")
    public void z_requestMethodGET() {

        response = given().spec(spec).when().get("/{1}");
        json = response.jsonPath();
    }

    @Then("Z_Response Code {int}")
    public void z_responseCode(int responseCode) {

        assertEquals(200, response.getStatusCode());

        assertEquals(responseCode, json.getInt("responseCode"));
    }

    @And("Z_Response JSON User Detail")
    public void z_responseJSONUserDetail() {

        json.prettyPrint();

        assertEquals("Automation", json.getString("user.name"));
        assertEquals("automation01@gmail.com", json.getString("user.email"));
        assertEquals("Mr", json.getString("user.title"));
        assertEquals("21", json.getString("user.birth_day"));
        assertEquals("2", json.getString("user.birth_month"));
        assertEquals("1993", json.getString("user.birth_year"));
        assertEquals("Automation", json.getString("user.first_name"));
        assertEquals("Exercise", json.getString("user.last_name"));
        assertEquals("Freelancer", json.getString("user.company"));
        assertEquals("New york Mahallesi Zimbabwe", json.getString("user.address1"));
        assertEquals("Zimbabwe Uganda Cumhuriyeti", json.getString("user.address2"));
        assertEquals("Australia", json.getString("user.country"));
        assertEquals("Podoso", json.getString("user.state"));
        assertEquals("Usak", json.getString("user.city"));
        assertEquals("6590902", json.getString("user.zipcode"));
    }
}
