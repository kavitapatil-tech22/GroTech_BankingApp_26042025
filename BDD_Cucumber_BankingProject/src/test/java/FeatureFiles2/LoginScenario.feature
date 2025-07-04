Feature: Validate Login Functionality of GrotechMinds Banking Application
@test12
  Scenario Outline: Validate Login functionality in GrotechMinds Banking Application
    Given user open the url for banking application
    And user clicks on Login Button in Webpage
    And user enters the uname as "<uid>"
    And user enters the pwd as "<password>"
    When user clicks on Login button
    Then validate that user able to login succesfully
    And also verify that the Title of the Login page is shown proper

    Examples: 
      | uid    | password  |
      | Kavita | Test@1234 |
