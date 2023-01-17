package stepDefinitions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.json.JSONObject;
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


        // JsonPath
        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        System.out.println(jsonPath.getString("data[0].first_name"));

        response.then().body("data[0].first_name", Matchers.equalTo("Michael"));

        Assert.assertEquals("Michael", jsonPath.getString("data[0].first_name"));

        jsonPath.getList("data.findAll{it.email=='michael.lawson@reqres.in'}").stream().forEach(t -> System.out.println(t));
        jsonPath.getList("data.findAll{it.email=='michael.lawson@reqres.in'}.last_name").stream().forEach(t -> System.out.println(t));
        jsonPath.getList("data.findAll{it.first_name}.first_name").stream().forEach(t -> System.out.println(t));


        // JSONObject
        JSONObject jsonObject = new JSONObject(response.asString());
        System.out.println(jsonObject);
        for (int i = 0; i < jsonObject.getJSONArray("data").length(); i++) {

            System.out.println(jsonObject.getJSONArray("data").getJSONObject(i).get("email").toString());
        }

        System.out.println(jsonObject.getJSONArray("data").getJSONObject(0).toString());


        boolean status = false;

        for (int i = 0; i < jsonObject.getJSONArray("data").length(); i++) {

            String email = jsonObject.getJSONArray("data").getJSONObject(i).get("email").toString();

            if (email.equals("michael.lawson@reqres.in")) {

                status = true;
                break;
            }
        }
        Assert.assertEquals(status, true);




    }
}
