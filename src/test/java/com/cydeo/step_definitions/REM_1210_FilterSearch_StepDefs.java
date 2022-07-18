package com.cydeo.step_definitions;

import com.cydeo.pages.ActivityStreamPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class REM_1210_FilterSearch_StepDefs {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();

    @When("user clicks on the filter and search box")
    public void user_clicks_on_the_filter_and_search_box() {

        activityStreamPage.filterSearchBox.click();
    }

    @When("user clicks on the edit gear")
    public void user_clicks_on_the_edit_gear() {

        activityStreamPage.editGearField.click();
    }


    @When("user clicks on the reset to default module")
    public void user_clicks_on_the_reset_to_default_module() {

        activityStreamPage.resetToDefaultField.click();

    }

    @When("user clicks the continue button on the pop-up message")
    public void user_clicks_the_continue_button_on_the_pop_up_message() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.continueAlert));

        activityStreamPage.continueAlert.click();

    }

    @Then("user sees default filters as")
    public void user_sees_default_filters_as(List<String > expectedDefaultFilters) {

        List<String> actualDefaultFilters = BrowserUtils.getElementsText(activityStreamPage.filterModules);
        actualDefaultFilters.removeIf(n -> n.equals("AHMET"));

        Assert.assertEquals(expectedDefaultFilters, actualDefaultFilters);

    }

    @When("user clicks on the add file module")
    public void user_clicks_on_the_add_file_module() {

        activityStreamPage.addField.click();

    }
    @When("user clicks on the date field")
    public void user_clicks_on_the_date_field() {

       activityStreamPage.dateField.click();
    }

    @Then("the date input box is added")
    public void the_date_input_box_is_added() {

        Assert.assertTrue(activityStreamPage.dateBox.isDisplayed());

    }

    @And("user clicks on the delete icon")
    public void userClicksOnTheDeleteIcon() {

        activityStreamPage.dateBoxDeleteIcon.click();
    }


    @Then("the date input box is removed")
    public void theDateInputBoxIsRemoved() {

    try{
        Assert.assertFalse(activityStreamPage.dateBox.isDisplayed());
    }catch (Exception e){
        System.out.println("Stale reference element");
    }

    }


}
