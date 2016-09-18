@ClearAllEnvironment
Feature: Epics Pivotal Tracker Testing With Json
  Scenario: Verify to create, edit and delete an specific Epic API by Id using json
    When I send a /projects POST with the json
          """
            {
              "name":"Project 00-11"
            }
          """
    Then I expect Status code 200
    And I store as a Project1
    When I send a /projects/[Project1.id]/epics POST with the json
        """
          {
            "name":"Epic 001"
          }
        """
    Then I store as a Epic1
    When  I send a /projects/[Project1.id]/epics/[Epic1.id] PUT with the json
        """
          {
            "name":"Epic 001 updated"
          }
        """
    Then I expect Status code 200
    And The name field should be equals to Epic 001 updated
    When I send a /projects/[Project1.id]/epics/[Epic1.id] DELETE
    Then I expect Status code 204
    When I send a /projects/[Project1.id] DELETE
    Then I expect Status code 204