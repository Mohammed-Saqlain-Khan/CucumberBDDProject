
 Feature:  Adding Admin details in  Admin Page

   Background: common steps for all the scenario's

     Given User Launch The new  Chrome Browser
     When User navigates for the URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
     And User enter with the credentials UserName "Admin" and  password "admin123"
     And User click on login Button Link
     And User Click on the Admin Button

   @regression
   Scenario: Using adding a new Admin

     And User Click on the  Add Button in Admin Page
     Then The URL of the page should be "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"
     When User enters the UserRole as "Admin"
     And User enters the Employee name as down arrow
     And User enters the status as "Enabled"
     And User enters the Username as "{{RandomGeneratedName}}"
     And User enter the password as "#sulieman@78976" and confirmPassword as "#sulieman@78976"
     And User clicks on save
     Then Success Message is displayed
     And User close the browser

     @sanity
     Scenario: User Checking whether a new admin is added


       And User Enter the Username to be searched in the UserName textbox as "{{RandomGeneratedName}}"
       And User clicks on the search button
       Then User finds one records with expected username as "{{RandomGeneratedName}}"