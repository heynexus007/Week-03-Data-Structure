package com.linkedlist.circular_linkedlist.taskscheduler;

public class TaskMain {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addTaskAtBeginning(1, "Design Project", 2, "2025-02-01");
        scheduler.addTaskAtEnd(2, "Submit Report", 1, "2025-02-03");
        scheduler.addTaskAtPosition(2, 3, "Team Meeting", 3, "2025-01-30");

        // Display all tasks
        scheduler.displayAllTasks();

        // Remove a task
        scheduler.removeTaskById(3);

        // Display all tasks
        scheduler.displayAllTasks();

        // View and move to the next task
        scheduler.viewAndMoveToNext();

        // Display all tasks again
        scheduler.displayAllTasks();

        // Search for tasks by priority
        scheduler.searchByPriority(1);
    }
}
