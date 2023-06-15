package Java8;

public class leetLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1,l2);


    }
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode parent = null;
        int carry = 0;
        while(l1 != null && l2!= null) {
            int sum = ((l1.val + l2.val) % 10) + carry;
            carry = (l1.val + l2.val) / 10;
            if(parent == null) {
                parent = new ListNode(sum);
                l3 = parent;
            }
            else {
                ListNode newNode = new ListNode(sum);
                l3.next = newNode;
                l3 = l3.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return parent;
    }
}