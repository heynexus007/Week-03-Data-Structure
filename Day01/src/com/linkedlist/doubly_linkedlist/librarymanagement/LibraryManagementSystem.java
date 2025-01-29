package com.linkedlist.doubly_linkedlist.librarymanagement;

public class LibraryManagementSystem {
    // Node class to represent a book
    static class BookNode {
        String title;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        BookNode next;
        BookNode prev;

        // Constructor to initialize a book Node
        BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    private BookNode head; // Pointer to the first Node
    private BookNode tail; // Pointer to the last Node
    private int bookCount; // Total no of books in the library

    // Addind a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        bookCount++;
    }

    // Adding a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        bookCount++;
    }

    // Adding a new book at any specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);

        if (position <= 0) { // Adding book at the beginning if position is 0 or less
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        BookNode temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp == tail) { // Add at the end if position is beyond the list
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else { // Add at the specified -position
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            bookCount++;
        }
    }

    // Remove a book by BookID
    public void removeBookById(int bookId) {
        BookNode temp = head;

        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found!!!");
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

        bookCount--;
        System.out.println("Book with ID " + bookId + " removed successfully");
    }

    // Search for a book by Title or their Author
    public void searchBook(String titleOrAuthor) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(titleOrAuthor) || temp.author.equalsIgnoreCase(titleOrAuthor)) {
                System.out.println("Book Found: Title : " + temp.title + " -> Author : " + temp.author + " -> Genre : " + temp.genre +
                        " -> Book ID : " + temp.bookId + " -> Available : " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found for the given search");
        }
    }

    // Update a book's Availability Status
    public void updateAvailabilityStatus(int bookId, boolean newStatus) {
        BookNode temp = head;

        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found!!!");
        } else {
            temp.isAvailable = newStatus;
            System.out.println("Updated availability status of book with ID " + bookId + " to " + newStatus);
        }
    }

    // Display all books in forward order
    public void displayBooksForward() {
        BookNode temp = head;

        if (temp == null) {
            System.out.println(" Books not available in the library");
            return;
        }

        System.out.println("Books in Forward Order : ");
        while (temp != null) {
            System.out.println("Title : " + temp.title + " -> Author : " + temp.author + " -> Genre : " + temp.genre +
                    " -> Book ID : " + temp.bookId + " -> Available : " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        BookNode temp = tail;

        if (temp == null) {
            System.out.println("Books not available in the library");
            return;
        }

        System.out.println("Books in Reverse Order : ");
        while (temp != null) {
            System.out.println("Title : " + temp.title + " -> Author : " + temp.author + " -> Genre : " + temp.genre +
                    " -> Book ID : " + temp.bookId + " -> Available : " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        return bookCount;
    }
}
