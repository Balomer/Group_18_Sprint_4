package com.cydeo.step_definitions;

import com.cydeo.pages.ActivityStreamPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.WritableByteChannel;
import java.util.List;

import static org.junit.Assert.*;

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

        assertEquals(expectedDefaultFilters, actualDefaultFilters);

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

        assertTrue(activityStreamPage.dateBox.isDisplayed());

    }

    @And("user clicks on the delete icon")
    public void userClicksOnTheDeleteIcon() {

        activityStreamPage.dateBoxDeleteIcon.click();
    }


    @Then("the date input box is removed")
    public void theDateInputBoxIsRemoved() {

    try{
        assertFalse(activityStreamPage.dateBox.isDisplayed());
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
        assertTrue(filterMessage.getText().contains("Yesterday"));

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
        assertTrue(actualDefaultFilters.contains(name));

    }

    @And("user clicks on the type input box")
    public void userClicksOnTheTypeInputBox() {
        //WebElement resetButton = Driver.getDriver().findElement(By.xpath("//span[@class='ui-btn ui-btn-light-border main-ui-filter-field-button main-ui-filter-reset']"));
       // resetButton.click();
        //activityStreamPage.filterSearchBox.click();
        //BrowserUtils.sleep(2);
        activityStreamPage.resetButton.click();
        BrowserUtils.sleep(2);
        activityStreamPage.filterSearchBox.click();
        activityStreamPage.typeInputBox.click();
    }

    @And("user selects single type as {string}")
    public void userSelectsSingleTypeAs(String type) {

        //Driver.getDriver().findElement(By.xpath("(//div[.='Conversations'])[2]")).click();
        Actions actions = new Actions(Driver.getDriver());
        //WebElement typeEmptybox = Driver.getDriver().findElement(By.xpath("//span[@class='main-ui-square-container']"));
        //BrowserUtils.sleep(2);
        actions.moveToElement(activityStreamPage.typeInputBox).moveByOffset(45,45).click().perform();
        BrowserUtils.sleep(4);

    }

    @Then("the selected type {string} should be displayed on the filter and search box")
    public void theSelectedTypeShouldBeDisplayedOnTheFilterAndSearchBox(String type) {

        WebElement filterMessage = Driver.getDriver().findElement(By.xpath("(//div[contains (text(), 'Posts')])[2]"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(filterMessage));
        System.out.println(filterMessage.getText());
        assertTrue(filterMessage.getText().contains(type));
        BrowserUtils.sleep(2);
    }
/*
    @And("user selects multiple types as")
    public void userSelectsMultipleTypesAs() {
        WebElement deleteIcon = Driver.getDriver().findElement(By.xpath("(//span[@class='main-ui-item-icon main-ui-delete'])[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(deleteIcon).click().perform();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(activityStreamPage.filterSearchBox));
        activityStreamPage.filterSearchBox.click();
        BrowserUtils.sleep(2);
        activityStreamPage.typeInputBox.click();
        actions.moveToElement(activityStreamPage.typeInputBox).moveByOffset(45,45).click().perform();
        BrowserUtils.sleep(2);
        activityStreamPage.typeInputBox.click();
        actions.moveToElement(activityStreamPage.typeInputBox).moveByOffset(50,75).click().perform();
    }

    @Then("the selected types should be displayed on the filter and search box")
    public void theSelectedTypesShouldBeDisplayedOnTheFilterAndSearchBox(List<String>types) {

        List<String> actualDefaultFilters = BrowserUtils.getElementsText(activityStreamPage.filterModules);
        System.out.println(actualDefaultFilters);
        assertTrue(actualDefaultFilters.contains(types.get(0))
                && actualDefaultFilters.contains(types.get(1)));
    }*/


    @And("user deletes the date input box, type input box, author input box, to input box")
    public void userDeletesTheDateInputBoxTypeInputBoxAuthorInputBoxToInputBox() {

        activityStreamPage.restoreToDefaultFields.click();
        activityStreamPage.fieldDeleteIcon.click();
        activityStreamPage.fieldDeleteIcon.click();
        activityStreamPage.fieldDeleteIcon.click();
        activityStreamPage.fieldDeleteIcon.click();
        BrowserUtils.sleep(3);

        /*try{
            assertFalse(activityStreamPage.dateBox.isDisplayed());
            assertFalse(activityStreamPage.typeInputBox.isDisplayed());
            assertFalse(activityStreamPage.authorInputBox.isDisplayed());
            assertFalse(activityStreamPage.toInputBox.isDisplayed());
        } catch (StaleElementReferenceException e){

        }*/

    }

    @And("user clicks on the restore default fields")
    public void userClicksOnTheRestoreDefaultFields() {
        
        activityStreamPage.restoreToDefaultFields.click();
        BrowserUtils.sleep(3);


    }

    @Then("the default fields should be visible")
    public void theDefaultFieldsShouldBeVisible() {
        WebElement dateBoxNew = Driver.getDriver().findElement(By.xpath("//div[@class='main-ui-control-field']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(dateBoxNew));
        assertTrue(dateBoxNew.isDisplayed());
        //WebElement inputBoxNew = Driver.getDriver().findElement(By.xpath("//div[@class='main-ui-control-field']"));
        assertTrue(activityStreamPage.typeInputBox.isDisplayed());
        assertTrue(activityStreamPage.authorInputBox.isDisplayed());
        assertTrue(activityStreamPage.toInputBox.isDisplayed());
    }


    @And("user clicks on the reset button")
    public void userClicksOnTheResetButton() {

        activityStreamPage.resetButton.click();
        BrowserUtils.sleep(4);
        activityStreamPage.filterSearchBox.click();
    }

    @And("user selects multiple types as")
    public void userSelectsMultipleTypesAs(List<String> types) {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activityStreamPage.typeInputBox).moveByOffset(45,45).click().perform();
        BrowserUtils.sleep(4);
        actions.moveToElement(activityStreamPage.typeInputBox).moveByOffset(50,75).click().perform();
        BrowserUtils.sleep(4);


    }

    @Then("the selected types should be displayed on the filter and search box")
    public void theSelectedTypesShouldBeDisplayedOnTheFilterAndSearchBox(List<String> types) {

        WebElement filterMessage = Driver.getDriver().findElement(By.xpath("(//div[contains (text(), 'Posts')])[2]"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(filterMessage));
        System.out.println(filterMessage.getText());
        assertTrue(filterMessage.getText().contains(types.get(0)));
        assertTrue(filterMessage.getText().contains(types.get(1)));
        BrowserUtils.sleep(2);
    }

    @And("user deletes the {string}")
    public void userDeletesThe(String type) {

        activityStreamPage.filterSearchDeleteIcon.click();
        BrowserUtils.sleep(3);
    }
}

