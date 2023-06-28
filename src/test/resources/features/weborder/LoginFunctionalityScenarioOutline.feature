Feature: Testing the login functionality for WebOrder website Scenario Outline

  @smoke
  Scenario: Happy Path(Correct username-Correct Password)
    When User provides "guest1@microworks.com",'Guest1!' and click Login button
    Then User validates the 'ORDER DETAILS - Weborder'

  Scenario Outline:
    When User provides '<username>','<password>' and click Login button
    Then User validates the message '<message>'
    Examples:
      | username                | password | message        |
      | guest1@microworks.com   | ahmet    | Sign in Failed |
      | wrongusername@gmail.com | Guest1!  | Sign in Failed |
      |                         |          | Sign in Failed |
