Feature: User payment information 

@paymentinfo
Scenario: User should put his/ her payment information in order to make order

Given user should be on the order page 
When user should fill the payment bar and select the type of card 
Then user should click to Process button to make order 