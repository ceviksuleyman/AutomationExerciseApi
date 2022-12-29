package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static baseUrl.AutoExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Api01 {

    Response response;
    JsonPath json;


    @Given("A_API URL {string}")
    public void apiURL(String pathParams) {

        spec.pathParams("1", pathParams);
    }

    @When("A_API Request Method GET")
    public void requestMethodGET() {

        response = given().spec(spec).when().get("/{1}");
    }

    @Then("A_API Response Code {int}")
    public void responseCode(int code) {

        json = response.jsonPath();
        assertEquals(code, response.getStatusCode());
        assertEquals(code, json.getInt("responseCode"));
    }

    @And("A_API Response JSON All products list")
    public void responseJSONAllProductsList() throws IOException {
        //json.prettyPrint();

        List<String> namesList = json.getList("products.name");
        System.out.println(namesList);


        List<String> id = json.getList("products.findAll{it.id>=30}.brand");
        System.out.println(id);


        List<String> usertype = json.getList("products.category.usertype.findAll{it.usertype}.usertype");
        System.out.println(usertype.size());
        System.out.println(usertype);


        List<String> category = json.getList("products.category.findAll{it.category}.category");
        System.out.println(category.size());
        System.out.println(category);


        List<String> products = json.getList("products.name");
        System.out.println(products);

        System.out.println(json.getList("products.category.category"));
        System.out.println(json.getString("products[0].category.usertype.usertype"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/TestData/Products.txt", false));
        List<String> productList = json.getList("products");
        for (int i = 0; i < productList.size(); i++) {

            writer.append(json.getString("products[" + i + "]")).append(",\n");
            System.out.println(json.getString("products[" + i + "]"));
        }
        writer.close();
    }
}
