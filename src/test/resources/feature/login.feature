Feature: login test

@login @smoke
Scenario: User should login with the right credentials

 Given User should be on login page
 When user enters the username and password 
 Then user should click button and login succesful