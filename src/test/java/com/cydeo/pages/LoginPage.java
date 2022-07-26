package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://qa.crmly.net/
public class LoginPage {

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement login;

    public static void login(String username){
        LoginPage page=new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Actions actions=new Actions(Driver.getDriver());
        page.username.clear();
        //actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        page.username.sendKeys(username);
        page.password.sendKeys(ConfigurationReader.getProperty("loginPassword"));
        page.login.click();
    }

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




}