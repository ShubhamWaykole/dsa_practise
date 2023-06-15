package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeOperations {
    static class Node {
        int key;
        Node left,right;
        Node(int data) {
            key = data;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        Node head = null;
        head = insert(head, new Node(5));
        head = insert(head, new Node(2));
        head = insert(head, new Node(7));
        head = insert(head, new Node(1));
        head = insert(head, new Node(3));
        head = insert(head, new Node(4));
        head = insert(head, new Node(9));
        System.out.print("Inorder of BST is : ");
        inOrder(head);
        System.out.println();
        System.out.println("checking number 6 in Tree : " + search(head,6));
        System.out.println("checking number 9 in Tree : " + search(head,9));
    }

    static boolean search(Node root, int data) {
        if(root.key == data)
            return true;
        if(data <= root.key && root.left != null)
            return search(root.left, data);
        if(data > root.key && root.right != null)
            return search(root.right, data);
        return false;
    }
    static Node insert(Node root, Node newNode) {
        if(root == null)
           return newNode;
        else if(newNode.key <= root.key)
           root.left = insert(root.left,newNode);
        else if(newNode.key > root.key)
           root.right = insert(root.right,newNode);
        return root;
    }

    static void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.key + "  ");
        inOrder(root.right);
    }
}
