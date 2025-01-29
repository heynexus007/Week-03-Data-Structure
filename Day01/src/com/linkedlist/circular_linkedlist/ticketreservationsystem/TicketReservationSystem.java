package com.linkedlist.circular_linkedlist.ticketreservationsystem;

public class TicketReservationSystem {
    // Node class
    static class TicketNode {
        int ticketId; // Ticket ID
        String customerName; // Customer's Name
        String movieName; // Movie Name
        String seatNumber; // Seat Number
        String bookingTime; // Booking Time
        TicketNode next; // Pointer to the next node

        // Constructor to initialize a ticket node
        TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode tail; // Pointer to the last node in the circular list
    private int ticketCount; // Total number of booked tickets

    // Constructor to initialize the ticket reservation system
    public TicketReservationSystem() {
        this.tail = null;
        this.ticketCount = 0;
    }

    // Adding a new ticket reservation at end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (tail == null) { // If the list is empty
            tail = newTicket;
            tail.next = tail; // Point to itself
        } else {
            newTicket.next = tail.next; // Point to the first node
            tail.next = newTicket; // Update the last node's next pointer
            tail = newTicket; // Update the tail to the new ticket
        }

        ticketCount++;
        System.out.println("Ticket added successfully: Ticket ID " + ticketId);
    }

    // Removing a ticket by TicketID
    public void removeTicket(int ticketId) {
        if (tail == null) { // If the list is empty
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = tail.next; // Start from the first node
        TicketNode previous = tail;

        do {
            if (current.ticketId == ticketId) { // Ticket found
                if (current == tail && current.next == tail) { // Only one ticket in the list
                    tail = null;
                } else if (current == tail) { // Remove the last ticket
                    previous.next = current.next;
                    tail = previous;
                } else if (current == tail.next) { // Remove the first ticket
                    tail.next = current.next;
                } else { // Remove a ticket in the middle
                    previous.next = current.next;
                }

                ticketCount--;
                System.out.println("Ticket removed successfully: Ticket ID " + ticketId);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != tail.next); // Loop back to the first node

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    // Displaying all tickets in the circular list
    public void displayTickets() {
        if (tail == null) { // If the list is empty
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("Current Tickets:");
        TicketNode current = tail.next; // Start from the first node

        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != tail.next); // Loop back to the first node
    }

    // Searching for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (tail == null) { // If the list is empty
            System.out.println("No tickets to search.");
            return;
        }

        TicketNode current = tail.next; // Start from the first node
        boolean found = false;

        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket Found: Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != tail.next); // Loop back to the first node

        if (!found) {
            System.out.println("No tickets found for the given search term.");
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalTickets() {
        return ticketCount;
    }
}
