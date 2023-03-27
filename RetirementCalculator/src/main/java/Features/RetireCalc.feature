#As a person who doesn’t want to work for my entire lifetime, I’d like to see check if I’m saving enough for my retirement, so that I can make smart financial decisions. 
#Acceptance criteria: 
#• User should be able to submit form with all required fields filled in 
#• Additional Social Security fields should display/hide based on Social Security benefits toggle 
#• User should be able to submit form with all fields filled in 
#• User should be able to update default calculator values 

Feature: Retirement Calculator
@TC01
Scenario: Check my retirement savings
Given Iam on Pre-retirement calculator page
When I fill mandatory fields 
And I calculate 
Then It shows my retirement

@TC02
Scenario: Check mandatory fields validation
Given Iam on Pre-retirement calculator page 
And I calculate without filling mandatory fields
Then It shows mandatory fields validation

@TC03
Scenario: Check default calculator values in retirement savings
Given Iam on Pre-retirement calculator page
When I fill mandatory fields 
When I click on default values link
And I fill values for default calculator 
And I save default calculator values
And I calculate 
Then It shows my retirement

@TC04
Scenario: Check additional Social Security fields should display when Social Security benefits field is Yes 
Given Iam on Pre-retirement calculator page
When I select Social Security field as Yes
Then It shows additional fields

@TC05
Scenario: Check additional Social Security fields should hide when Social Security benefits field is No
Given Iam on Pre-retirement calculator page
When I select Social Security field as No
Then It does not show additional fields
