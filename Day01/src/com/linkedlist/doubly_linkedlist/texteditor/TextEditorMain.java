package com.linkedlist.doubly_linkedlist.texteditor;

public class TextEditorMain {
    public static void main(String[] args) {
        // Initialize the text editor with a history size of 10
        TextEditor editor = new TextEditor(10);

        // Simulating type and commands
        editor.addState("Hey!");
        editor.addState("Hey! How are you");
        editor.addState("Hey! How are you??");

        // Display current state
        editor.displayCurrentState();

        // Undo operations
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        // Redo operations
        editor.redo();
        editor.displayCurrentState();

        // Adding a new state (break redo history)
        editor.addState("Hello Again!");

        // Displaying all states (for debugging)
        editor.displayAllStates();
    }
}
