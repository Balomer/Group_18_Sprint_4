package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CRMLY_MessageFunctionPage {
    public CRMLY_MessageFunctionPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[.='Message']")
    public WebElement messageTab;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath="//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//body[@style='min-height: 184px;']")
    public WebElement messageBody;

    @FindBy(id = "POST_TITLE")
    public WebElement topicBody;

    @FindBy(id = "lhe_button_title_blogPostForm")
    public WebElement openTopicBoxTab;

    @FindBy(xpath = "//span[.='The message text is empty.']")
    public WebElement topicBoxErrorMessage;

    @FindBy(xpath = "//div[starts-with(@id, 'blog_post_body')][.='Message Title Here']")
    public WebElement messageSent;

    @FindBy(id = "bx-destination-tag")
    public WebElement addMore;

   /*
    @FindBy(id = "destEmailTab_destination4682335")
    public WebElement emailUsersFromAddMore; */

   /*
    @FindBy(id = "destEmailTab_destination9153941")
    public WebElement emailUsersFromAddMore;*/



    @FindBy(xpath="//div[.='All employees']")
    public List<WebElement> toChooseFromEmailUsersFromAddMore;

    @FindBy(xpath="//span[.='The message title is not specified']")
    public WebElement titleAbcentErrorMessage;

    @FindBy(xpath="//span[.='Please specify at least one person.']")
    public WebElement recipientAbcentErrorMessage;

    @FindBy(xpath="//span[@class='feed-add-post-destination-text']")
    public WebElement allEmployeesAsDefault;

    @FindBy(xpath="//span[@class='feed-add-post-del-but']")
    public WebElement allEmployeesAsDefaultDeleteButton;

    @FindBy(xpath="//a[contains(text(),'Add persons, groups or department')]")
    public WebElement addPeople;

    @FindBy(xpath = "//a[starts-with(@id,'destLastTab_destination')]")
    public WebElement addRecentSign;

    @FindBy(xpath = "//div[contains(text(),'@cybertekschool.com')] ")
    public List<WebElement> addFromRecent;

    @FindBy(xpath = "//a[starts-with(@id,'destGroupTab_destination')]")
    public WebElement addMyGroupsSign;

    @FindBy(xpath = "//div[@class='bx-finder-box-item-t7-name']")
    public WebElement addFromMyGroups;

    @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_destination')]")
    public WebElement addEmployeesAndDepartmentsSign;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-text']")
    public List<WebElement> addFromEmployeesAndDepartments;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public List<WebElement> deleteRecipient;

    @FindBy(xpath= "//span[@class='popup-window-close-icon']")
    public WebElement recipientSelectCloseIcon;

    @FindBy(id= "blog-submit-button-cancel")
    public WebElement cancelMessageButton;


}
