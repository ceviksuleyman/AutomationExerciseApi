package stepDefinitions;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Exercise {

    @Test
    public void test01() {

        // https://reqres.in/api/users?page=2&id=5
        given().pathParams("myPath", "users").queryParam("page", 2).queryParam("id", 5)
                .when()
                .get("https://reqres.in/api/{myPath}")
                .prettyPrint();
    }
}
