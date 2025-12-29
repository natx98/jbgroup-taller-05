Feature: Add Task

  @Regression
  Scenario: create new task

    Given i have access to WhenDo
    And i save random $task
    When i create new task:
      | title | NewTaskRandom   |
      | notes | This is a notes |
    Then the task with title "NewTaskRandom" and notes "This is a notes" should be created