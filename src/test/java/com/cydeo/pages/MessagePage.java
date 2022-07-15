package com.cydeo.pages;

import com.cydeo.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {

    public MessagePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy (id = "feed-add-post-form-tab-message")
    public WebElement messageButton;

    @FindBy(id = "bx-b-mention-blogPostForm")
    public WebElement addMentionButton;

    @FindBy(xpath = "(//div[@class='bx-finder-box-item-t7-name'])[2]")
    public WebElement empDepModule;

    @FindBy (xpath = "//div[.='helpdesk1@cybertekschool.com']")
    public WebElement selectedUser;

    @FindBy (xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy (xpath = "(//div[@class='feed-item-wrap'])[1]")
    public WebElement verifyMessageForAddMention;


}
