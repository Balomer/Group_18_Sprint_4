package com.cydeo.step_definitions;

import com.cydeo.pages.CRMLY_MessageFunctionPage;
import com.cydeo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class REM_1394_MessageFunction_StepDefinitions {


    LoginPage loginPage = new LoginPage();
    CRMLY_MessageFunctionPage messageFunctionPage = new CRMLY_MessageFunctionPage();

    @Given("logged in successfully with valid credentials and is on home page")
    public void logged_in_successfully_with_valid_credentials_and_is_on_home_page() {

    }

    @When("user specifies a title")
    public void user_specifies_a_title() {

    }

    @When("user specifies a recipient")
    public void user_specifies_a_recipient() {

    }

    @Then("user is able to send the message")
    public void user_is_able_to_send_the_message() {

    }

    @When("user clicks message tab")
    public void user_clicks_message_tab() {

    }

    @When("user doesn't specify a message title and tries to send the message")
    public void user_doesnt_specify_a_message_title_and_tries_to_send_the_message() {

    }

    @Then("{string} error message is given")
    public void error_message_is_given(String string) {

    }

    @When("user doesn't specify a recipient and tries to send the message")
    public void userDoesntSpecifyARecipientAndTriesToSendTheMessage() {

    }

    @Then("{string} error is given")
    public void errorIsGiven(String arg0) {

    }

    @When("user verify {string} is selected as recipient by default")
    public void userVerifyAllEmployeesIsSelectedAsRecipientByDefault() {

    }

    @And("verify user can change the default recipient.")
    public void verifyUserCanChangeTheDefaultRecipient() {

    }

    @And("user clicks add more")
    public void userClicksAddMore() {
    }

    @When("user select from {string}")
    public void user_select_from(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects from {string}")
    public void user_selects_from(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user can delete a recipient by clicking the cross sign at the selected recipient")
    public void user_can_delete_a_recipient_by_clicking_the_cross_sign_at_the_selected_recipient() {

    }

    @When("user specifies a message title")
    public void user_specifies_a_message_title() {

    }

    @When("user cancel sending messages at any time before sending by clicking cancel button")
    public void user_cancel_sending_messages_at_any_time_before_sending_by_clicking_cancel_button() {

    }
}
