package com.linkedlist.singly_linkedlist.studentrecordmanagement;
import java.util.Scanner;
//Main class
public class StudentManagement {
    public static void main(String[] args) {
        StudentRecords records = new StudentRecords();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Delete by Roll Number\n5. Search by Roll Number\n6. Display All\n7. Update Grade\n8. Exit");
            System.out.print("Enter your choice : ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number, Name, Age, Grade : ");
                    records.addAtBeginning(input.nextInt(), input.next(), input.nextInt(), input.next());
                    break;
                case 2:
                    System.out.print("Enter Roll Number, Name, Age, Grade : ");
                    records.addAtEnd(input.nextInt(), input.next(), input.nextInt(), input.next());
                    break;
                case 3:
                    System.out.print("Enter Position, Roll Number, Name, Age, Grade : ");
                    records.addAtPosition(input.nextInt(), input.nextInt(), input.next(), input.nextInt(), input.next());
                    break;
                case 4:
                    System.out.print("Enter Roll Number to delete : ");
                    records.deleteByRollNumber(input.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Roll Number to search : ");
                    records.searchByRollNumber(input.nextInt());
                    break;
                case 6:
                    records.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Roll Number and new Grade : ");
                    records.updateGrade(input.nextInt(), input.next());
                    break;
                case 8:
                    System.out.println("Exiting...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
