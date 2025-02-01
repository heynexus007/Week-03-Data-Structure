package Practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePract {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();

        q.offer(4);
        q.offer(2);
        q.offer(8);
//        q.poll();
//        q.poll();
        System.out.println(q.peek());
        System.out.println(q.peek());

        while (!q.isEmpty()){
            System.out.print(q.peek()+" -> ");
            q.poll();
        }

        System.out.println(q.peek());
//        if(q.isEmpty())
//            System.out.println("null");


    }
}
