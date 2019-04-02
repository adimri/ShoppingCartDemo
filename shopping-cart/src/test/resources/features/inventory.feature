Feature: Inventory for shopping
#This is how background can be used to eliminate duplicate steps 

Scenario: 
   Given I Fetch the inventory
   When I fetch the inventory
   Then I receive inventory 
