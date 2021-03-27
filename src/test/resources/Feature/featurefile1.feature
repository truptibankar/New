@tag

Feature: Myntra application website health check

  @ui
  Scenario: User is able to sign up in the application
    Given user navigates to the application url 
    And User is on profile icon
    When User clicked on Login/Signup button
    And User entered mobile no and clicked on continue
    Then User is able to sign in the application

