Feature: invalid massage

@invalidLogin @smoke
Scenario: User should see the invalid massage

Given user should be on login page
When user type the invalid username and the valid password
Then user should see the error massage 