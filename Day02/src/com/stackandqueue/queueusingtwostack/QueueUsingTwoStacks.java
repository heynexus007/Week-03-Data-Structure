package com.stackandqueue.queueusingtwostack;
import java.util.*;
public class QueueUsingTwoStacks {
   // Creating two Stacks
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // doing Enqueue operation
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty!!!");
            }
            // Transfer the elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        //Creating objects of Class
        QueueUsingTwoStacks Q = new QueueUsingTwoStacks();
        Q.enqueue(6);
        Q.enqueue(8);
        Q.enqueue(2);
        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
    }
}
