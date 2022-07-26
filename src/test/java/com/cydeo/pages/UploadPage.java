package com.cydeo.pages;

import com.cydeo.step_definitions.REM_1395_Upload_StepDefinitions;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// https://qa.crmly.net/stream/?login=yes
public class UploadPage extends BasePage {

    @FindBy(css = "#feed-add-post-form-tab-message span")
    public WebElement messageTab;

    @FindBy(css = "#bx-b-uploadfile-blogPostForm")
    public WebElement uploadSign;

    @FindBy (xpath = "//input[@class='diskuf-fileUploader wd-test-file-light-inp ']")
    public WebElement uploadFilesAndImagesBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;


    @FindBy(css = ".feed-add-post-loading")
    public WebElement loadingBar;

    @FindBy(xpath = "//a[.='My Drive / Uploaded files']")
    public WebElement afterLoading;

    @FindBy(xpath = "//span[@class='insert-btn']")
    public List<WebElement> insertButtons;

    @FindBy(xpath = "//span[@class='feed-com-file-inline feed-com-file-name']")
    public WebElement fileInMessage;

    @FindBy(id = "user-block")
    public WebElement userMenu;

    @FindBy(xpath = "(//a[@class='menu-popup-item menu-popup-no-icon '])[3]")
    public WebElement logoutButton;

    @FindBy(css = "#diskuf-edit-rigths-doc")
    public WebElement allowRecipientEditCheckbox;

    @FindBy(xpath = "//span[@class='feed-con-file-changes-link feed-con-file-changes-link-more']")
    public WebElement moreButton;

    @FindBy(xpath = "//div[@class='menu-popup']//a")
    public List<WebElement> menuPopupItems;

    @FindBy(xpath = "//span[@class='del-but']")
    public List<WebElement> delButtons;

    @FindBy(xpath = "//div[@class='feed-add-error']")
    public WebElement errorPopup;

    @FindBy(xpath = "//span[@class='files-name-edit-btn']")
    public WebElement editPen;


    public WebElement file(String path){
        return Driver.getDriver().findElement(By.xpath("//a[contains(@title,'"+path.substring(path.lastIndexOf("/")+1,path.lastIndexOf("."))+"')]"));
    }
    public WebElement newName(String path){
        return Driver.getDriver().findElement(By.xpath("//a[contains(@title,'"+path+"')]"));
    }
    public WebElement fileNameToHover(String path){
        return Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+path.substring(path.lastIndexOf("/")+1,path.lastIndexOf("."))+"')]"));
    }
    public WebElement editButton(String path){
        return Driver.getDriver().findElement(By.xpath("//a[contains(@title,'"+path.substring(path.lastIndexOf("/")+1,path.lastIndexOf("."))+"')]/following-sibling::a"));
    }
    public WebElement img(String path){
        return Driver.getDriver().findElement(By.xpath("//img[contains(@data-bx-title,'"+path.substring(path.lastIndexOf("/")+1,path.lastIndexOf("."))+"')]"));

    }

}