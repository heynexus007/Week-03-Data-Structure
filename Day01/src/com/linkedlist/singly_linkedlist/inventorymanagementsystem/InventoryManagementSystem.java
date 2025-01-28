package com.linkedlist.singly_linkedlist.inventorymanagementsystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // adding items by callling method to it
        inventory.addItemAtEnd("Laptop", 1001, 12, 89999);
        inventory.addItemAtEnd("Phone", 1002, 19, 27999.00);
        inventory.addItemAtBeginning("Tablet", 1003, 4, 60000.00);

        System.out.println("-----Inventory List-----");
        inventory.displayInventory();

        System.out.println("\nUpdating quantity for ID 1001 : ");
        inventory.updateQuantityById(1001, 10);
        inventory.displayInventory();

        System.out.println("\nSearching for item with ID 1002 : ");
        inventory.searchItem("1002");

        System.out.println("\nTotal Inventory Value : Rs" + inventory.calculateTotalValue());

        System.out.println("\nSorting inventory by price : ");
        inventory.sortInventory(false);
        inventory.displayInventory();

        System.out.println("\nRemoving item with ID 1003 : ");
        inventory.removeItemById(1003);
        inventory.displayInventory();
    }
}
