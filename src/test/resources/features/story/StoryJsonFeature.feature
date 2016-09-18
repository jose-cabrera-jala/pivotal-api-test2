@ClearAllEnvironment
Feature: Stories Pivotal Tracker Testing With Json
  Scenario: Verify to create, edit and delete an specific Story API by Id using json
    When I send a /projects POST with the json
          """
            {
              "name":"Project 00-22"
            }
          """
    Then I expect Status code 200
    And I store as a Project1
    When I send a /projects/[Project1.id]/stories POST with the json
          """
            {
              "name":"Story 001"
            }
          """
    Then I store as a Story1
    When  I send a /projects/[Project1.id]/stories/[Story1.id] PUT with the json
          """
            {
              "name":"Story 001 updated"
            }
          """
    Then I expect Status code 200
    And The name field should be equals to Story 001 updated
    When I send a /projects/[Project1.id]/stories/[Story1.id] DELETE
    Then I expect Status code 204
    When I send a /projects/[Project1.id] DELETE
    Then I expect Status code 204