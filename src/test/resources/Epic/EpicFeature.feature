Feature: Epics Pivotal Tracker Testing

  Background: create a Project, and create an Epic
    When  I send a /projects POST request
        | name   | Project000X |
    Then I store as a Project1
    When I send a /projects/[Project1.id]/epics POST request
        | name   | Epic000X |
    Then I store as a Epic1

  @deleteProject
  Scenario: Delete epic
    When I send a /projects/[Project1.id]/epics/[Epic1.id] DELETE
    Then I expect Status code 204

  @deleteProject
  Scenario: Edit Epic
    When  I send a /projects/[Project1.id]/epics/[Epic1.id] PUT request
      | name | Epic updated |
    Then I expect Status code 200
    And The name field should be equals to Epic updated
#    And The name field not be equals to Project000X

  @deleteProject
  Scenario: Verify to get an individual epic by id
    When I send a /projects/[Project1.id]/epics/[Epic1.id] GET request
    Then I expect Status code 200

  @deleteProject
    Scenario: Verify to get all epics
      When I send a /projects/[Project1.id]/epics/ GET request
      Then I expect Status code 200