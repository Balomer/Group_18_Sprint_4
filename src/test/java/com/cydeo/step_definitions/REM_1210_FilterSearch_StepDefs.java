package com.cydeo.step_definitions;

import com.cydeo.pages.ActivityStreamPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.WritableByteChannel;
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


    @And("user clicks on the date input box")
    public void userClicksOnTheDateInputBox() {

        WebElement resetButton = Driver.getDriver().findElement(By.xpath("//span[@class='ui-btn ui-btn-light-border main-ui-filter-field-button main-ui-filter-reset']"));
        resetButton.click();
        BrowserUtils.sleep(2);
        activityStreamPage.filterSearchBox.click();
        BrowserUtils.sleep(2);
        activityStreamPage.dateBox.click();

    }

    @And("user selects date")
    public void userSelectsDate() {

       //Actions actions = new Actions(Driver.getDriver());
       //actions.moveToElement(activityStreamPage.dateYesterday).perform();

       //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
       //wait.until(ExpectedConditions.elementToBeClickable(activityStreamPage.dateYesterday));


        //activityStreamPage.dateYesterday.click();

       // String javascript = "document.getElementsByClassName('main-ui-control main-ui-select')[1]";
        //JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
       // WebElement dateYesterday = (WebElement) jsExecutor.executeScript(javascript);

       // dateYesterday.click();

       /* Driver.getDriver().findElement(By.cssSelector("#LIVEFEED_search")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='main-ui-control main-ui-select']")).click();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveByOffset(1830,365).click().perform();
        Driver.getDriver().findElement(By.xpath("//button[@class='ui-btn ui-btn-primary ui-btn-icon-search main-ui-filter-field-button  main-ui-filter-find']")).click();*/

        Actions actions = new Actions(Driver.getDriver());
        WebElement anyDate = Driver.getDriver().findElement(By.xpath("//span[.='Any date']"));
        BrowserUtils.sleep(2);
        actions.moveToElement(anyDate).moveByOffset(75,75).click().perform();
        BrowserUtils.sleep(2);


    }

    @And("user clicks on the search button")
    public void userClicksOnTheSearchButton() {

        activityStreamPage.searchButton.click();
        BrowserUtils.sleep(2);

    }

    @Then("the selected date should be displayed on the filter and search box")
    public void theSelectedDateShouldBeDisplayedOnTheFilterAndSearchBox() {

        //System.out.println(Driver.getDriver().findElement(By.xpath("//div[@class='main-ui-filter-search-square main-ui-square']")).getText());
        WebElement filterMessage = Driver.getDriver().findElement(By.xpath("//div[@class='main-ui-square-item']"));
        System.out.println(filterMessage.getText());
        Assert.assertTrue(filterMessage.getText().contains("Yesterday"));

    }

    @And("user clicks on the save filter module")
    public void userClicksOnTheSaveFilterModule() {
        activityStreamPage.saveFilterModule.click();
    }

    @And("user enters filter {string}")
    public void userEntersFilter(String name) {
        activityStreamPage.filterNameInputBox.sendKeys(name);
    }


    @And("user clicks on the save button")
    public void userClicksOnTheSaveButton() {

        activityStreamPage.saveButton.click();
    }


    @Then("the provided filter name {string} should be displayed under the filters")
    public void theProvidedFilterNameShouldBeDisplayedUnderTheFilters(String name) {

        List<String> actualDefaultFilters = BrowserUtils.getElementsText(activityStreamPage.filterModules);
        System.out.println(actualDefaultFilters);
        Assert.assertTrue(actualDefaultFilters.contains(name));

    }

    @And("user clicks on the type input box")
    public void userClicksOnTheTypeInputBox() {

        activityStreamPage.typeInputBox.click();
    }

    @And("user selects single type as {string}")
    public void userSelectsSingleTypeAs(String type) {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activityStreamPage.typeInputBox).moveByOffset(45,45).click().perform();
        BrowserUtils.sleep(2);
    }

    @Then("the selected type {string} should be displayed on the filter and search box")
    public void theSelectedTypeShouldBeDisplayedOnTheFilterAndSearchBox(String type) {

        WebElement filterMessage = Driver.getDriver().findElement(By.xpath("//div[@class='main-ui-square-item']"));
        System.out.println(filterMessage.getText());
        Assert.assertTrue(filterMessage.getText().contains(type));
        BrowserUtils.sleep(2);
    }

    @And("user selects multiple types as")
    public void userSelectsMultipleTypesAs() {
        activityStreamPage.filterSearchBox.click();
        WebElement resetButton = Driver.getDriver().findElement(By.xpath("//span[@class='ui-btn ui-btn-light-border main-ui-filter-field-button main-ui-filter-reset']"));
        resetButton.click();
        BrowserUtils.sleep(2);
        activityStreamPage.filterSearchBox.click();
        activityStreamPage.typeInputBox.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activityStreamPage.typeInputBox).moveByOffset(45,45).click().perform();
        BrowserUtils.sleep(2);
        actions.moveToElement(activityStreamPage.typeInputBox).moveByOffset(50,75).click().perform();
    }

    @Then("the selected types should be displayed on the filter and search box")
    public void theSelectedTypesShouldBeDisplayedOnTheFilterAndSearchBox(List<String>types) {

        List<String> actualDefaultFilters = BrowserUtils.getElementsText(activityStreamPage.filterModules);
        System.out.println(actualDefaultFilters);
        Assert.assertTrue(actualDefaultFilters.contains(types.get(0))
                & actualDefaultFilters.contains(types.get(1)));

    }
}

