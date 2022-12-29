package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Category;
import pojos.Product;
import pojos.UserType;

import static baseUrl.AutoExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class Api02 {

    Response response;
    JsonPath json;

    @Given("B_API URL {string}")
    public void b_apiURL(String pathParams) {

        spec.pathParams("1", pathParams);
    }

    @When("B_API Request Method POST")
    public void b_apiRequestMethodPOST() {

        UserType userType = new UserType("Men");
        Category category = new Category(userType, "Gaming Laptop");
        Product postProduct = new Product(99, "New york", "RS. 1000", "MSI", category);

        response = given().spec(spec).contentType(ContentType.JSON).body(postProduct).when().post("/{1}");
        //response.prettyPeek();
    }

    @Then("B_API Response Code {int}")
    public void b_apiResponseCode(int code) {

        Assert.assertEquals(200, response.getStatusCode());

        json = response.jsonPath();
        json.prettyPrint();
        Assert.assertEquals(code, json.getInt("responseCode"));
    }

    @And("B_API Response Message This request method is not supported.")
    public void b_apiResponseMessageThisRequestMethodIsNotSupported() {

        String expectedMessage = "This request method is not supported.";

        Assert.assertEquals(expectedMessage, json.getString("message"));
    }
}
