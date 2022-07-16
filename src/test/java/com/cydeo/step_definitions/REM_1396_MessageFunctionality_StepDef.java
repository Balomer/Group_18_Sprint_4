package com.cydeo.step_definitions;

import com.cydeo.pages.MessagePage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class REM_1396_MessageFunctionality_StepDef {

    MessagePage messagePage = new MessagePage();

    @Given("user should be able to click on message or send message text")
    public void user_should_be_able_to_click_on_message_or_send_message_text() {

        BrowserUtils.sleep(2);
        messagePage.messageButton.click();

    }

    @When("user should be able to click on add mention button below the message section")
    public void user_should_be_able_to_click_on_add_mention_button_below_the_message_section() {

        BrowserUtils.sleep(2);
        messagePage.addMentionButton.click();

    }

    @When("user should be able to click on Employees and departments module")
    public void user_should_be_able_to_click_on_employees_and_departments_module() {
        BrowserUtils.sleep(2);
        messagePage.empDepModule.click();

    }

    @When("user should be able to click on the send button")
    public void user_should_be_able_to_click_on_the_send_button() {
        BrowserUtils.sleep(2);
        messagePage.sendButton.click();

    }
    @Then("verify that the message is displayed on the screen")
    public void verify_that_the_message_is_displayed_on_the_screen() {


        BrowserUtils.sleep(2);
        Assert.assertTrue(messagePage.verifyMessageForAddMention.isDisplayed());

    }



}
