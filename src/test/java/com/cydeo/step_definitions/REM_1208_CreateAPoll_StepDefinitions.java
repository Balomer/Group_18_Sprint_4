package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.PollPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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

    }

    @When("user click add more link and Employees and Department's tab on the pop-up")
    public void user_click_add_more_link_and_employees_and_department_s_tab_on_the_pop_up() {
        pollPage.addMoreLink.click();
        pollPage.employeesDepartmentsTab.click();

    }



    @And("user select multiple contacts")
    public void userSelectMultipleContacts(List<String> employeeNames) {
        for (WebElement employee : pollPage.employees) {
            for (String each : employeeNames) {
                if (employee.getText().equalsIgnoreCase(each)) {
                    employee.click();
                }
            }
        }
    }

    @Then("user displayed selected contacts in the To section")
    public void userDisplayedSelectedContactsInTheToSection(List<String> employeeNames) {

       List<String> addedEmployees = new ArrayList<>();

        for (WebElement each : pollPage.destinationContainer) {
            addedEmployees.add(each.getText());
        }

        Assert.assertTrue(addedEmployees.containsAll(employeeNames));

    }

    @And("user click Add question button {int} times")
    public void userClickAddQuestionButtonTimes(int countOfQuestions) {

        if (countOfQuestions >= 0) {
            for (int i = 0; i <= countOfQuestions; i++) {
                pollPage.addQuestionButton.click();
            }

        }
    }

    @Then("user displayed {int} added question")
    public void userDisplayedAddedQuestion(int addedQuestions) {

        if (addedQuestions >= 0) {
            Assert.assertEquals(pollPage.questions.size(),addedQuestions + 1);

        }
    }
}
