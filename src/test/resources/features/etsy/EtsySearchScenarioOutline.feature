Feature: Testing Etsy Search functionality with Scenario Outline

  Scenario Outline: Testing different products for Search Functionality
    When User searches for '<itemName>' for Etsy
    Then User validates the title '<title>' from Etsy
    Examples:
      | itemName | title      |
      | Hat      | Hat - Etsy |
      | Key      | Key - Etsy |
      | Pin      | Pin - Etsy |