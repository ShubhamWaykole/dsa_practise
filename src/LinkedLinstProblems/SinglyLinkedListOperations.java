package LinkedLinstProblems;

import java.util.Arrays;
import java.util.LinkedList;

public class SinglyLinkedListOperations {
     static class Node {
        int data;
         Node next;
         Node(int n) {
            this.data = n;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        int length = 0;
        Node head = new Node(5);
        head.next = new Node(6);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);

        Node head2 = new Node(6);
        head2.next = new Node(2);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(9);

        System.out.print("Original list 1 is : ");
        print(head);
//        System.out.print("Original list 2 is : ");
//        print(head2);
//        System.out.println("Sum of 2 linked list in reverse is : ");
//        print(findSum(head, head2));
   //     System.out.println("Length of list is : " +  findLengthRecursive(head, length));
   //     System.out.println("Middle element is : " +  findMiddleNode(head).data);
   //     System.out.println("Last 3rd element is : " + findLast3Elements(head).data);
   //     System.out.println("Reversed list is : ");
   //     print(reverseIterative(head));
   //     System.out.println("Reversed list is : ");
   //     print(reverseRecursive(head));
        System.out.print("List after removing 10 : "  );
        print(removeElement(head,10));
    }

    static Node removeElement(Node start, int n) {
         if(start.data == n) {
             return start.next;
         }
         Node prev = start;
         Node current = start.next;
         while(current != null) {
            if(n == current.data) {
                prev.next = current.next;
            }
             prev = current;
             current = current.next;
         }
         return start;
     }
    static int findLengthIterative(Node head) {
         if(head == null) return 0;
         Node fast = head.next;
         int cnt = 1;
         while(true) {
             if(null == fast)
                 return cnt;
             else {
                 fast = fast.next;
                    cnt += 1;
             }
         }
     }

    static int findLengthRecursive(Node head, int cnt) {
         if(null == head)
             return cnt;
         cnt = 1 + findLengthRecursive(head.next,cnt);
         return cnt;
    }
     public static void print(Node current) {
          while(current != null) {
              System.out.print(current.data + " -> ");
              current = current.next;
          }
         System.out.print("null");
         System.out.println();
     }

     static Node reverseIterative(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
     }

     static Node reverseRecursive(Node head) {
         if(head == null)
            return head;
         if(head.next == null)
             return head;
         Node newHead = reverseRecursive(head.next);
         head.next.next = head;
         head.next = null;
         return newHead;
    }

    static Node findMiddleNode(Node head) {
         if(head == null || head.next ==null)
             return head;
         Node slow = head;
         Node fast = head.next;
         while(true)
         {
             if(fast == null || fast.next == null)
                 return slow;
             else {
                 slow = slow.next;
                 fast = fast.next.next;
             }
         }
     }

     static Node findLast3Elements(Node head) {
         if(head == null || null == head.next || null == head.next.next )
             throw new RuntimeException("Less then 3 elements in List");
         Node ptr = head;
         while(true) {
             if(null == ptr.next.next.next)
                 return ptr;
             ptr = ptr.next;
         }
     }

     // Gives sum of linked list : numbers stored in reverse order
     static Node findSum(Node list1, Node list2) {
         Node newList = null,prev = null;
         int carry = 0;
         while(list1 != null && list2 != null) {
             int sum = list1.data + list2.data + carry;
             Node newNode = new Node(sum % 10);
             carry = sum/10;
             if(null == newList)
                 newList = newNode;
             else
                 prev.next = newNode;
             prev = newNode;
             list1 = list1.next;
             list2 = list2.next;
         }
         if(carry != 0)
             prev.next = new Node(carry);
         return newList;
     }

     // Remove Duplicates - Unsorted list
    // static Node removeDuplicated(Node head)

}
