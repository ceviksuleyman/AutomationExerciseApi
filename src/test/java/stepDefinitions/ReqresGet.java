package stepDefinitions;

import io.restassured.response.Response;
import org.junit.Test;
import pojos.reqresPojo.Reqres;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class ReqresGet {

    @Test
    public void test01() {

        Reqres reqres;

        Response response = given()
                .pathParams("myPath", "users").queryParam("page", 2).queryParam("id", 5)
                .when()
                .get("https://reqres.in/api/{myPath}");


        response.prettyPrint();


        //Reqres actualData = response.as(Reqres.class);
        reqres = ObjectMapperUtils.convertJsonToJava(response.asString(),Reqres.class);

        System.out.println(reqres);

        System.out.println(reqres.getData().getFirst_name());
        System.out.println(reqres.getData().getLast_name());
        System.out.println(reqres.getData().getEmail());

    }
}
