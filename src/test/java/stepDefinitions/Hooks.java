package stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static baseUrl.AutoExerciseBaseUrl.autoExerciseSetup;

public class Hooks {

    @Before
    public void beforeRoomApi(Scenario scenario) {

        autoExerciseSetup();
    }//
}
