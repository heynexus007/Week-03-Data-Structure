package com.linkedlist.circular_linkedlist.ticketreservationsystem;

public class ReservationMain {
    public static void main(String[] args) {
        TicketReservationSystem reservationSystem = new TicketReservationSystem();

        // Add tickets
        reservationSystem.addTicket(101, "Alice", "Inception", "A1", "10:00 AM");
        reservationSystem.addTicket(102, "Bob", "Avatar", "B2", "12:00 PM");
        reservationSystem.addTicket(103, "Charlie", "Inception", "A2", "10:00 AM");

        // Display tickets
        reservationSystem.displayTickets();

        // Search for tickets
        reservationSystem.searchTicket("Inception");
        reservationSystem.searchTicket("Alice");

        // Remove a ticket
        reservationSystem.removeTicket(102);

        // Display tickets after removal
        reservationSystem.displayTickets();

        // Total tickets
        System.out.println("Total Tickets: " + reservationSystem.getTotalTickets());
    }
}
