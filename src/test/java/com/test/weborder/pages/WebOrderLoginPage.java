package com.test.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderLoginPage {

    public WebOrderLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#Email")
    WebElement username;

    @FindBy(css = "#Password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(css = ".alert-danger")
    WebElement errorMessage;

    public void login(String username,String password){
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
