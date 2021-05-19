# Created by fernandobaldo at 18/05/21
Feature:  Enter feature name here
  # Enter feature description here

  Scenario: Validate the product price for a full special support plan for 6 months simulation
    Given I open Chrome and launch the application
    And I select type "Special"
    And I select support plan "Full"
    And I write monthly duration of "6"
    When I click in calculate price button
    And I validate price is "2249.10 $"

