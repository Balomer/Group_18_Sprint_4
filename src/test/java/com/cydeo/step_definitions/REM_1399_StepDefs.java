package com.cydeo.step_definitions;

import com.cydeo.pages.TaskPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import javax.crypto.KeyAgreementSpi;
import java.util.ArrayList;
import java.util.List;

public class REM_1399_StepDefs{
        TaskPage taskPage = new TaskPage();
        Faker faker =new Faker();
        String taskName = faker.bothify("Task Name ###");
        int count = Integer.parseInt(taskPage.countOnMyTasks.getText());

        @When("user click new task")
        public void userClickNewTask() {
               taskPage.topTaskButton.click();
        }

        @And("user enter task name")
        public void userEnter() {
                taskPage.titleInput.sendKeys(taskName);
        }


        @And("user click high priority checkbox")
        public void userClickHighPriorityCheckbox() {
                taskPage.tasksprioritycbInput.click();
        }

        @And("user click add task button")
        public void userClickAddTaskButton() {
                taskPage.addTaskButton.click();
                BrowserUtils.waitFor(2);
        }

        @Then("user should see new task task name and priority image in the task list")
        public void userShouldSeeNewTaskAndPriorityImageInTheTaskList() {
                taskPage.leftSideTaskButton.click();
                BrowserUtils.waitForVisibility(taskPage.taskTitleLink(taskName),10);
                Assert.assertTrue(taskPage.taskTitleHighPriority(taskName).isDisplayed());
        }

            List<String> expectedMails = new ArrayList<>();
        @And("user click add more button and enter mails")
        public void userClickAddMoreButtonAndEnterMails(List<String> mails ) {
                taskPage.addMoreButton.click();
                taskPage.employeesAndDepartmentButton.click();
                for (String mail : mails) {
                       BrowserUtils.waitForClickablility(taskPage.selectedMail(mail),10);
                       taskPage.selectedMail(mail).click();
                }

                expectedMails.addAll(mails);
        }


        @And("user click task name on the task list")
        public void userClickOnTheTaskList() {
                taskPage.leftSideTaskButton.click();
                BrowserUtils.waitForVisibility(taskPage.taskTitleLink(taskName), 10);
                taskPage.taskTitleLink(taskName).click();
        }

        @Then("user should see all responsibles mails in the task")
        public void userShouldSeeAllResponsiblesInTheTask() {
                Driver.getDriver().switchTo().frame(3);
                BrowserUtils.waitForVisibility(taskPage.subtasksList, 10);
                List<String> actualMails = BrowserUtils.getElementsText(taskPage.responsibleEmails);
                Assert.assertEquals(expectedMails, actualMails);
                Assert.assertTrue(taskPage.subtasksList.isDisplayed());
        }

        @When("user looks ongoing count on My Tasks")
        public void userLooksOngoingCountOnMyTasks() {

               int count = Integer.parseInt(taskPage.countOnMyTasks.getText());


        }


        @Then("user should see new count in myTaskTable")
        public void userShouldSeeNewCountInMyTaskTable() {
            BrowserUtils.waitForVisibility(taskPage.countOnMyTasks, 10);
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
        public void userSeeDeadline() {
                Assert.assertNotNull(taskPage.deadlineInputBoxValue.getAttribute("value"));
        }

        @And("click time planning button")
        public void clickTimePlanningButton() {
                taskPage.timePlanningButton.click();
                taskPage.timePlanningButton.click();
                BrowserUtils.waitForVisibility(taskPage.timeStartInput,10);

        }


        @And("user enter start task on and duration as a time")
        public void userEnterStartTaskOnAndDurationAsA() {
                taskPage.timeStartInput.click();
                taskPage.selectButton.click();
                String durationTime = faker.numerify("#");
                taskPage.timeDurationInput2.sendKeys(durationTime);
        }

        @Then("user should see time schedule")
        public void userShouldSeeTimeSchedule() {
           BrowserUtils.waitFor(2);
           Driver.getDriver().switchTo().frame(3);
           BrowserUtils.waitForVisibility(taskPage.deadLineControl,10);
           Assert.assertFalse(taskPage.deadLineControl.getText().contains("None"));
           //Assert.assertTrue(taskPage.deadLineText.isDisplayed());
        }
}


