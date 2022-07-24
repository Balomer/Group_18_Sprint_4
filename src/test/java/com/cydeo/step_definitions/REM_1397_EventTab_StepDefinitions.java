package com.cydeo.step_definitions;

import com.cydeo.pages.EventTab;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class REM_1397_EventTab_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    EventTab eventTab = new EventTab();

    @Given("User logged in to the homepage and clicked Calender from menu")
    public void user_logged_in_to_the_homepage_and_clicked_calender_from_menu() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        loginPage.username.sendKeys(ConfigurationReader.getProperty("loginUsername"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("loginPassword"));
        loginPage.login.click();

    }

    @When("User click to add on the Event tab")
    public void user_click_to_add_on_the_event_tab() {
        eventTab.addEvent.click();
    }
    @When("User should be able to select {string}")
    public void user_should_be_able_to_select(String string) {

    }
    @When("User should be specify time zone.")
    public void user_should_be_specify_time_zone() {

    }

    @When("User should be able to select Reminder")
    public void user_should_be_able_to_select_reminder() {

    }
    @Then("User should click to Save button")
    public void user_should_click_to_save_button() {

    }
    @When("User should be able to access location dropdown")
    public void user_should_be_able_to_access_location_dropdown() {

    }
    @Then("User should be able to select event location")
    public void user_should_be_able_to_select_event_location() {

    }

    @When("User should be able to add members")
    public void user_should_be_able_to_add_members() {

    }
    @Then("User should be contact adding group and departments")
    public void user_should_be_contact_adding_group_and_departments() {

    }

    @When("User should be able to filling the Event name")
    public void user_should_be_able_to_filling_the_event_name() {

    }
    @Then("User should be able to filling start and end date")
    public void user_should_be_able_to_filling_start_and_end_date() {

    }

    @When("User should be able to add on the Event tab")
    public void user_should_be_able_to_add_on_the_event_tab() {

    }
    @When("User should be able to create new event")
    public void user_should_be_able_to_create_new_event() {

    }
    @Then("User should be able to click Cancel button")
    public void user_should_be_able_to_click_cancel_button() {

    }


}
