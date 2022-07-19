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

    @FindBy (xpath ="//a[.='Add question']")
    public WebElement addQuestionButton;

    @FindBy (xpath = "//input[@placeholder='Question ']")
    public List<WebElement> questions;

}
