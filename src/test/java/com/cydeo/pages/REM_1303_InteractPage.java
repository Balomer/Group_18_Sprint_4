package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class REM_1303_InteractPage {
    
    public REM_1303_InteractPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='feed-post-informers-cont']//a[.='Comment']")
    public WebElement commentButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement commentIFrame;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement commentBox;

    @FindBy(xpath = "//button[contains(@id,'lhe_button_submit_blogComment')]")
    public WebElement commentSendButton;

    @FindBy(xpath = "//div[@class='feed-item-wrap']//div[@class='feed-com-text-inner-inner']//div[.='comment']")
    public WebElement writtenComment;

    @FindBy(xpath = "//div[@class='feed-post-informers-cont']//a[.='Like']")
    public WebElement likeButton;

    @FindBy(xpath = "//span[@title='Like']")
    public WebElement iconLike;

    @FindBy(xpath = "//div[@class='feed-post-informers-cont']//a[.='Unfollow']")
    public WebElement unfollowButton;

    @FindBy(xpath = "//div[@class='feed-post-informers-cont']//a[.='Follow']")
    public WebElement followText;

    @FindBy(xpath = "//div[@class='feed-com-block-cover']//a[.='munster smith']/../../../..//div[@class='feed-com-informers-bottom']//span/span/a")
    public WebElement commentLikeButton;

    @FindBy(xpath = "//div[@class='feed-com-block-cover']//a[.='munster smith']/../../../div/span/span/span")
    public WebElement commentLikeIcon;

    @FindBy(xpath = "//div[@class='feed-com-block-cover']//a[.='munster smith']/../../../..//div[@class='feed-com-informers-bottom']/a[.='Reply']")
    public WebElement commentReplyButton;

    @FindBy(xpath = "//div[@class='feed-com-block-cover']//a[.='munster smith']/../../../../../..//div[text()=', comment reply']")
    public WebElement writtenCommentReply;

    @FindBy(xpath = "//div[@class='feed-com-text-inner']//div[.='my own comment']/../../../../..//div[@class='feed-com-informers-bottom']/span/span/a")
    public WebElement ownCommentLikeButton;

    @FindBy(xpath = "//div[@class='feed-com-text-inner']//div[.='my own comment']/../../../../..//div[@class='feed-com-informers-bottom']/a[.='Reply']")
    public WebElement ownCommentReplyButton;

    @FindBy(xpath = "//div[@class='feed-com-text-inner']//div[.='my own comment']/../../../../..//span[@data-reaction='like']")
    public WebElement ownCommentLikeIcon;

    @FindBy(xpath = "//div[text()=', my own comment reply message']")
    public WebElement ownCommentReplyMessage;




}
