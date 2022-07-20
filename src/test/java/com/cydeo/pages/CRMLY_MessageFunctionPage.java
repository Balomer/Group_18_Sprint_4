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

    @FindBy(xpath = "//body[@style='min-height: 117px;']")
    public WebElement messageBody;

    @FindBy(id = "feed-add-post-destination-input")
    public WebElement addMore;

    @FindBy(id = "destEmailTab_destination4682335")
    public WebElement emailUsersFromAddMore;

    @FindBy(xpath="//div[.='All employees']")
    public List<WebElement> toChooseFromEmailUsersFromAddMore;



}
