package com.test.weborder.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderHook {

    WebDriver driver= DriverHelper.getDriver();

    @Before//PLEASE IMPORT FROM CUCUMBER.IO not JUNIT
    public void setup(){
        driver.get(ConfigReader.readProperty("QA_weborder_url"));
    }

    @After//PLEASE IMPORT FROM CUCUMBER.IO not JUNIT
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotForCucumber(driver,scenario);
         driver.quit();
    }

}
