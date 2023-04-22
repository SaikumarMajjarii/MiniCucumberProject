#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login Functionality for the Open Cart Application
  I want to Login with Valid and Invalid Credentials in to Open Cart

  
  Background: 
  Given User Should be On OpenCart Page

  Scenario: Login With Valid Credentials
    Given User Should be Able to Login with Valid "qatestertest@gmail.com" and "Test@123"
    When User Should be able to do login
 		Then User Should be able to Logged In Successfully
 


  Scenario Outline: Login With InValid Credentials
    Given User Should be Able to Login with inValid <UserName> and <Password>
    When User Should be able to do login
 	  Then I should see an error message indicating <error_message>

    Examples:
      | username          | password        | error_message                                         |
      | invalid@email.com | invalidPassword | Warning: No match for E-Mail Address and/or Password. |
      | abcccc            | validPassword   | Warning: No match for E-Mail Address and/or Password. |
      | valid@email.com   | abccc           | Warning: No match for E-Mail Address and/or Password. |

  Scenario: Navigating to the forgotten password page
    When I click on the "Forgotten Password" link
    Then I should be redirected to the password reset page