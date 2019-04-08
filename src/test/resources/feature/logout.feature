Feature: User should login then loggout

@logout @smoke
Scenario: User should log out 

Given user should be on the login page again 
When  user inters the valid username and valid password
Then user should click on login button
Then  user should click on log out button to log out
  
  
 