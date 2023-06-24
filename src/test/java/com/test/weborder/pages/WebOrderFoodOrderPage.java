package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderFoodOrderPage {

    public WebOrderFoodOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement groupOrderBox;

    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;

    @FindBy(css = "#InviteNote")
    WebElement inviteesBox;

    @FindBy(css = "#InviteList")
    WebElement inviteListBox;

    @FindBy(css = "#ConfirmAddressID")
    WebElement location;

    @FindBy(css = "#addressPreview")
    WebElement address;

    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement foodOrderHeader;

    @FindBy(xpath = "//p[contains(text(),'now pending')]")
    WebElement description;


    public void clickGroupOrderBox(){
        if(groupOrderBox.isDisplayed()){
            groupOrderBox.click();
        }
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void sendInviteesMessage(String note) throws InterruptedException {
        Thread.sleep(2000);
        inviteesBox.sendKeys(note);
    }

    public void sendInviteList(String email1,String email2) throws InterruptedException {
        Thread.sleep(2000);
        inviteListBox.sendKeys(email1+" , "+email2);
    }

    public void chooseLocation(String location,String expectedAddress){
        BrowserUtils.selectBy(this.location,location,"text");
        Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAddress));
    }

    public void clickCreateGroupOrderButton() throws InterruptedException {
        createGroupOrderButton.click();
        Thread.sleep(2000);
    }

    public void validateHeaderAndDescription(String expectedHeader,String expectedDescription){
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(foodOrderHeader));
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
    }

}
