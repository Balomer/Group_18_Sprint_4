package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMLY_MessageFunctionPage {
    public CRMLY_MessageFunctionPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='Message']")
    public WebElement messageTab;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;


}