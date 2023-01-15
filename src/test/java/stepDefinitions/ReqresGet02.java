package stepDefinitions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class ReqresGet02 {

    @Test
    public void test() {

        Response response = given()
                .pathParams("myPath", "users").queryParam("page", 2)
                .when()
                .get("https://reqres.in/api/{myPath}");


        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        System.out.println(jsonPath.getString("data[0].first_name"));

        response.then().body("data[0].first_name", Matchers.equalTo("Michael"));

        Assert.assertEquals("Michael", jsonPath.getString("data[0].first_name"));

        jsonPath.getList("data.findAll{it.email=='michael.lawson@reqres.in'}").stream().forEach(t -> System.out.println(t));
        jsonPath.getList("data.findAll{it.email=='michael.lawson@reqres.in'}.last_name").stream().forEach(t -> System.out.println(t));
        jsonPath.getList("data.findAll{it.first_name}.first_name").stream().forEach(t -> System.out.println(t));
    }
}
