Feature: User should select all and delete orders 

@deleteAll @smoke
Scenario: Check all orders then Delete All orders 

Given user should be on the login page and select all
When user select check all button it should selecct all
Then user should clcik on deleteall button to delete all orders 
