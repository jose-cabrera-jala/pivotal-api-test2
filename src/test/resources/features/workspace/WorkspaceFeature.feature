Feature: Projects Pivotal Tracker Testing

  Background: create a Workspace
    When  I send a /my/workspaces POST request
      | name   | WorkspaceTest56 |
    Then I store as a Workspace1

  Scenario: Delete workspace
    When I send a /my/workspaces/[Workspace1.id] DELETE
    Then I expect Status code 204

  @deleteProject @deleteWorkspace
  Scenario: Edit workspace
    When I send a /projects POST with the json
          """
            {
              "name":"Project for WorkSpace"
            }
          """
    Then I expect Status code 200
    And I store as a Project1
    When I send a /my/workspaces/[Workspace1.id] PUT with the json
          """
          {
              "project_ids":[Project1.id]
          }
          """
    Then I expect Status code 200
    And The project_ids field should be equals to [Project1.id]

  @deleteWorkspace
  Scenario: Verify to get all workspaces
    When I send a /my/workspaces GET request
    Then I expect Status code 200


