Feature: Create Account and login



Scenario Outline: create account to application

Given user should open link
Then click on accountand enter credentials "<SheetName>" and <RowNumber>
And click on submit
 
 Examples:
 |SheetName|RowNumber|
 |hackathon5|0|
  
Scenario Outline: TESTCASE10 Product Availabilty

Given user should login to application 
Then enters credentials "<SheetName>" and <RowNumber>
And click on login
And user search for item and add to cart

Examples:
|SheetName|RowNumber|
 |hackathon5|0|
Scenario Outline: TESTCASE11 Remove Product

Given user should login to application 
Then enters credentials "<SheetName>" and <RowNumber>
And click on login
And select a product and Add to cart

Examples:
|SheetName|RowNumber|
|hackathon5|1|
 
 
 Scenario Outline: TESTCASE12 Apply Coupon Code

Given user should login to application 
Then enters credentials "<SheetName>" and <RowNumber>
And click on login
Then user mouseover to laptop 
And user changes delivery date
Then user Adds to cart and add coupon apply
Examples:
|SheetName|RowNumber|
|hackathon5|0|

Scenario Outline: TESTCASE13 Coupon code

Given user should login to application 
Then enters credentials "<SheetName>" and <RowNumber>
And click on login
Then User apply empty coupon code

Examples:
|SheetName|RowNumber|
|hackathon5|0|
