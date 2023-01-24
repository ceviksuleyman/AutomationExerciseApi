package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

public class AutoExerciseBaseUrl {

    public static RequestSpecification spec;

    public static void autoExerciseSetup() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("autoExBaseUrl")).build();
    }

}
