package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivityStreamPage {

    public ActivityStreamPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@id='LIVEFEED_search']")
    public WebElement filterSearchBox;

    @FindBy(xpath = "//span[@class='main-ui-filter-add-edit']")
    public WebElement editGearField;

    @FindBy(xpath = "//span[@class='main-ui-filter-field-button-item']")
    public WebElement resetToDefaultField;

    @FindBy(xpath = "(//span[@class='popup-window-button'])")
    public WebElement continueAlert;

    @FindBy(xpath = "//div[@class='main-ui-filter-sidebar-item']")
    public List<WebElement> filterModules;

    @FindBy(xpath = "//span[.='Add field']")
    public WebElement addField;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[1]")
    public WebElement dateField;

    @FindBy(xpath = "//div[@class='main-ui-control main-ui-select']")
    public WebElement dateBox;







}
