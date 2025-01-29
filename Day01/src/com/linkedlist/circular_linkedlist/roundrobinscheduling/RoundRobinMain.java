package com.linkedlist.circular_linkedlist.roundrobinscheduling;

public class RoundRobinMain {
    public static void main(String[] args) {
        RoundRobinScheduling scheduler = new RoundRobinScheduling();

        // Add processes
        scheduler.addProcess(1, 5);
        scheduler.addProcess(2, 8);
        scheduler.addProcess(3, 7);
        scheduler.addProcess(4, 3);

        // Display processes
        scheduler.displayProcesses();

        // Simulate round-robin scheduling with a time quantum of 3
        scheduler.simulate(3);

        // Calculate averages
        scheduler.calculateAverages();
    }
}
