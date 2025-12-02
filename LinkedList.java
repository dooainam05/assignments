// package assignment2java;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {

    Node head = null;

    // Add new item at end
    void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Sort linked list using simple bubble sort
    void sortList() {
        if (head == null)
            return;

        Node current = head, index = null;
        int temp;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }

            current = current.next;
        }
    }

    // Print list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.print("How many items to insert? ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++)
            list.add(sc.nextInt());

        System.out.println("\nOriginal Linked List:");
        list.printList();

        list.sortList();

        System.out.println("\nSorted Linked List:");
        list.printList();

        sc.close();
    }

    
}