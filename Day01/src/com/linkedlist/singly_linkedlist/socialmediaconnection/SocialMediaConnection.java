package com.linkedlist.singly_linkedlist.socialmediaconnection;

import  java.util.*;
public class SocialMediaConnection {
    // Node class representing a user
    static class UserNode {
        int userId;
        String name;
        int age;
        List<Integer> friendIds; // List -> store Friend IDs
        UserNode next;

        // Constructor to initialize a user Node
        UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendIds = new ArrayList<>();
            this.next = null;
        }
    }

    private UserNode head; // Head of the user linked list

    // Adding a user to the system
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Finding a user by UserID
    private UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Adding a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        // Adding friend connection if not already present
        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
    }

    // Removing a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        user1.friendIds.remove((Integer) userId2);
        user2.friendIds.remove((Integer) userId1);
    }

    // Finding mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>();
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }

        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends");
        } else {
            System.out.println("Mutual Friends between User " + userId1 + " and User " + userId2 + ": " + mutualFriends);
        }
    }

    // Displaying all friends of any specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Friends of User " + userId + ": " + user.friendIds);
    }

    // Searching for a user by Name or UserID
    public void searchUser(String nameOrId) {
        UserNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.userId).equals(nameOrId) || temp.name.equalsIgnoreCase(nameOrId)) {
                System.out.println("User founde & ID : " + temp.userId + " -> Name : " + temp.name + " -> Age : " + temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("User not found");
        }
    }

    // Count the no. of friends for each user
    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println("User ID : " + temp.userId + " -> Name : " + temp.name + " -> Number of Friends: " + temp.friendIds.size());
            temp = temp.next;
        }
    }

    // Displaying all users
    public void displayAllUsers() {
        UserNode temp = head;
        if (temp == null) {
            System.out.println("No users in the system");
            return;
        }
        while (temp != null) {
            System.out.println("User ID : " + temp.userId + " -> Name : " + temp.name + " -> Age : " + temp.age + " -> Friends : " + temp.friendIds);
            temp = temp.next;
        }
    }
}
