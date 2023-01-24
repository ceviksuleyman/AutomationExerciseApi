package stepDefinitions;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import org.junit.Assert;
import org.junit.Test;
import utilities.ConfigReader;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class Exercise {

    @Test
    public void test01() {

        // https://reqres.in/api/users?page=2&id=5
        given().pathParams("myPath", "users")
                .queryParam("page", 2)
                .queryParam("id", 5)
                .when()
                .get(ConfigReader.getProperty("reqresApiBaseUrl") + "{myPath}")
                .prettyPrint();
    }

    @Test
    public void parsingTestXMLResponse() {

        given()
                .when()
                .get(ConfigReader.getProperty("restApiBaseUrl") + "Traveler?page=1")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/xml; charset=utf-8")
                .body("TravelerinformationResponse.page", Matchers.equalTo("1"))
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", Matchers.equalTo("Developer"));


        Response response = given()
                .when()
                .get(ConfigReader.getProperty("restApiBaseUrl") + "Traveler?page=1");

        assertEquals(200, response.getStatusCode());
        assertEquals("application/xml; charset=utf-8", response.header("Content-Type"));

        // xmlPath
        String pageNO = response.xmlPath().get("TravelerinformationResponse.page").toString();
        assertEquals("1", pageNO);

        String travelerName = response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
        assertEquals("Developer", travelerName);
    }

    @Test
    public void testXMLResponseBody() {

        Response response = given()
                .when()
                .get(ConfigReader.getProperty("restApiBaseUrl") + "Traveler?page=1");

        // 1.
        XmlPath xmlPath = response.xmlPath();
        xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.email").forEach(System.out::println);

        // 2.
        xmlPath = new XmlPath(response.asString());


        // Verify total number of travelers
        List<String> travelers = xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");
        Assert.assertEquals(10, travelers.size());


        // verify traveler name is present in response
        List<String> traveler_names = xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
        boolean status = false;
        for (String travelerName : traveler_names) {

            if (travelerName.equals("Developer")) {
                status = true;
                break;
            }
        }
        Assert.assertTrue(status);
    }
}
