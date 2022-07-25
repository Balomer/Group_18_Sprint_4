package com.cydeo.step_definitions;

import com.cydeo.pages.CRMLY_MessageFunctionPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class REM_1394_MessageFunction_StepDefinitions {


    LoginPage loginPage = new LoginPage();
    CRMLY_MessageFunctionPage messageFunctionPage = new CRMLY_MessageFunctionPage();

    @Given("logged in successfully with valid credentials and is on home page")
    public void logged_in_successfully_with_valid_credentials_and_is_on_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.username.sendKeys(ConfigurationReader.getProperty("loginUsername"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("loginPassword"));
        loginPage.login.click();
    }

    @When("user clicks message tab")
    public void user_clicks_message_tab() {
        messageFunctionPage.messageTab.click();

    }

    @And("user clicks open topic box  tab if not seen")
    public void userClicksOpenTopicBoxTabIfNotSeen() {
       if (!(messageFunctionPage.topicBody.isEnabled())){
           messageFunctionPage.openTopicBoxTab.click();
       }
    }

    @When("user specifies a statement in the topic box")
    public void userSpecifiesAStatementInTheTopicBox() {
        messageFunctionPage.topicBody.sendKeys("Topic Here");
    }
    @Then("user verifies that {string} error message is given")
    public void userVerifiesThatErrorMessageIsGiven(String string) {
                Assert.assertEquals(string,messageFunctionPage.topicBoxErrorMessage.getText());

    }

    @When("user specifies a title")
    public void user_specifies_a_title() {
//        WebDriverWait webDriverWait= new WebDriverWait(Driver.getDriver(),10);
//        webDriverWait.until(ExpectedConditions.visibilityOf(messageFunctionPage.messageBody));

        Driver.getDriver().switchTo().frame(messageFunctionPage.iframe);
        messageFunctionPage.messageBody.sendKeys("Message Title Here");
        Driver.getDriver().switchTo().parentFrame();

    }

    @When("user specifies a recipient")
    public void user_specifies_a_recipient() {
        messageFunctionPage.addMore.click();
        messageFunctionPage.addRecentSign.click();
        /*for (WebElement eachRecipient : messageFunctionPage.toChooseFromEmailUsersFromAddMore) {
            eachRecipient.click();
        }*/
        for (WebElement recentRecipient : messageFunctionPage.addFromRecent) {
            recentRecipient.click();
            break;
        }
    }

    @Then("user is able to send the message")
    public void user_is_able_to_send_the_message() {
        messageFunctionPage.sendButton.click();
        Assert.assertTrue(messageFunctionPage.messageSent.isDisplayed());

    }


    @When("user doesn't specify a message title and tries to send the message")
    public void user_doesnt_specify_a_message_title_and_tries_to_send_the_message() {

        messageFunctionPage.sendButton.click();

    }

    @Then("{string} error message is given")
    public void error_message_is_given(String string) {

        Assert.assertEquals(string, messageFunctionPage.titleAbcentErrorMessage.getText());
    }

    @When("user doesn't specify a recipient and tries to send the message")
    public void userDoesntSpecifyARecipientAndTriesToSendTheMessage() {
        messageFunctionPage.sendButton.click();
    }

    @Then("{string} error is given")
    public void errorIsGiven(String string) {
        Assert.assertEquals(string, messageFunctionPage.recipientAbcentErrorMessage.getText());
    }

    @When("user verify {string} is selected as recipient by default")
    public void userVerifyAllEmployeesIsSelectedAsRecipientByDefault() {
        Assert.assertTrue(messageFunctionPage.allEmployeesAsDefault.isEnabled());

    }

    @And("verify user can change the default recipient.")
    public void verifyUserCanChangeTheDefaultRecipient() {

        messageFunctionPage.allEmployeesAsDefault.click();
        Assert.assertFalse(messageFunctionPage.allEmployeesAsDefault.isDisplayed());
        messageFunctionPage.addMore.click();
        messageFunctionPage.addPeople.click();
        messageFunctionPage.addRecentSign.click();
        for (WebElement recentRecipient : messageFunctionPage.addFromRecent) {
            Assert.assertTrue(recentRecipient.isEnabled());
            recentRecipient.click();
            break;
        }
        //verify that new recipient is added


    }

    @And("user clicks add more")
    public void userClicksAddMore() {
        messageFunctionPage.addMore.click();
    }


    @And("user selects from Recent")
    public void userSelectsFromRecent() {
        messageFunctionPage.addRecentSign.click();
        for (WebElement recentRecipient : messageFunctionPage.addFromRecent) {
            recentRecipient.click();
            break;
        }


    }

    @And("user selects from My groups")
    public void userSelectsFromMyGroups() {
        messageFunctionPage.addMyGroupsSign.click();
        messageFunctionPage.addFromMyGroups.click();

    }

    @Then("user selects from Employees and departments")
    public void userSelectsFromEmployeesAndDepartments() {
        messageFunctionPage.addEmployeesAndDepartmentsSign.click();
        for (WebElement employeesAndDepartmentRecipient : messageFunctionPage.addFromEmployeesAndDepartments) {
            employeesAndDepartmentRecipient.click();
            break;
        }


    }

    @Then("user can delete a recipient by clicking the cross sign at the selected recipient")
    public void user_can_delete_a_recipient_by_clicking_the_cross_sign_at_the_selected_recipient() {
        for (WebElement deleteCrosssign : messageFunctionPage.deleteRecipient) {
            deleteCrosssign.click();
            break;
        }
    }

    @When("user specifies a message title")
    public void user_specifies_a_message_title() {
        Driver.getDriver().switchTo().frame(messageFunctionPage.iframe);
        messageFunctionPage.messageBody.sendKeys("Message Title Here");
        Driver.getDriver().switchTo().parentFrame();
    }

    @Then("user closes recipient select window")
    public void userClosesRecipientSelectWindow() {
        messageFunctionPage.recipientSelectCloseIcon.click();
    }

    @When("user cancel sending messages at any time before sending by clicking cancel button")
    public void user_cancel_sending_messages_at_any_time_before_sending_by_clicking_cancel_button() {
        Assert.assertTrue(messageFunctionPage.cancelMessageButton.isEnabled());
        messageFunctionPage.cancelMessageButton.click();
        Assert.assertTrue(!(messageFunctionPage.cancelMessageButton.isEnabled()));

    }


    @Then("verify the message box is fresh without any previous notes")
    public void verifyTheMessageBoxIsFreshWithoutAnyPreviousNotes() {
        Driver.getDriver().switchTo().frame(messageFunctionPage.iframe);
        Assert.assertTrue(messageFunctionPage.messageBody.getText().isEmpty());

    }
}
