package com.cydeo.failedTestsHooks;

import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.monte.screenrecorder.ScreenRecorder;

public class Hooks {

    @Before
    public void setupScenario() throws Exception {
        System.out.println("video recording started");
        BrowserUtils.startRecording();
    }

    @After
    public void teardownScenario() throws Exception {
        BrowserUtils.stopRecording();
        System.out.println("video recording stopped");

    }
}