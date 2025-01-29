package com.linkedlist.doubly_linkedlist.moviemanagement;

public class MovieManagementSystem {
    // Node class to represent a movie
    static class MovieNode {
        String title;
        String director;
        int year;
        double rating;
        MovieNode next;
        MovieNode prev;

        // Constructor to initialize a movie node
        MovieNode(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    private MovieNode head; // Pointer to the first node
    private MovieNode tail; // Pointer to the last node

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (position == 0) { // Add at the beginning
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp == tail) { // Add at the end if position is beyond the list
            addMovieAtEnd(title, director, year, rating);
        } else { // Add at the specified position
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        MovieNode temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head) { // Remove head
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (temp == tail) { // Remove tail
            tail = tail.prev;
            tail.next = null;
        } else { // Remove from the middle
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie '" + title + "' removed successfully");
    }

    // Search for movies by director or rating
    public void searchMovie(String directorOrRating) {
        boolean found = false;
        MovieNode temp = head;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(directorOrRating) || String.valueOf(temp.rating).equals(directorOrRating)) {
                System.out.println("Movie Found: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found for the given criteria.");
        }
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        MovieNode temp = head;

        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }

        System.out.println("Movies in Forward Order:");
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        MovieNode temp = tail;

        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }

        System.out.println("Movies in Reverse Order:");
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update the rating of a movie by title
    public void updateMovieRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
        } else {
            temp.rating = newRating;
            System.out.println("Updated the rating of '" + temp.title + "' to " + newRating);
        }
    }
}
