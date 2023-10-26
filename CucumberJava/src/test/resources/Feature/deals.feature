Feature: Create Deal functionality 

@instance_1
 	Scenario: Create a new deal 
 	Given User is already login page
	When Title of login page is Login CRM
	Then User enter username and User enter password
	| bikramadityadas1@gmail.com | Test@1234 |
	Then User click on Login button
	Then User is on Homepage
	Then User move to deal page and create a new deals
	| Deal01 | 10 | 100 | 200 |
	Then Close the browser