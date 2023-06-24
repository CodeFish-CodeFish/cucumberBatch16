Feature: Testing the login functionality for WebOrder website

  Scenario: Happy Path(Correct username-Correct Password)
  When User provides "guest1@microworks.com",'Guest1!' and click Login button
  Then User validates the 'ORDER DETAILS - Weborder'

  Scenario: Negative Login(Correct username-Wrong Password)
    When User provides 'guest1@microworks.com','ahmet' and click Login button
    Then User validates the message 'Sign in Failed'

  Scenario: Negative Login(Wrong username-Correct Password)
    When User provides 'ahmet@gmail.com','Guest1!' and click Login button
    Then User validates the message 'Sign in Failed'

  Scenario: Negative Login(Empty username-Empty Password)
    When User provides ' ',' ' and click Login button
    Then User validates the message 'Sign in Failed'







  #1-Provide correct username and correct password validate title
    #2-Provide correct username and wrong password validate errormessage
    #3-Provide wrongusername and correct password validate errormessage
    #4-Provide both empty and validate errorMessage

