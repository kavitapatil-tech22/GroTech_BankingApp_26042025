Feature: Validate ContactsUs Functionality of GrotechMinds Banking Application
@test14
  Scenario Outline: Validate ContactsUs functionality in GrotechMinds Banking Application
    Given user open the url for banking application
    And user clicks on ContactsUs Button in Webpage
    And user enters the username as "<yourName>"
    And user enters the email as "<emailId>"
    And user enters the phoneNum as "<phoneNum>"
    And user enters the address as "<address>"
    And user enters the country as "<country>"
    And user enters the zipCode as "<zipCode>"
    When user clicks on Button Submit
    Then validate that user able to submit succesfully
    And also verify that the Title of the ContactsUs page is shown proper

    Examples: 
      | yourName | emailId | phoneNum   | address   | country | zipCode |
      | Kavita   | test123 | 8884431316 | Bengaluru | India   |  585608 |
