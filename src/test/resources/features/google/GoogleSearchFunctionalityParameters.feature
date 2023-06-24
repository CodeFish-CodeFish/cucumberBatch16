Feature:Testing the Google Search Functionality Parameters
#general description
  Background: navigate to the website same step
    Given User navigates to the 'https://www.google.com/'

  Scenario: Happy Path(positive) Testing for Search Parameters
  #test case
    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 links

  Scenario: Happy Path(positive) Testing Result for Search Parameters
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is less than 300000000

  Scenario: Testing Loading Time Search for an item Parameters
    When User searches for 'Turkish Baklava'
    Then User validates the loading time is less than 1.0