package StackAndQueues;

import java.util.Stack;

public class QueueOperations {

    static class Queue {
        Stack<Integer> s1;
        Stack<Integer> s2;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.s1 = new Stack<>();
        q.s2 = new Stack<>();
        enQueue(q,1);
        enQueue(q,2);
        enQueue(q,3);
        System.out.print("Elements dequeued in sequence is : ");
        while (!q.s1.isEmpty())
            System.out.print(deQueue(q) + " ");
    }
    /*
        Queue using 2 stacks
    */
    static void enQueue(Queue q,int n) {
        while(!q.s1.isEmpty())
            q.s2.push(q.s1.pop());
        q.s1.push(n);
        while(!q.s2.isEmpty())
            q.s1.push(q.s2.pop());
    }

    static int deQueue(Queue q) {
        return q.s1.pop();
    }
}
