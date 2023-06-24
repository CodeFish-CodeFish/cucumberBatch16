Feature: Testing the Food Order Functionality of WebOrder

  Background: Food Order same steps
    Given User provides username and password for successful login
    When User clicks Group Order Box and Next Button
    And User provides note 'I LOVE SELENIUM' to invitees box
    And User provides gmail "Ahmet@gmail.com","mehmet@gmail.com" to InviteList

  Scenario: Testing Happy Path for MyHouse Food Order
    And User chooses the location 'My House' and validates the address '3137 Laguna Street'
    And User clicks Create Group Order Button
    Then User validates the header 'View Group Order' and 'Your group order is now pending' from description

  Scenario: Testing Happy Path for Office Food Order
    And User chooses the location 'Office' and validates the address '2013 EMPIRE BLVD'
    And User clicks Create Group Order Button
    Then User validates the header 'View Group Order' and 'Your group order is now pending' from description


