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

   // @FindBy(xpath = "//div[@class='main-ui-control main-ui-select']")
    @FindBy(xpath = "//div[@class='main-ui-control main-ui-select']")
    public WebElement dateBox;

    @FindBy(xpath = "(//span[@title='Hide field'])[4]")
    public WebElement dateBoxDeleteIcon;

   // @FindBy(xpath = "//span[.='Yesterday']")
   // @FindBy(xpath = "//div[@data-value='{\"NAME\":\"Yesterday\",\"VALUE\":\"YESTERDAY\"}']")
    // public WebElement dateYesterday;

    @FindBy(xpath = "//button[contains (text(), 'Search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='main-ui-filter-add-container']")
    public WebElement saveFilterModule;

    @FindBy(xpath = "//input[@class='main-ui-filter-sidebar-edit-control']")
    public WebElement filterNameInputBox;

    @FindBy(xpath = "//span[@class='ui-btn ui-btn-success main-ui-filter-field-button main-ui-filter-save']")
    public WebElement saveButton;

    @FindBy(xpath = "(//div[@data-name='EVENT_ID'])[2]")
    public WebElement typeInputBox;

    @FindBy(xpath = "(//span[@class='main-ui-delete main-ui-filter-field-delete main-ui-item-icon'])[1]")
    public WebElement fieldDeleteIcon;

    @FindBy(xpath = "//span[.='Restore default fields']")
    public WebElement restoreToDefaultFields;

    @FindBy(xpath = "(//input[@class='main-ui-control main-ui-control-string main-ui-square-search-item'])[1]")
    public WebElement authorInputBox;

    @FindBy(xpath = "(//input[@class='main-ui-control main-ui-control-string main-ui-square-search-item'])[2]")
    public WebElement toInputBox;

    @FindBy(xpath = "//span[@class='ui-btn ui-btn-light-border main-ui-filter-field-button main-ui-filter-reset']")
    public WebElement resetButton;

    @FindBy(xpath = "(//span[@class='main-ui-item-icon main-ui-delete'])[1]")
    public WebElement filterSearchDeleteIcon;



}
