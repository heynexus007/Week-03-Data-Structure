package com.linkedlist.singly_linkedlist.inventorymanagementsystem;

public class InventoryManagement {
    // Node class for linked list
    static class ItemNode {
        String itemName;
        int itemId;
        int quantity;
        double price;
        ItemNode next;

        // Constructor to initialize a Node
        ItemNode(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    private ItemNode head; // Head of the linked list

    // Adding an item at the beginning or before head
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Adding an item at the end or tail
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Adding an item at any specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        ItemNode temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Removing an item based on ItemID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found");
            return;
        }
        temp.next = temp.next.next;
    }

    // Updating quantity of an item by ItemID
    public void updateQuantityById(int itemId, int newQuantity) {
        ItemNode temp = head;
        while (temp != null && temp.itemId != itemId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Item not found");
        } else {
            temp.quantity = newQuantity;
        }
    }

    // Searching for an item based on Item ID or Item Name
    public void searchItem(String nameOrId) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(nameOrId) || temp.itemName.equalsIgnoreCase(nameOrId)) {
                System.out.println("Item Found : " + temp.itemName + " | ID : " + temp.itemId + " | Quantity : " + temp.quantity + " | Price : " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found");
        }
    }

    // Calculate and display the total inventory value
    public double calculateTotalValue() {
        ItemNode temp = head;
        double totalValue = 0;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        return totalValue;
    }

    // Sorting items by name or their price
    public void sortInventory(boolean sortByName) {
        if (head == null || head.next == null)
            return;

        head = mergeSort(head, sortByName);
    }

    private ItemNode mergeSort(ItemNode head, boolean sortByName) {
        if (head == null || head.next == null)
            return head;

        ItemNode middle = getMiddle(head);
        ItemNode nextToMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(head, sortByName);
        ItemNode right = mergeSort(nextToMiddle, sortByName);

        return merge(left, right, sortByName);
    }

    private ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;

        ItemNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ItemNode merge(ItemNode left, ItemNode right, boolean sortByName) {
        ItemNode result = null;
        if (left == null) return right;
        if (right == null) return left;

        if ((sortByName && left.itemName.compareToIgnoreCase(right.itemName) <= 0)
                || (!sortByName && left.price <= right.price)) {
            result = left;
            result.next = merge(left.next, right, sortByName);
        } else {
            result = right;
            result.next = merge(left, right.next, sortByName);
        }
        return result;
    }

    // Displaying the collected inventory
    public void displayInventory() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println("Item Name : " + temp.itemName + " -> ID : " + temp.itemId + " -> Quantity : " + temp.quantity + " -> Price : " + temp.price);
            temp = temp.next;
        }
    }
}