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
import pojos.Category;
import pojos.Product;
import pojos.UserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
    public void b_apiRequestMethodPOST() throws FileNotFoundException {

        /*UserType userType = new UserType("Men");
        Category category = new Category(userType, "Gaming Laptop");
        Product postProduct = new Product(99, "New york", "RS. 1000", "MSI", category);
        System.out.println(postProduct);*/

        File file = new File("src/test/resources/TestData/productBody.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject postProduct = new JSONObject(jsonTokener);
        System.out.println(postProduct);

        response = given().spec(spec).contentType(ContentType.JSON).body(postProduct.toString()).when().post("/{1}");
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
