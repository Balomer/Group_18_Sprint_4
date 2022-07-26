package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.REM_1303_InteractPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;
import java.util.Set;

public class REM_1303_Interact_StepDefinitions {


    REM_1303_InteractPage interact = new REM_1303_InteractPage();



    //FIRST SCENARIO
    @When("After clicking comment button, user write a {string} and click send button")
    public void afterClickingCommentButtonUserWriteAAndClickSendButton(String string) {
        interact.commentButton.click();
        Driver.getDriver().switchTo().frame(interact.commentIFrame);
        interact.commentBox.sendKeys(string);
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);
        interact.commentSendButton.click();
        BrowserUtils.sleep(2);
    }
    @Then("User should see own comment on the post")
    public void userShouldSeeOwnCommentOnThePost() {
        Assert.assertTrue(interact.writtenComment.isDisplayed());
    }

    @When("User click like button")
    public void userClickLikeButton() {
        interact.likeButton.click();
    }
    @Then("User should see like sign on the post")
    public void userShouldSeeLikeSignOnThePost() {
        Assert.assertTrue(interact.iconLike.isDisplayed());
    }

    @When("User click unfollow button")
    public void userClickUnfollowButton() {
        interact.unfollowButton.click();
    }
    @Then("User should unfollow the post.")
    public void userShouldUnfollowThePost() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(interact.followText.isDisplayed());
    }




    //SECOND SCENARIO
    @When("User click comment like button")
    public void userClickCommentLikeButton() {
        interact.commentLikeButton.click();
    }
    @Then("User should be able to see like icon on the comment.")
    public void userShouldBeAbleToSeeLikeIconOnTheComment() {
        Assert.assertTrue(interact.commentLikeIcon.isDisplayed());
    }
    @When("User click comment reply button")
    public void userClickCommentReplyButton() {
        interact.commentReplyButton.click();
    }
    @And("User writes {string} and click send button")
    public void userWritesAndClickSendButton(String string) {
        Driver.getDriver().switchTo().frame(interact.commentIFrame);
        interact.commentBox.sendKeys(string);
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);
        interact.commentSendButton.click();
    }
    @Then("User should be able to make comments other reviewers' comments.")
    public void userShouldBeAbleToMakeCommentsOtherReviewersComments() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(interact.writtenCommentReply.isDisplayed());
    }



    //THIRD SCENARIO
    @When("User click own comment's like button")
    public void userClickOwnCommentSLikeButton() {
        interact.ownCommentLikeButton.click();
    }
    @Then("User should be able to see like icon on own the comment.")
    public void userShouldBeAbleToSeeLikeIconOnOwnTheComment() {
        Assert.assertTrue(interact.ownCommentLikeIcon.isDisplayed());
    }
    @When("User click own comment reply button")
    public void userClickOwnCommentReplyButton() {
        interact.ownCommentReplyButton.click();
    }
    @Then("User should be able to make comments his own comments.")
    public void userShouldBeAbleToMakeCommentsHisOwnComments() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(interact.ownCommentReplyMessage.isDisplayed());
    }



    //FOURTH SCENARIO
    @When("User click more button under the his own comment.")
    public void userClickMoreButtonUnderTheHisOwnComment() {
        interact.moreButtonUnderTheComment.click();
    }
    @And("User click view comment.")
    public void userClickViewComment() {
        interact.viewCommentButtonInsideTheMore.click();
    }
    @Then("User should be able to view his own comment.")
    public void userShouldBeAbleToViewHisOwnComment() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(interact.viewCommentPage.isDisplayed());
        Driver.getDriver().navigate().back();
        BrowserUtils.sleep(2);
    }

    @And("User click copy link button.")
    public void userClickCopyLinkButton() {
        BrowserUtils.sleep(1);
        interact.copyLinkButtonInsideTheMore.click();
    }
    @Then("User should be able to copy the link.")
    public void userShouldBeAbleToCopyTheLink() {
        Assert.assertTrue(interact.copyLinkIcon.isDisplayed());
        BrowserUtils.sleep(2);
    }

    @And("User click edit button.")
    public void userClickEditButton() {
        interact.editButtonInsideTheMore.click();
    }
    @And("User writes {string} on the comment box and click send button.")
    public void userWritesOnTheCommentBoxAndClickSendButton(String string) {
        Driver.getDriver().switchTo().frame(interact.commentIFrame);
        interact.commentBox.sendKeys(string);
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);
        interact.commentSendButton.click();
        BrowserUtils.sleep(2);
    }
    @Then("User should be able to edit his comment.")
    public void userShouldBeAbleToEditHisComment() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(interact.edittedCommentDisplayed.isDisplayed());
    }

    @When("User click new more button under the his own comment.")
    public void userClickNewMoreButtonUnderTheHisOwnComment() {
        interact.newMoreButtonUnderTheComment.click();
    }
    @And("User click create task button.")
    public void userClickCreateTaskButton() {
        BrowserUtils.sleep(1);
        interact.createTaskButtonInsideTheMore.click();
    }
    @Then("User should be able to create task.")
    public void userShouldBeAbleToCreateTask() {
        BrowserUtils.sleep(4);
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue(interact.createdTask.isDisplayed());
    }

    @And("User click delete button.")
    public void userClickDeleteButton() {
        BrowserUtils.sleep(1);
        interact.deleteButtonInsideTheMore.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @Then("User should be able to delete his own comment.")
    public void userShouldBeAbleToDeleteHisOwnComment() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(interact.deletedMessage.isDisplayed());

    }


    //FIFTH SCENARIO
    @When("User click reviewers' button")
    public void userClickReviewersButton() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(interact.reviewersButton).perform();
        BrowserUtils.sleep(2);
    }
    @And("User click reviewers' name")
    public void userClickReviewersName() {
        interact.reviewersName.click();
    }
    @Then("User should be able to see reviewers' profile")
    public void userShouldBeAbleToSeeReviewersProfile() {
        Set<String> list = Driver.getDriver().getWindowHandles();
        for(String each : list ){
            Driver.getDriver().switchTo().window(each);
            if(Driver.getDriver().getTitle().contains("cybertekschool.com")){
                break;
            }
        }
        Assert.assertTrue(interact.reviewersPage.isDisplayed());
        BrowserUtils.sleep(2);
    }

    //SIXTH SCENARIO
    @When("User click star icon")
    public void userClickStarIcon() {
        //Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(4);
        //actions.moveToElement(interact.addToFavorites).click().perform();
        interact.addToFavorites.click();
        BrowserUtils.sleep(2);
    }
    @Then("User should be able to add others' posts to favorites")
    public void userShouldBeAbleToAddOthersPostsToFavorites() {
        Assert.assertTrue(interact.verifyAddedToFavorites.isDisplayed());
    }
}
