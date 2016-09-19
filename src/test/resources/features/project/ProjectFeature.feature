@ClearAllEnvironment
Feature: Projects Pivotal Tracker Testing

  Background: create a Project
    When  I send a /projects POST request
      | name   | Project0007 |
    Then I store as a Project1

  Scenario: Delete project
    When I send a /projects/[Project1.id] DELETE
    Then I expect Status code 204

  @deleteProject
  Scenario: Edit Project
    When  I send a /projects/[Project1.id] PUT request
      | name | Project update |
    Then I expect Status code 200
    And The name field should be equals to Project update

  @deleteProject
  Scenario: Verify to get all projects
    When I send a /projects GET request
    Then I expect Status code 200


