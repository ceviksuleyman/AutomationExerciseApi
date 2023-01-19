package stepDefinitions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class RestfulPost {

    @Test
    public void post() throws FileNotFoundException {


        File file = new File("src/test/resources/TestData/RestfulPostBody.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject expectedDataJSONObject = new JSONObject(jsonTokener);


        Response response = given().pathParam("1", "booking")
                .contentType(ContentType.JSON)
                .body(expectedDataJSONObject.toString())
                .when().post("https://restful-booker.herokuapp.com/{1}");

        response.prettyPrint();


        // JSONObject
        JSONObject ActualJSONObject = new JSONObject(response.asString());
        System.out.println("ActualJSONObject = " + ActualJSONObject);


        // Do Assertion
        // booking
        assertEquals(expectedDataJSONObject.getString("firstname"), ActualJSONObject.getJSONObject("booking").getString("firstname"));
        assertEquals(expectedDataJSONObject.getString("lastname"), ActualJSONObject.getJSONObject("booking").getString("lastname"));
        assertEquals(expectedDataJSONObject.getInt("totalprice"), ActualJSONObject.getJSONObject("booking").getInt("totalprice"));
        assertEquals(expectedDataJSONObject.getBoolean("depositpaid"), ActualJSONObject.getJSONObject("booking").getBoolean("depositpaid"));

        //bookingdates
        assertEquals(expectedDataJSONObject.getJSONObject("bookingdates").getString("checkin"),
                ActualJSONObject.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"));

        assertEquals(expectedDataJSONObject.getJSONObject("bookingdates").getString("checkout"),
                ActualJSONObject.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"));
    }
}
