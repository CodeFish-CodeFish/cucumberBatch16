package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SmartBearOrderPage {

    public SmartBearOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "select")
    WebElement product;

    @FindBy(xpath = "//input[contains(@id,'Quantity')]")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;

    @FindBy(xpath = "//input[@value='Visa']")
    WebElement visa;

    @FindBy(xpath = "//input[@value='MasterCard']")
    WebElement masterCard;

    @FindBy(xpath = "//input[@value='American Express']")
    WebElement americanExpress;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;

    @FindBy(linkText = "Process")
    WebElement processButton;

    @FindBy(tagName = "strong")
    WebElement message;

    public void sendProductInformation(String product, String quantity) throws InterruptedException {
        BrowserUtils.selectBy(this.product, product, "text");
        Thread.sleep(1000);
        this.quantity.sendKeys(quantity);
    }

    public void sendAddressInformation(String customerName, String street, String city, String state, String zipCode) throws InterruptedException {
        this.customerName.sendKeys(customerName);
        Thread.sleep(1000);
        this.street.sendKeys(street);
        Thread.sleep(1000);
        this.city.sendKeys(city);
        Thread.sleep(1000);
        this.state.sendKeys(state);
        Thread.sleep(1000);
        this.zipCode.sendKeys(zipCode);
        Thread.sleep(1000);
    }

    public void sendPaymentInformation(String cardType,String cardNumber,String expireDate){
        selectCard(cardType);
        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
    }

    public void clickProcessButton(){
        processButton.click();
    }

    public String getMessage(){
        return BrowserUtils.getText(message);
    }

    public void selectCard(String cartType) {
        cartType = cartType.toLowerCase();

        switch (cartType) {
            case "visa":
                visa.click();
                break;
            case "mastercard":
                masterCard.click();
                break;
            case "american express":
                americanExpress.click();
                break;
            default:
                Assert.fail("Wrong card type");
        }
    }
}
