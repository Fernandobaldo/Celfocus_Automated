# Created by fernandobaldo at 18/05/21
Feature:  Enter feature name here


  Scenario: Validate that it is possible to add a new user with a job
    When I use user creation service
    And I set name "Toy"
    And I set job "singer"
    Then I validate my response is correct

  Scenario: Delete user
    When I use the User Delete service
    Then I define the userId "2"
    And The user should be deleted

  Scenario: Register user without Password
    Given I use the Register User service
    When I define the user Email "user01@mailinator.com"
    Then The user should not be created
