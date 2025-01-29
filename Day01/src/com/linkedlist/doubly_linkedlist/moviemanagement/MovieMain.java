package com.linkedlist.doubly_linkedlist.moviemanagement;

public class MovieMain {
    public static void main(String[] args) {
        MovieManagementSystem movieSystem = new MovieManagementSystem();

        // Adding movies by created obj
        movieSystem.addMovieAtBeginning("Avenger -EndGame", "Stanley", 2023, 9.4);
        movieSystem.addMovieAtEnd("Lucy", "D.k Franciso", 2014, 8.6);
        movieSystem.addMovieAtEnd("Transformer", "dsbsfdf", 2024, 9.0);

        // Displaying movies in forward and reverse order
        movieSystem.displayMoviesForward();
        movieSystem.displayMoviesReverse();

        // Updating a movie's rating
        movieSystem.updateMovieRating("Lucy", 8.1);

        // Searching for a movie by Dir name and rating
        movieSystem.searchMovie("Stanley");
        movieSystem.searchMovie("9.4");

        // Removing a movie
        movieSystem.removeMovieByTitle("Lucy");

        // Displaying movies after removal
        movieSystem.displayMoviesForward();
    }
}
