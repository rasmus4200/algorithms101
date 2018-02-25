package datastructures;

public class LinkedListWithIndex {

    private static class Node {
        int key;
        int data;
        Node next;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    private Node head;

    public void addFront(int key, int data) {

        Node newNode = new Node(key, data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }

    public int getByIndex(int key) {
        Node current = head;

        // while we are not at the tail
        while (current.next != null) {
            // If we have a match
            if (current.key == key) {
                return current.data;
            }
            // Else goto the next node
            current = current.next;
        }

        // Check the last node
        if (current.key == key) {
            return current.data;
        }

        return -1; // Not found
    }

}
