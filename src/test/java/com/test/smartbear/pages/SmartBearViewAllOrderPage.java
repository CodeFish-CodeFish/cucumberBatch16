package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class SmartBearViewAllOrderPage {

    public SmartBearViewAllOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> allInformation;


    public void validateInformationFromTable(String name,String product,String quantity,
                                             String street,String city,String state,String zipCode,
                                            String cardType,String cardNumber,String expirationDate){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now=LocalDateTime.now().plusDays(1);
        String currentDate=dtf.format(now);
        List<String> expectedInfo= Arrays.asList("",name,product,quantity,currentDate,street,city,state,
                zipCode,cardType,cardNumber,expirationDate,"");
        for(int i=1;i<allInformation.size()-1;i++){
            Assert.assertEquals(expectedInfo.get(i), BrowserUtils.getText(allInformation.get(i)));
        }


    }
}
