Feature: User should put the invalid password 

@invalidpass @smoke
Scenario: Putting invalid password error massage should display 

 Given user should be on the login page 
 When user type the valid Username and invalid password 
Then user should see the error message 