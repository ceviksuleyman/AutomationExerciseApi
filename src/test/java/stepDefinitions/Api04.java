package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static baseUrl.AutoExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class Api04 {
    Response response;
    JsonPath json;

    @Given("D_API URL {string}")
    public void d_apiURL(String pathParams) {

        spec.pathParams("1", pathParams);
    }

    @When("D_Request Method PUT")
    public void d_requestMethodPUT() throws FileNotFoundException {

        // Brand brandPut = new Brand(44, "MSI");

        File file = new File("src/test/resources/testData/brandBody.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject brandPut = new JSONObject(jsonTokener);

        response = given().spec(spec).contentType(ContentType.JSON).body(brandPut.toString()).when().put("{1}");

        json = response.jsonPath();
        json.prettyPrint();
    }

    @Then("D_Response Code {int}")
    public void d_responseCode(int responseCode) {

        Assert.assertEquals(200, response.getStatusCode());

        Assert.assertEquals(responseCode, json.getInt("responseCode"));
    }

    @And("D_Response Message This request method is not supported.")
    public void d_responseMessageThisRequestMethodIsNotSupported() {

        String expectedMessage = "This request method is not supported.";

        Assert.assertEquals(expectedMessage, json.getString("message"));
    }
}
