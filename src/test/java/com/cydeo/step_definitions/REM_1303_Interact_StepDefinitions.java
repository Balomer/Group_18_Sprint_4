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

public class REM_1303_Interact_StepDefinitions {

       /* @Given("User should be on the homepage")
        public void userShouldBeOnTheHomepage() {
            LoginPage page=new LoginPage();
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
            page.username.sendKeys(ConfigurationReader.getProperty("loginUsername"));
            page.password.sendKeys(ConfigurationReader.getProperty("loginPassword"));
            page.login.click();
        }*/

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
        Assert.assertTrue(interact.ownCommentReplyMessage.isDisplayed());
    }



}
