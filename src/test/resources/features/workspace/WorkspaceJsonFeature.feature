@ClearAllEnvironment
Feature: Workspace Pivotal Tracker With Json
  Scenario: Verify to create, edit and delete an specific Workspace API by Id using json
    When I send a /my/workspaces POST with the json
          """
            {
              "name":"Workspace 00-11"
            }
          """
    Then I expect Status code 200
    And I store as a Workspace1
    When I send a /my/workspaces/[Workspace1.id] DELETE
    Then I expect Status code 204