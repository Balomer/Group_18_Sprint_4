package com.cydeo.utilities;

import com.cydeo.pages.PollPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PollUtils {

    static PollPage pollPage = new PollPage();

    public static void addAnswer(int answerCount, int questionNumber) {

        List<WebElement> answers = Driver.getDriver().findElements(By.xpath("((//ol[@class='vote-answers'])[" + questionNumber +"]//input[@class='vote-block-inp adda'])"));
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("(//ol[@class='vote-answers'])//input[@class='vote-block-inp adda']"));



        int answersNumber = answers.size();

        if (answerCount >= 0 && questionNumber>0 && questionNumber<= pollPage.questions.size()) {
            for (int i = 0; i <= answerCount; i++) {
                Driver.getDriver().findElement(By.xpath("(((//ol[@class='vote-answers'])[" + questionNumber +"]//input[@class='vote-block-inp adda']))[" + answersNumber + "]")).click();

                answersNumber++;
            }
        }

    }

    public static int numberOfAnswerUnderQuestion(int questionNumber){

        return Driver.getDriver().findElements(By.xpath("((//ol[@class='vote-answers'])[" + questionNumber +"]//input[@class='vote-block-inp adda'])")).size();
    }

    public static void deleteSelectedQuestion(int questionNumber){

        Actions actions = new Actions(Driver.getDriver());


        List<WebElement> questionsXMarks = Driver.getDriver().findElements(By.xpath("//label[@title='Delete question']"));

        List<WebElement> questions = Driver.getDriver().findElements(By.xpath("//div[@class=\"vote-block-title-wrap\"]"));

        if(questionNumber <= questions.size()){


            actions.moveToElement(questions.get(questionNumber)).perform();

            questionsXMarks.get(questionNumber).click();

        }

    }

    public static void deleteAnswerUnderQuestion(int answerNumber, int questionNumber){

        Actions actions = new Actions(Driver.getDriver());
        List<WebElement> answersXMarks = Driver.getDriver().findElements(By.xpath("((//ol[@class='vote-answers'])[" + questionNumber + "]//label[@title='Delete answer'])"));

        List<WebElement> answer = Driver.getDriver().findElements(By.xpath("((//ol[@class='vote-answers'])[" + questionNumber + "]//li[@class=\"vote-block-inp-wrap\"])"));


        if(answerNumber<= answer.size() && questionNumber<= pollPage.questions.size()){
            actions.moveToElement(answer.get(answerNumber)).perform();

            answersXMarks.get(answerNumber).click();

        }

    }


    public static void addQuestions(int countOfQuestions){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        if (countOfQuestions >= 0) {
            for (int i = 0; i < countOfQuestions; i++) {
                pollPage.addQuestionButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pollPage.addQuestionButton));
                BrowserUtils.waitFor(2);
            }
        }
    }

    public static void selectEmployees(List<String> employeeNames){

        for (WebElement employee : pollPage.employees) {
            for (String each : employeeNames) {
                if (employee.getText().equalsIgnoreCase(each)) {
                    employee.click();
                }
            }
        }
       pollPage.empPopUpCloseButton.click();
    }
}
