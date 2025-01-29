package com.linkedlist.circular_linkedlist.taskscheduler;

public class TaskScheduler {
    // Node class to represent a task
    static class Task {
        int taskId; // Task ID
        String taskName; // Task Name
        int priority; // Task Priority
        String dueDate; // Task Due Date
        Task next; // Pointer to the next task

        // Constructor to initialize a task
        public Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private Task head; // Head of the circular linked list
    private Task tail; // Tail of the circular linked list

    // Add a task at the beginning of the circular list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) { // If the list is empty
            head = newTask;
            tail = newTask;
            tail.next = head; // Point to itself to maintain circular structure
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Update the tail's next pointer
        }
        System.out.println("Task added at the beginning: " + taskName);
    }

    // Add a task at the end of the circular list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) { // If the list is empty
            head = newTask;
            tail = newTask;
            tail.next = head; // Point to itself to maintain circular structure
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Maintain the circular structure
        }
        System.out.println("Task added at the end: " + taskName);
    }

    // Add a task at a specific position in the circular list
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task current = head;
        int count = 1;

        while (count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }

        if (current.next == head) {
            addTaskAtEnd(taskId, taskName, priority, dueDate);
        } else {
            newTask.next = current.next;
            current.next = newTask;
            System.out.println("Task added at position " + position + ": " + taskName);
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task current = head;
        Task previous = tail;

        do {
            if (current.taskId == taskId) {
                if (current == head && current == tail) { // Single task in the list
                    head = null;
                    tail = null;
                } else if (current == head) { // Remove the head task
                    head = head.next;
                    tail.next = head;
                } else { // Remove a task in the middle or end
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                System.out.println("Task removed: Task ID " + taskId);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewAndMoveToNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task: " + head.taskName + ", Priority: " + head.priority);
        head = head.next; // Move to the next task
    }

    // Display all tasks in the circular list
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nAll Tasks:");
        Task current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nTasks with Priority " + priority + ":");
        Task current = head;
        boolean found = false;

        do {
            if (current.priority == priority) {
                System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                        ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with Priority " + priority);
        }
    }
}
