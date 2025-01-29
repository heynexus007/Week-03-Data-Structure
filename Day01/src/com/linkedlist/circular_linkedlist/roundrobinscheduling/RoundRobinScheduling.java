package com.linkedlist.circular_linkedlist.roundrobinscheduling;

public class RoundRobinScheduling {
    // Node class to represent a process
    static class Process {
        int processId; // Process ID
        int burstTime; // Burst time for the process
        int remainingTime; // Remaining time for execution
        int waitingTime; // Waiting time for the process
        int turnAroundTime; // Turn-around time for the process
        Process next; // Pointer to the next process

        // Constructor to initialize a process
        Process(int processId, int burstTime) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingTime = burstTime; // Initially, remaining time is the burst time
            this.waitingTime = 0;
            this.turnAroundTime = 0;
            this.next = null;
        }
    }

    private Process tail; // Pointer to the last process in the circular list
    private int totalProcesses; // Total number of processes

    // Constructor to initialize the round-robin scheduling system
    public RoundRobinScheduling() {
        this.tail = null;
        this.totalProcesses = 0;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime) {
        Process newProcess = new Process(processId, burstTime);

        if (tail == null) { // If the list is empty
            tail = newProcess;
            tail.next = tail; // Point to itself
        } else {
            newProcess.next = tail.next; // Point to the first process
            tail.next = newProcess; // Update the last process's next pointer
            tail = newProcess; // Update the tail to the new process
        }

        totalProcesses++;
        System.out.println("Process added successfully: Process ID " + processId + ", Burst Time " + burstTime);
    }

    // Remove a process by Process ID
    public void removeProcess(Process process) {
        if (tail == null) {
            System.out.println("No processes to remove.");
            return;
        }

        Process current = tail.next;
        Process previous = tail;

        do {
            if (current == process) {
                if (current == tail && current.next == tail) { // Only one process in the list
                    tail = null;
                } else if (current == tail) { // Remove the last process
                    previous.next = current.next;
                    tail = previous;
                } else if (current == tail.next) { // Remove the first process
                    tail.next = current.next;
                } else { // Remove a process in the middle
                    previous.next = current.next;
                }

                totalProcesses--;
                System.out.println("Process removed: Process ID " + current.processId);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != tail.next);
    }

    // Simulate the round-robin CPU scheduling
    public void simulate(int timeQuantum) {
        if (tail == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Process current = tail.next; // Start with the first process
        int currentTime = 0;

        System.out.println("\nSimulating Round-Robin Scheduling:");

        while (totalProcesses > 0) {
            if (current.remainingTime > 0) {
                System.out.println("Executing Process ID: " + current.processId + " | Remaining Time: " + current.remainingTime);

                if (current.remainingTime <= timeQuantum) {
                    currentTime += current.remainingTime;
                    current.remainingTime = 0;
                    current.turnAroundTime = currentTime;
                    current.waitingTime = current.turnAroundTime - current.burstTime;
                    removeProcess(current);
                } else {
                    currentTime += timeQuantum;
                    current.remainingTime -= timeQuantum;
                }
            }
            current = current.next; // Move to the next process
        }
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (tail == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        System.out.println("\nProcesses in the queue:");
        Process current = tail.next;

        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime +
                    ", Remaining Time: " + current.remainingTime);
            current = current.next;
        } while (current != tail.next);
    }

    // Calculate and display the average waiting and turn-around times
    public void calculateAverages() {
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        Process current = tail.next;
        do {
            if (current.remainingTime == 0) {
                totalWaitingTime += current.waitingTime;
                totalTurnAroundTime += current.turnAroundTime;
                processCount++;
            }
            current = current.next;
        } while (current != tail.next);

        if (processCount > 0) {
            System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / processCount);
            System.out.println("Average Turn-Around Time: " + (double) totalTurnAroundTime / processCount);
        } else {
            System.out.println("No completed processes to calculate averages.");
        }
    }
}
