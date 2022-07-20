package com.cydeo.step_definitions;

import com.cydeo.pages.TaskPage;
import com.cydeo.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import javax.crypto.KeyAgreementSpi;
import java.util.List;

public class REM_1399_StepDefs{
        TaskPage taskPage = new TaskPage();
        Faker faker =new Faker();
        int count = Integer.parseInt(taskPage.countOnMyTasks.getText());

        @When("user click new task")
        public void userClickNewTask() {
               taskPage.topTaskButton.click();
        }

        @And("user enter {string}")
        public void userEnter(String taskName) {
                taskPage.titleInput.sendKeys(taskName);
        }


        @And("user click high priority checkbox")
        public void userClickHighPriorityCheckbox() {
                taskPage.tasksprioritycbInput.click();
        }

        @And("user click add task button")
        public void userClickAddTaskButton() {
                taskPage.addTaskButton.click();
        }

        @Then("user should see new task {string} and priority image in the task list")
        public void userShouldSeeNewTaskAndPriorityImageInTheTaskList(String taskName) {
                taskPage.leftSideTaskButton.click();
                BrowserUtils.waitForVisibility(taskPage.taskTitleLink(taskName),10);
                Assert.assertTrue(taskPage.taskTitleHighPriority(taskName).isDisplayed());
        }

        @And("user click add more button and enter mails")
        public void userClickAddMoreButtonAndEnterMails(List<String> mails ) {
                taskPage.addMoreButton.click();
                for (String mail : mails) {
                        BrowserUtils.waitForVisibility(taskPage.addMoreMailInput, 10);
                        taskPage.addMoreMailInput.sendKeys(mail+ Keys.ENTER);
                }

        }


        @And("user click {string} on the task list")
        public void userClickOnTheTaskList(String taskName) {
                BrowserUtils.waitForVisibility(taskPage.taskTitleLink(taskName), 10);
                taskPage.taskTitleLink(taskName).click();
        }

        @Then("user should see all responsibles mails in the task")
        public void userShouldSeeAllResponsiblesInTheTask(List<String> expectedMails) {

                List<String> actualMails = BrowserUtils.getElementsText(taskPage.responsibleEmails);
                Assert.assertEquals(expectedMails,actualMails);
        }

        @When("user looks ongoing count on My Tasks")
        public void userLooksOngoingCountOnMyTasks() {

               int count = Integer.parseInt(taskPage.countOnMyTasks.getText());


        }


        @Then("user should see new count in myTaskTable")
        public void userShouldSeeNewCountInMyTaskTable() {
            BrowserUtils.waitFor(2);
            Assert.assertEquals(Integer.parseInt(taskPage.countOnMyTasks.getText()), (count+1));
        }

        @And("click and add {string}")
        public void clickAndAdd(String checklistTask) {
            taskPage.checkListButton.click();
            taskPage.checkListInput.sendKeys(checklistTask+Keys.ENTER);
        }

        @Then("user should see {string}")
        public void userShouldSee(String checklistTask) {
            Assert.assertTrue(taskPage.checkListControl.getText().contains(checklistTask));
        }

        @And("click time deadline inputbox")
        public void clickTimeInputbox() {
                taskPage.deadlineInputBox.click();
                taskPage.selectButton.click();
        }

        @And("user should see deadline")
        public void userEnterStartTaskOnAndDurationAsA() {
                Assert.assertNotNull(taskPage.deadlineInputBoxValue.getAttribute("value"));
        }

        @And("click time planning button")
        public void clickTimePlanningButton() {
        }


        @And("user enter start task on and duration as a {string}")
        public void userEnterStartTaskOnAndDurationAsA(String arg0) {
        }
}


