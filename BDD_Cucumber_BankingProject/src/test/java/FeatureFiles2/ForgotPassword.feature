Feature: Validate Forgot password Functionality of GrotechMinds Banking Application
  @test13
  Scenario Outline: Validate Forgot password functionality in GrotechMinds Banking Application
    Given user clicks on the forgot password link Button
    And user enters email id as "<EmailId>"
    And user enters mobile number as "<PhoneNum>"
    When user clicks on Reset button
    Then validate that user able to reset forgot password succesfully
    And also verify that the Title of the forgot password page is shown proper

    Examples: 
      | EmailId | PhoneNum  |
      | Kavita  | Test@1234 |
