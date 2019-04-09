Feature: Make new Order and calculate it 

@order
Scenario: Order and Calculate for discount 

Given user should be login to orderpage 
When user should make new orders and calculate it 
Then user should click to calculate button then see the result of order 