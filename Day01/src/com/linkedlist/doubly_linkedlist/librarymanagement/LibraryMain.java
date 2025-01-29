package com.linkedlist.doubly_linkedlist.librarymanagement;

//Main class
public class LibraryMain {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books by created object
        library.addBookAtBeginning("One Piece", "Eiichiro Oda", "Adventure", 7336, true);
        library.addBookAtEnd("Killing a Mockingbird", "Harper Lee", "Fiction", 2346, true);
        library.addBookAtPosition("The Jungle", "Richyard Kipling", "Comic", 7656, true, 1);

        // Displaying books
        library.displayBooksForward();
        library.displayBooksReverse();

        // Searching for a book
        library.searchBook("Eiichiro Oda");

        // Updating availability status
        library.updateAvailabilityStatus(7654, false);

        // Removing a book
        library.removeBookById(2346);

        // Counting collected books
        System.out.println("Total Books in Library : " + library.countBooks());
    }
}
