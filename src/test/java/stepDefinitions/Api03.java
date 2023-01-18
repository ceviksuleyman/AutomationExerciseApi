package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static baseUrl.AutoExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class Api03 {

    Response response;
    JsonPath json;

    @Given("C_API URL {string}")
    public void c_apiURL(String pathParams) {

        spec.pathParams("1", pathParams);
    }

    @When("C_Request Method GET")
    public void c_requestMethodGET() {

        response = given().spec(spec).when().get("/{1}");
        json = response.jsonPath();
    }

    @Then("C_Response Code {int}")
    public void c_responseCode(int code) {

        Assert.assertEquals(200, response.getStatusCode());

        Assert.assertEquals(code, json.getInt("responseCode"));
    }

    @And("C_Response JSON All brands list")
    public void c_responseJSONAllBrandsList() throws IOException {

        json.prettyPrint();

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/TestData/Brands.txt", false));
        List<String> brandsList = json.getList("brands");
        for (int i = 0; i < brandsList.size(); i++) {

            writer.append(json.getString("brands[" + i + "]")).append(",\n");
            System.out.println(json.getString("brands[" + i + "]"));
        }
        writer.close();




        // JSONObject
        JSONObject jsonObject = new JSONObject(response.asString());
        System.out.println(jsonObject);
        for (int i = 0; i < jsonObject.getJSONArray("brands").length(); i++) {

            System.out.println(jsonObject.getJSONArray("brands").getJSONObject(i));
            System.out.println(jsonObject.getJSONArray("brands").getJSONObject(i).get("brand").toString());
        }

        System.out.println(jsonObject.getJSONArray("brands").getJSONObject(0).toString());

    }
}
