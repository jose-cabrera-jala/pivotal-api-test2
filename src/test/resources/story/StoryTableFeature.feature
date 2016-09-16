Feature: Stories Pivotal tracker Testing

  Background: create a project
    When  I send a /projects POST request
      | name   | Project_0001 |
    Then I store as a Project1

    Scenario: Create new story
      When I send a /projects/[Project1.id]/stories POST request
        | name | new_Story_001 |
      Then I expect Status code 200
      And I validate fields

  @deleteProject
  Scenario: Edit a story
    When I send a /projects/[Project1.id]/stories/[Story1.id] PUT request
      | name | new_Story_001|
    Then I expect Status code 200
#    And here I need validate fields

  @deleteProject
  Scenario: Delete a story
    When I send a /projects/[Project1.id]/stories/[Story1.id] DELETE
    Then I expect Status code 204