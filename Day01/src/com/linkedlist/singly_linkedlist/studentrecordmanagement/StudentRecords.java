package com.linkedlist.singly_linkedlist.studentrecordmanagement;

public class StudentRecords {
    class Student {
        int rollNumber;
        String name;
        int age;
        String grade;
        Student next;

        public Student(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    private Student head;

    // Adding student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Adding student at the end or tail
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Adding student at any specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range!!!");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete a student by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty!!!");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found!!!");
            return;
        }

        temp.next = temp.next.next;
    }

    // Searching for a student by rollNumber
    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll Number : " + temp.rollNumber + ", Name : " + temp.name + ", Age : " + temp.age + ", Grade : " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found!!!");
    }

    // Displaying all records of students
    public void displayAll() {
        if (head == null) {
            System.out.println("No records to display");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number : " + temp.rollNumber + ", Name : " + temp.name + ", Age : " + temp.age + ", Grade : " + temp.grade);
            temp = temp.next;
        }
    }

    // Updating a student's grade by rollNumber
    public void updateGrade(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll Number : " + rollNumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found!!!");
    }
}
