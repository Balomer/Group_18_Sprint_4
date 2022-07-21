package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TaskPage extends BasePage{
    

    @FindBy(xpath = "//*[@id='feed-add-post-form-tab-tasks']//span")
    public WebElement topTaskButton;

    @FindBy(name = "ACTION[0][ARGUMENTS][data][TITLE]")
    public WebElement titleInput;

    @FindBy(id = "tasks-task-priority-cb")
    public WebElement tasksprioritycbInput;

    @FindBy(id = "blog-submit-button-save")
    public WebElement addTaskButton;

    @FindBy(xpath = "//span[normalize-space(text()) = 'Tasks']")
    public WebElement leftSideTaskButton;

    @FindBy(xpath = "//div[@class='sidebar-widget-top'][.//a[@class='plus-icon']]//div")
    public WebElement myTasksButton;

    @FindBy(xpath = "//*[@id='bx-component-scope-lifefeed_task_form-responsible']//a[normalize-space(text()) = 'Add more']")
    public WebElement addMoreButton;

    @FindBy(xpath = "//input[contains(@id,'name-selector-')]")
    public WebElement addMoreMailInput;

    @FindBy(xpath = "//a[@class='task-responsible-link']")
    public List<WebElement> responsibleEmails;

    @FindBy(xpath = "//span[@class='task-item-index']")
    public WebElement countOnMyTasks;

    @FindBy(xpath = " //span[.='Checklist']")
    public WebElement checkListButton;

    @FindBy(xpath = "//input[@class='js-id-checklist-is-form-title task-checklist-field-add']")
    public WebElement checkListInput;

    @FindBy(xpath = " //span[@class='js-id-checklist-is-i-title ']")
    public WebElement checkListControl;

    @FindBy(xpath = "//input[@data-bx-id='datepicker-value']")
    public WebElement deadlineInputBoxValue;

    @FindBy(xpath = "//input[@data-bx-id='datepicker-display']")
    public WebElement deadlineInputBox;
    
    



    @FindBy(xpath = " //span[.='Select']")
    public WebElement selectButton;

    @FindBy(xpath = "//span[.='Time planning']")
    public WebElement timePlanningButton;

    @FindBy(xpath = "//span[contains(@data-bx-id, 'start')]//input[@class='task-options-inp']")
    public WebElement timeStartInput;

    @FindBy(xpath = "//input[@data-bx-id='dateplanmanager-duration']")
    public WebElement timeDurationInput2;

    @FindBy(xpath = "//span[@id='task-detail-deadline']")
    public WebElement deadLineControl;

    @FindBy(xpath = "//div[@class='task-iframe-sidebar']//div[.='Deadline:']")
    public WebElement deadLineText;


    @FindBy(xpath = "//a[.='Employees and departments']")
    public WebElement employeesAndDepartmentButton;

    @FindBy(xpath = "//div[.='Subtasks']")
    public WebElement subtasksList;





    public WebElement taskTitleLink(String taskName){
       return Driver.getDriver().findElement(By.xpath("//tbody//td[3]//a[.='"+taskName+"']"));}

    public WebElement taskTitleHighPriority(String taskName){
        return Driver.getDriver().findElement(By.xpath("//tbody//td[3]//a[.='"+taskName+"']/..//span[@class='task-priority-high']"));}

    public WebElement selectedMail(String mail){
        return Driver.getDriver().findElement(By.xpath("//a//div[.='"+mail+"']"));}







    

       
}
