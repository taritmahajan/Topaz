Feature: Input Forms
  Background: navigate to home page
    Given navigate to home page
  Scenario:Input forms submit
    Given navigate to input forms submit page
    Then verify if title contains "Input Fom"

  Scenario:Input forms submit two
    Given navigate to input forms submit page
    Then fill the user form