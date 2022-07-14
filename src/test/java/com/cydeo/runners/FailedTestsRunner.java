package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "junit:target/junit/junit-report.xml",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        features = "@target/rerun.txt",
        glue = {"com/cydeo/step_definitions","com/cydeo/failedTestsHooks"}
)
public class FailedTestsRunner {
}
