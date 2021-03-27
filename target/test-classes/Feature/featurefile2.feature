@ui
Feature: Product search related
  

  @Search1
  Scenario: User is able to search product
    Given user Opened Browser
    And user navigates to the application url
    When user entered "Blackberrys" brand name in search text box
    And clicked on search button
    Then search product results displayed

  @Search2
  Scenario: User is able to see and select text from dropdown when he types partial text in search box
  Given user navigates to the application url
  When user entered "Blackberrys" brand name in search text box
  Then user can see and select the dropdown which starts with name "Blackberrys"
  
  
  @search3
   Scenario: User is able to filter the result based on prices
   Given user navigates to the application url
   And user entered "Blackberrys" brand name in search text box
   When user enter minimum and maximum price range as mentioned below table
   |MIN_PRICE|MAX_PRICE| 
   |499     |4373     |
   Then search result get filter as below table
   |MIN_PRICE|MAX_PRICE| 
   |499     |4373     |
   
   
   
   
   
  
  
  
  
  
  
