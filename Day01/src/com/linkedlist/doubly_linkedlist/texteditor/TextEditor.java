package com.linkedlist.doubly_linkedlist.texteditor;

public class TextEditor {
    // Node class
    static class TextState {
        String content; // Text content
        TextState next; // Pointer to the next state (redo)
        TextState prev; // Pointer to the previous state (undo)

        // Constructor to initialize a text state
        TextState(String content) {
            this.content = content;
            this.next = null;
            this.prev = null;
        }
    }

    private TextState head; // First state in the list
    private TextState tail; // Last state
    private TextState current; // Current state
    private final int maxHistorySize; // Maximum number of states in history
    private int historySize; // Curr size of  history

    // Constructor to initialize the text editor with a history limit
    public TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.historySize = 0;
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    // Adding a new text state
    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null) {
            current.next = null; // Remove any redo history after current state
        }

        if (tail == null) { // If the list is empty
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }

        current = newState;

        // Ensuring- the history size does not exceed the maximum limit
        historySize++;
        if (historySize > maxHistorySize) {
            head = head.next;
            head.prev = null;
            historySize--;
        }
    }

    // Undo functionality (move to the prev state)
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Cannot undo. No previous state.");
        } else {
            current = current.prev;
            System.out.println("Undo successful. Current state: " + current.content);
        }
    }

    // Redo functionality (move to the next state)
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Cannot redo. No next state.");
        } else {
            current = current.next;
            System.out.println("Redo successful. Current state: " + current.content);
        }
    }

    // Displaying current state of the text
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No content available.");
        } else {
            System.out.println("Current state: " + current.content);
        }
    }

    // Display all states for debugging
    public void displayAllStates() {
        TextState temp = head;
        System.out.println("All States:");
        while (temp != null) {
            System.out.println(temp.content + (temp == current ? " <-- Current" : ""));
            temp = temp.next;
        }
    }
}
