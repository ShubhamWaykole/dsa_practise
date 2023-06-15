package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.max;

public class BinaryTreeOperations {
    static class Node {
        int key;
        Node left,right;
        Node(int data) {
            key = data;
            left = right = null;
        }
    }
    public static void main(String[] args) {

        Queue<Node> q = new LinkedList<Node>();
        Node head = new Node(5);
        head.left = new Node(4);
        head.right = new Node(7);
        head.left.left = new Node(2);
        head.left.right = new Node(1);
        head.right.left = new Node(10);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(15);
        System.out.println("           5               ");
        System.out.println("         /   \\            ");
        System.out.println("        4      7          ");
        System.out.println("      /  \\    /           ");
        System.out.println("    2     1   10          ");
        System.out.println("              / \\         ");
        System.out.println("             6   15        ");
        System.out.print("DF Inorder traversal is : ");
        inOrder(head);
        System.out.println();
        q.add(head);
        System.out.print("BF trversal is : ");
        breadthFirstTraversal(head, q);
        System.out.println();
        System.out.println("Height is : " + height(head,0));
        System.out.print("Preorder with recursion : ");
        preOrderRecursive(head);
        System.out.println();
        System.out.print("Preorder wout recursion : ");
        preOrderNonRecursive(head);
        System.out.println();
        System.out.print("Postorder with recursion : ");
        postOrderRecursive(head);
        System.out.println();
        System.out.print("Postorder wout recursion : ");
        postOrderNonRecursive(head);
        System.out.println();

    }

    static void breadthFirstTraversal(Node root,Queue<Node> q) {
        while(!q.isEmpty()) {
            Node node = q.remove();
            System.out.print("  " + node.key);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }
    static int height(Node root, int height) {
        if(root == null)
            return height;
        return 1 + max(height(root.left,height), height(root.right,height));
    }

    static void postOrderRecursive(Node root) {
        if (root == null)
            return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.key + " ");
    }

    /*
        Algo: Push root in stack
            while stack not empty
               peek item and check if it is leaf Node
                    if yes pop and print
                    else
                        push right in stack and make current.right = null
                        similar for left
     */
    static void postOrderNonRecursive(Node root) {
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()) {
            Node top = stk.peek();
            if(top.left == null && top.right == null) {
                Node node = stk.pop();
                System.out.print(node.key + " ");
            }
            else {
                if(top.right != null) {
                    stk.push(top.right);
                    top.right = null;
                }
                if(top.left != null) {
                    stk.push(top.left);
                    top.left = null;
                }

            }        }

    }
    static void preOrderRecursive(Node root) {
        if (root == null)
            return;
        System.out.print(root.key + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    static void preOrderNonRecursive(Node root) {
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while(!stk.empty()) {
            Node node = stk.pop();
            System.out.print(node.key + " ");
            if(node.right != null)
                stk.push(node.right);
            if(node.left != null)
                stk.push(node.left);
        }
    }

    static void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.key + "  ");
        inOrder(root.right);
    }

}
