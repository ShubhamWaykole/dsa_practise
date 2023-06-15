package StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackOperations {
    static class Stack {
        Queue<Integer> q1;
        Queue<Integer> q2;
    }

    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.q1 = new LinkedList<>();
        stk.q2 = new LinkedList<>();
        push(stk, 1);
        push(stk, 2);
        push(stk, 3);
        System.out.print("Elements popped in sequence is : ");
        while (!stk.q1.isEmpty())
            System.out.print(pop(stk) + " ");
    }

    static void push(Stack stk, int n) {
        while(!stk.q1.isEmpty())
            stk.q2.add(stk.q1.poll());
        stk.q1.add(n);
        while(!stk.q2.isEmpty())
            stk.q1.add(stk.q2.poll());
    }

    static int pop(Stack stk) {
        return stk.q1.poll();
    }
}
