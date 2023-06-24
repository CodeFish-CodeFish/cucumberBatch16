package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.DriverHelper;

public class WebOrderLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage=new WebOrderLoginPage(driver);
    @When("User provides {string},{string} and click Login button")
    public void user_provides_and_click_login_button(String username, String password) {
    webOrderLoginPage.login(username,password);
    }
    @Then("User validates the {string}")
    public void user_validates_the(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
      Assert.assertEquals(expectedMessage,webOrderLoginPage.errorMessage());

    }

}
