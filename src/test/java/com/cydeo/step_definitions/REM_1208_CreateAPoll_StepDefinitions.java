package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.PollPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.PollUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class REM_1208_CreateAPoll_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    PollPage pollPage = new PollPage();


    @Given("user can login the page")
    public void user_can_login_the_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        loginPage.username.sendKeys(ConfigurationReader.getProperty("loginUsername"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("loginPassword"));
        loginPage.login.click();

    }

    @When("user click poll tab")
    public void user_click_poll_tab() {
        pollPage.pollTab.click();

        BrowserUtils.waitFor(2);

    }

    @When("user click add more link and Employees and Department's tab on the pop-up")
    public void user_click_add_more_link_and_employees_and_department_s_tab_on_the_pop_up() {
        pollPage.addMoreLink.click();
        pollPage.employeesDepartmentsTab.click();

    }


    List<String> arr = new ArrayList<>();

    @And("user select multiple contacts")
    public void userSelectMultipleContacts(List<String> employeeNames) {
        arr = employeeNames;
        pollPage.deleteAllEmployeesButton.click();
        PollUtils.selectEmployees(arr);
    }

    @Then("user displayed selected contacts in the To section")
    public void userDisplayedSelectedContactsInTheToSection() {

        List<String> addedEmployees = new ArrayList<>();

        for (WebElement each : pollPage.destinationContainer) {
            addedEmployees.add(each.getText());
        }

        Assert.assertTrue(addedEmployees.containsAll(arr));

    }

    int k = 0;

    @And("user click Add question button {int} times")
    public void userClickAddQuestionButtonTimes(int countOfQuestions) {

        PollUtils.addQuestions(countOfQuestions);

        k = countOfQuestions;


    }


    @Then("user displayed added question")
    public void userDisplayedAddedQuestion() {

        if (k >= 0) {
            Assert.assertEquals(pollPage.questions.size(), k + 1);

        }
    }


    int actualAnswersCount;
    int qN;

    @And("user click last answer {int} times under the {int} question")
    public void userClickLastAnswerTimesUnderTheQuestion(int answersNum, int questionNumber) {

        actualAnswersCount = PollUtils.numberOfAnswerUnderQuestion(questionNumber) + answersNum;


        PollUtils.addAnswer(answersNum, questionNumber);

        qN = questionNumber;

    }

    @Then("user displayed added answer")
    public void userDisplayedAddedAnswer() {

        Assert.assertEquals(PollUtils.numberOfAnswerUnderQuestion(qN), actualAnswersCount + 1);

    }


    int lastQuestionNumber;

    @And("user click x mark near the {int} question")
    public void userClickXMarkNearTheQuestion(int questionNumber) {

        PollUtils.addQuestions(3);
        PollUtils.addAnswer(2, 2);

        lastQuestionNumber = pollPage.questions.size();


        PollUtils.deleteSelectedQuestion(questionNumber);


    }

    @Then("user can not displayed selected question")
    public void userCanNotDisplayedSelectedQuestion() {

        Assert.assertEquals(pollPage.questions.size(), lastQuestionNumber - 1);

    }

    int lastNumberOfAnswer;
    int selectedQuestion;

    @And("user click x mark near the {int} answer under {int} question")
    public void userClickXMarkNearTheAnswerUnderQuestion(int answerNumber, int questionNumber) {

        lastNumberOfAnswer = PollUtils.numberOfAnswerUnderQuestion(questionNumber);

        PollUtils.deleteAnswerUnderQuestion(answerNumber, questionNumber);

        selectedQuestion = questionNumber;

    }

    @Then("user can not displayed selected answer")
    public void userCanNotDisplayedSelectedAnswer() {
        Assert.assertEquals(PollUtils.numberOfAnswerUnderQuestion(selectedQuestion), lastNumberOfAnswer - 1);

    }


    @And("user enter texts {string} into text box, {string} into question box, {string} into answer one box, {string} into answer two box")
    public void userEnterTextsIntoTextBoxIntoQuestionBoxIntoAnswerBoxIntoAnswerBox(String message, String question, String ans1, String ans2) {


        Driver.getDriver().switchTo().frame(pollPage.iframe);
        pollPage.messageBox.sendKeys(message);

        Driver.getDriver().switchTo().parentFrame();

        pollPage.questions.get(0).sendKeys(question);
        pollPage.answers.get(0).sendKeys(ans1);
        pollPage.answers.get(1).sendKeys(ans2);


    }

    @And("user click Allow multiple choice checkbox")
    public void userClickAllowMultipleChoiceCheckbox() {
        pollPage.allowMultiChoice.click();

        pollPage.sendButton.click();

        BrowserUtils.waitFor(3);

    }

    @Then("attendee user can choice multiple options")
    public void attendeeUserCanChoiceMultipleOptions() {

        boolean actualResult = false;

        for (WebElement choice : pollPage.selectableChoice) {
            if (choice.isEnabled()) {
                actualResult = true;
            } else {
                actualResult = false;
                break;
            }
        }

        Assert.assertTrue(actualResult);

    }


    @And("user click Send button")
    public void userClickSendButton() {
        pollPage.sendButton.click();

    }

    @Then("user displayed {string} error message on the page")
    public void userDisplayedErrorMessageOnThePage(String errorMessage) {

        Assert.assertTrue(pollPage.messageTitleErrorMessage.isDisplayed());

        String actualMessage = pollPage.messageTitleErrorMessage.getText();

        Assert.assertEquals(errorMessage, actualMessage);
    }

    @And("user delete recipients")
    public void userDeleteRecipients() {
        pollPage.deleteAllEmployeesButton.click();
    }

   String postText;
    @And("user enter texts {string} into text box and delete questions")
    public void userEnterTextsIntoTextBoxAndDeleteQuestions(String message) {
        Driver.getDriver().switchTo().frame(pollPage.iframe);
        pollPage.messageBox.sendKeys(message);

        Driver.getDriver().switchTo().parentFrame();

        PollUtils.deleteSelectedQuestion(1);
        postText=message;

    }

    @Then("user displayed error message and can not send poll as only a text")
    public void userDisplayedErrorMessageAndCanNotSendPollAsOnlyAText() {

        if (pollPage.lastPostUserName.getText().equals(ConfigurationReader.getProperty("loginUsername"))) {
            Assert.assertEquals(pollPage.lastPost.getText(),postText);
        }

    }
}
