@regression
Feature: Testing the Order Creation Functionality of SmartBear Website

  Scenario: Creating the WebOrder from SmartBear
    Given User provides username and password for SmartBear login
    When User clicks Order Button and provides the 'MyMoney' and '4' for product information
    And User provides 'Ahmet','123 Main Street','Chicago','IL','60102' for address information
    And User provides 'VISA','1312312312','06/25' for payment information
    Then User clicks process button and validate 'New order has been successfully added.' and click view order button
    And User validates all information 'Ahmet','MyMoney','4','123 Main Street','Chicago','IL','60102','Visa','1312312312','06/25' from table


  Scenario Outline:Creating the WebOrder from SmartBear with Scenario Outline
    Given User provides username and password for SmartBear login
    When User clicks Order Button and provides the '<product>' and '<quantity>' for product information
    And User provides '<customerName>','<street>','<city>','<state>','<zipCode>' for address information
    And User provides '<cardType>','<cardNumber>','<expireDate>' for payment information
    Then User clicks process button and validate 'New order has been successfully added.' and click view order button
    And User validates all information '<customerName>','<product>','<quantity>','<street>','<city>','<state>','<zipCode>','<cardType>','<cardNumber>','<expireDate>' from table
    Examples:

      | product     | quantity | customerName | street          | city    | state | zipCode | cardType         | cardNumber | expireDate |
      | MyMoney     | 4        | Ahmet        | 123 Main Street | Chicago | IL    | 60102   | Visa             | 1312312312 | 06/25      |
      | ScreenSaver | 5        | Mehmet       | 123 Main Street | Chicago | IL    | 60102   | MasterCard       | 1312312312 | 06/25      |
      | FamilyAlbum | 6        | Ayse         | 123 Main Street | Chicago | IL    | 60102   | American Express | 1312312312 | 06/25      |


  Scenario:Creating the WebOrder from SmartBear with DataTable

    Given User provides username and password for SmartBear login
    When User clicks OrderButton and provides the product and quantity for product information
      | product  | MyMoney |
      | quantity | 4       |
    And User provides customerName,street,city,state,zipcode for address information
      | customerName | Ahmet           |
      | street       | 123 Main Street |
      | city         | Chicago         |
      | state        | IL              |
      | zipCode      | 60102           |
    And User provides cardType,cardNumber,expireDate for payment information
      | cardType   | Visa      |
      | cardNumber | 142523455 |
      | expireDate | 06/25     |
    And User clicks process button and validates message
      | New order has been successfully added. |






