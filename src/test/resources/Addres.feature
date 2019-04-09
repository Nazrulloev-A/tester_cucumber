Feature: Fill the address bar 

@Addressbar @smoke
Scenario: User should fill the address bar 

Given user should be on the orders part
When user fill the Order part 
Then user should click to calculate button and see the result 
And user should fill the address bar in order to make payment 