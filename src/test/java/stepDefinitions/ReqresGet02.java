package stepDefinitions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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
        System.out.println(jsonPath.getString("data[0]"));

        
    }
}
