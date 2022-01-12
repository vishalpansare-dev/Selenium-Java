Feature: As a Amazon user I should be able to login and logout with valid credentials

  Scenario Outline: Login into the application with valid credentials
  	Given I am on the Login page URL "http://automationpractice.com/index.php"
  	Then I click on sign in button and wait for sign in page
    Then I should see Sign In Page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then I am logged in
   Examples:
   |username							|password|
   |Shedyamoore4@gmail.com|Test@123|
   
   Scenario Outline: Login into the application with valid credentials and sign out
  	Given I am on the Login page URL "http://automationpractice.com/index.php"
  	Then I click on sign in button and wait for sign in page
    Then I should see Sign In Page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then I am logged in
    Then I Click on Sign out
    Then I got log out from the application and land on sign in page
   Examples:
   |username							|password|
   |Shedyamoore4@gmail.com|Test@123|
   
   
     Scenario Outline: Login into the application with invalid credentials 
  	Given I am on the Login page URL "http://automationpractice.com/index.php"
  	Then I click on sign in button and wait for sign in page
    Then I should see Sign In Page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then I should get error msg
   Examples:
   |username					|password|
   |Shedyamoore4@l.com|Test@123|

  Scenario Outline: Searching different products after login
  	Given I am on the Login page URL "http://automationpractice.com/index.php"
  	When I click on sign in button and wait for sign in page
    Then I should see Sign In Page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then I am logged in
    And I search different "<products>" from the search bar
   Examples:
   |username							|password|products|
   |Shedyamoore4@gmail.com|Test@123|Blouse	|   
  
  
  Scenario: Validate all the navigation menu in Home Page
  Given I am on the Login page URL "http://automationpractice.com/index.php"
  When I click on sign in button and wait for sign in page
  Then I should see Sign In Page
  And I enter username as "Shedyamoore4@gmail.com"
  And I enter password as "Test@123"
  And click on login button
  And I am logged in
  And I can validate the Menu are available
  
 Scenario: Validate User able to add a product in cart
  Given I am on the Login page URL "http://automationpractice.com/index.php"
  When I click on sign in button and wait for sign in page
  Then I should see Sign In Page
  And I enter username as "Shedyamoore4@gmail.com"
  And I enter password as "Test@123"
  And click on login button
  And I am logged in
  When I Click on Women menu
  Then I navigate to the Women section
  When I Select one product from the page
  Then I can see that prodcut is added in the cart
  
  Scenario: Validate all the menu in My Account page
  Given I am on the Login page URL "http://automationpractice.com/index.php"
  When I click on sign in button and wait for sign in page
  Then I should see Sign In Page
  And I enter username as "Shedyamoore4@gmail.com"
  And I enter password as "Test@123"
  And click on login button
  When I Click on the profile
  Then I Navigate to the profile page
  Then I can validate All the menu in My Account page
  |Order history and details|
  |My credit slips|
  |My addresses|
  |My personal information|
  |My wishlists|
 
  
  Scenario: validate all the tabs are clickable
  Given I am on the Login page URL "http://automationpractice.com/index.php"
  When I click on sign in button and wait for sign in page
  Then I should see Sign In Page
  And I enter username as "Shedyamoore4@gmail.com"
  And I enter password as "Test@123"
  And click on login button
  When I Click on Women menu
  Then I navigate to the Women section
  When I Click on DRESSES menu
  Then I navigate to the DRESSES section
  When I Click on T-shirts menu
  Then I navigate to the T-shirts section

  
  Scenario: Validate correct email-id while creating new user
  Given I am on the Login page URL "http://automationpractice.com/index.php"
  When I click on sign in button and wait for sign in page
  Then I should see Sign In Page
  When I Enter Wrong Email-id "abc"
  And click on login button
  Then I should get error msg
 
   