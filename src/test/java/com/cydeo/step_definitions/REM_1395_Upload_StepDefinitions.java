package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.UploadPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

public class REM_1395_Upload_StepDefinitions {

    UploadPage page=new UploadPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    Actions actions=new Actions(Driver.getDriver());

   public String filePath1;
   public String filePath2;
   public String filePath3;
   public String newName;

        @Given("User is on the homepage")
        public void userShouldBeOnTheHomepage() {
            LoginPage.login(ConfigurationReader.getProperty("loginUsername"));
        }


    @When("User clicks message tab on the quick navigation menu")
    public void userClicksMessageTabOnTheQuickNavigationMenu() {
            page.messageTab.click();
    }

    @And("User clicks on the upload files image")
    public void userClicksOnTheUploadFilesImage() {
           page.uploadSign.click();
    }

    @And("User uploads three same format files with clicking the upload files and images box")
    public void userUploadsThreeSameFormatFilesWithClickingTheUploadFilesAndImagesBox() {

       filePath1=System.getProperty("user.dir")+"/src/test/resources/testData/test1.pdf";
       filePath2=System.getProperty("user.dir")+"/src/test/resources/testData/test2.pdf";
       filePath3=System.getProperty("user.dir")+"/src/test/resources/testData/test3.pdf";
        page.uploadFilesAndImagesBox.sendKeys(filePath1+"\n"+filePath2+"\n"+filePath3);
        wait.until(ExpectedConditions.visibilityOf(page.afterLoading));
        }

    @And("User clicks send button")
    public void userClicksSendButton() {
        page.sendButton.click();
        BrowserUtils.sleep(1);
    }

    @Then("User should see the uploaded files as attachments under the related message")
    public void userShouldSeeTheUploadedFilesAsAttachmentsUnderTheRelatedMessage() {
            //wait.until(ExpectedConditions.visibilityOf(page.file(filePath1)));
            BrowserUtils.sleep(1);
            assertTrue(page.file(filePath1).isDisplayed());
            assertTrue(page.file(filePath2).isDisplayed());
            assertTrue(page.file(filePath3).isDisplayed());

    }

    @And("User uploads multiple different format files one by one with clicking the upload files and images box")
    public void userUploadsMultipleDifferentFormatFilesOneByOneWithClickingTheUploadFilesAndImagesBox() {
        filePath1=System.getProperty("user.dir")+"/src/test/resources/testData/test1.pdf";
        filePath2=System.getProperty("user.dir")+"/src/test/resources/testData/testData.txt";
        filePath3=System.getProperty("user.dir")+"/src/test/resources/testData/test2.docx";
        page.uploadFilesAndImagesBox.sendKeys(filePath1);
        BrowserUtils.sleep(1);
        //wait.until(ExpectedConditions.visibilityOf(page.insertButton1));
        page.uploadFilesAndImagesBox.sendKeys(filePath2);
        BrowserUtils.sleep(1);
        //wait.until(ExpectedConditions.visibilityOf(page.insertButton2));
        page.uploadFilesAndImagesBox.sendKeys(filePath3);
        BrowserUtils.sleep(1);
        //wait.until(ExpectedConditions.visibilityOf(page.insertButton3));

    }

    @And("User uploads image with clicking the upload files and images box")
    public void userUploadsImageWithClickingTheUploadFilesAndImagesBox() {
        filePath1=System.getProperty("user.dir")+"/src/test/resources/testData/test.png";
        page.uploadFilesAndImagesBox.sendKeys(filePath1);
        BrowserUtils.sleep(3);
    }

    @Then("User should see the uploaded image itself in the related message")
    public void userShouldSeeTheUploadedImageItselfInTheRelatedMessage() {
        BrowserUtils.sleep(1);
        assertTrue(page.img(filePath1).isDisplayed());
    }

    @And("User uploads file and image with clicking the upload files and images box")
    public void userUploadsFileAndImageWithClickingTheUploadFilesAndImagesBox() {
        filePath1=System.getProperty("user.dir")+"/src/test/resources/testData/test1.pdf";
        filePath2=System.getProperty("user.dir")+"/src/test/resources/testData/test.gif";
        page.uploadFilesAndImagesBox.sendKeys(filePath1+"\n"+filePath2);
        wait.until(ExpectedConditions.visibilityOf(page.afterLoading));
    }

    @And("User clicks insert in text button")
    public void userClicksInsertInTextButton() {
        for (WebElement insertButton : page.insertButtons) {
            insertButton.click();
        }
    }

    @Then("User should see the inserted file and image in the text of related message")
    public void userShouldSeeTheInsertedFileAndImageInTheTextOfRelatedMessage() {
        BrowserUtils.sleep(3);
        assertTrue(page.fileInMessage.getText().contains(filePath1.substring(filePath1.lastIndexOf("/")+1,filePath1.lastIndexOf("."))));
        assertTrue(page.img(filePath2).isDisplayed());
    }

    @And("User uploads file with clicking the upload files and images box")
    public void userUploadsFileWithClickingTheUploadFilesAndImagesBox() {
        filePath1=System.getProperty("user.dir")+"/src/test/resources/testData/test2.docx";
        page.uploadFilesAndImagesBox.sendKeys(filePath1);
        wait.until(ExpectedConditions.visibilityOf(page.afterLoading));
    }

    @And("User logouts")
    public void userLogouts() {
        page.userMenu.click();
        page.logoutButton.click();

    }

    @And("User re-logins with different credentials")
    public void userReLoginsWithDifferentCredentials() {
        LoginPage.login(ConfigurationReader.getProperty("loginUsername1"));

    }

    @Then("User should see the edit hypertext in the related message")
    public void userShouldSeeTheEditHypertextInTheRelatedMessage() {
            assertTrue(page.editButton(filePath1).isDisplayed());
    }


    @And("User unchecks the Allow a recipient to edit documents?")
    public void userUnchecksTheAllowARecipientToEditDocuments() {
            page.allowRecipientEditCheckbox.click();
    }

    @Then("User should not see the edit hypertext in the related message")
    public void userShouldNotSeeTheEditHypertextInTheRelatedMessage() {
        page.moreButton.click();
        assertEquals(4,page.menuPopupItems.size());
    }

    @And("User removes file and image by clicking cancel sign")
    public void userRemovesFileAndImageByClickingCancelSign() {
        for (WebElement delButton : page.delButtons) {
            delButton.click();
        }
    }

    @Then("User should not see file and image as attachments")
    public void userShouldNotSeeFileAndImageAsAttachments() {
        page.sendButton.click();
        BrowserUtils.sleep(1);
        assertTrue(page.errorPopup.isDisplayed());
    }

    @And("User clicks pen sign when hovering over the uploaded file")
    public void userClicksPenSignWhenHoveringOverTheUploadedFile() {
            actions.moveToElement(page.fileNameToHover(filePath1)).click(page.editPen).perform();
        }

    @And("User renames the uploaded file")
    public void userRenamesTheUploadedFile() {
        Faker faker=new Faker();
        newName=faker.funnyName().name();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        actions.sendKeys(newName+Keys.ENTER).perform();
    }

    @Then("User should see new name of the uploaded file in the related message")
    public void userShouldSeeNewNameOfTheUploadedFileInTheRelatedMessage() {
            String actualResult=page.newName(newName).getText();
            assertEquals(newName,actualResult.substring(0,actualResult.lastIndexOf(".")));
    }


}
