package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class REM_1395_Upload_StepDefinitions {

        @Given("User should be on the homepage")
        public void userShouldBeOnTheHomepage() {
            LoginPage page=new LoginPage();
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
            page.username.sendKeys(ConfigurationReader.getProperty("loginUsername"));
            page.password.sendKeys(ConfigurationReader.getProperty("loginPassword"));
            page.login.click();
        }



}
