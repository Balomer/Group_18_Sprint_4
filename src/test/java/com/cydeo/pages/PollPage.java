package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PollPage {

    public PollPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[.=\"Poll\"]")
    public WebElement pollTab;

    @FindBy(xpath = "//a[.='Add more']")
    public WebElement addMoreLink;

    @FindBy(xpath = "//a[.='Employees and departments']")
    public WebElement employeesDepartmentsTab;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-employee-name']")
    public List<WebElement> employees;

    @FindBy(xpath = "//span[@class = 'feed-add-post-destination-text']")
    public List<WebElement> destinationContainer;

    @FindBy(xpath = "//a[.='Add question']")
    public WebElement addQuestionButton;

    @FindBy(xpath = "//input[@placeholder='Question ']")
    public List<WebElement> questions;

    @FindBy(xpath = "//input[@class='vote-block-inp adda']")
    public List<WebElement> answers;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement deleteAllEmployeesButton;

    @FindBy (xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy (xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy (xpath = "//body[@contenteditable='true']")
    public WebElement messageBox;

    @FindBy (xpath = " //span[@class='popup-window-close-icon']")
    public WebElement empPopUpCloseButton;

    @FindBy (xpath ="//span[@class=\"bx-vote-block-inp-substitute\"]")
    public List<WebElement> selectableChoice;

    @FindBy (xpath = "//input[@id=\"multi_0\"]")
    public WebElement allowMultiChoice;

    @FindBy (xpath = "//span[@class=\"feed-add-info-text\"]")
    public WebElement messageTitleErrorMessage;

    @FindBy (xpath = "(//div[@class='feed-post-text-block'])[1]")
    public WebElement lastPost;

    @FindBy (xpath = "(//a[@class='feed-post-user-name'])[1]")
    public WebElement lastPostUserName;

}
