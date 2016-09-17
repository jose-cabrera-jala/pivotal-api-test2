Feature: Projects Pivotal Tracker Testing

  Background: create a Workspace
    When  I send a /my/workspaces POST request
      | name   | WorkspaceTest56 |
    Then I store as a Workspace1

  Scenario: Delete workspace
    When I send a /my/workspaces/[Workspace1.id] DELETE
    Then I expect Status code 204

#  @deleteWorkspace
#  Scenario: Edit workspace
#    When  I send a /my/workspaces/[Workspace1.id] PUT request
#      | name | Work |
#    Then I expect Status code 200
#    And The name field should be equals to Work

  @deleteWorkspace
  Scenario: Verify to get all workspaces
    When I send a /my/workspaces GET request
    Then I expect Status code 200


