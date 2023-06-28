package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.SmartBearLoginPage;
import com.test.smartbear.pages.SmartBearMainPage;
import com.test.smartbear.pages.SmartBearOrderPage;
import com.test.smartbear.pages.SmartBearViewAllOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartBearOrderCreationStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage=new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);

    SmartBearViewAllOrderPage smartBearViewAllOrderPage=new SmartBearViewAllOrderPage(driver);

    @Given("User provides username and password for SmartBear login")
    public void user_provides_username_and_password_for_smart_bear_login() {
     smartBearLoginPage.login(ConfigReader.readProperty("QA_smartBear_username"),
                              ConfigReader.readProperty("QA_smartBear_password"));
    }
    @When("User clicks Order Button and provides the {string} and {string} for product information")
    public void user_clicks_order_button_and_provides_the_and_for_product_information(String product, String quantity) throws InterruptedException {
        smartBearMainPage.clickOrderButton();
        smartBearOrderPage.sendProductInformation(product,quantity);
    }
    @When("User provides {string},{string},{string},{string},{string} for address information")
    public void user_provides_for_address_information(String customerName, String street, String city, String state, String zipCode) throws InterruptedException {
        smartBearOrderPage.sendAddressInformation(customerName,street,city,state,zipCode);
    }
    @When("User provides {string},{string},{string} for payment information")
    public void user_provides_for_payment_information(String cardType, String cardNumber, String expirationDate) {
        smartBearOrderPage.sendPaymentInformation(cardType,cardNumber,expirationDate);
    }
    @Then("User clicks process button and validate {string} and click view order button")
    public void user_clicks_process_button_and_validate_and_click_view_order_button(String expectedMessage) throws InterruptedException {
        smartBearOrderPage.clickProcessButton();
        Assert.assertEquals(expectedMessage,smartBearOrderPage.getMessage());
        smartBearMainPage.clickViewAllOrdersButton();
    }
    @Then("User validates all information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} from table")
    public void user_validates_all_information_from_table(String name,String product,String quantity,
                                                          String street,String city,String state,String zipCode,
                                                          String cardType,String cardNumber,String expirationDate) {
      smartBearViewAllOrderPage.validateInformationFromTable(name,product,quantity,street,city,state,zipCode,
              cardType,cardNumber,expirationDate);
    }

    @When("User clicks OrderButton and provides the product and quantity for product information")
    public void user_clicks_order_button_and_provides_the_product_and_quantity_for_product_information(DataTable dataTable) throws InterruptedException {
        Map<String,String> productInformation=dataTable.asMap();
        System.out.println(productInformation);
        smartBearMainPage.clickOrderButton();
        smartBearOrderPage.sendProductInformation(productInformation.get("product"),
                                                  productInformation.get("quantity"));
    }
    @When("User provides customerName,street,city,state,zipcode for address information")
    public void user_provides_customer_name_street_city_state_zipcode_for_address_information(DataTable dataTable) throws InterruptedException {
        Map<String,String> addressInformation=dataTable.asMap();
        smartBearOrderPage.sendAddressInformation(addressInformation.get("customerName"),
                                                  addressInformation.get("street"),
                                                  addressInformation.get("city"),
                                                  addressInformation.get("state"),
                                                  addressInformation.get("zipCode"));
    }
    @When("User provides cardType,cardNumber,expireDate for payment information")
    public void user_provides_card_type_card_number_expire_date_for_payment_information(DataTable dataTable) {
        Map<String,String> sendPaymentInformation=dataTable.asMap();
        smartBearOrderPage.sendPaymentInformation(sendPaymentInformation.get("cardType"),
                                                  sendPaymentInformation.get("cardNumber"),
                                                  sendPaymentInformation.get("expireDate"));
    }
    @When("User clicks process button and validates message")
    public void user_clicks_process_button_and_validates_message(DataTable dataTable) {
        smartBearOrderPage.clickProcessButton();
        List<String> message=dataTable.asList();
        Assert.assertEquals(message.get(0),smartBearOrderPage.getMessage());
    }
}
