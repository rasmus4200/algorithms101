package challenges.linkedLists;


import java.util.HashSet;

public class LinkedListRemoveDuplicates {

    public Node head;

    public void addBack(int data) {
        Node newNode = new Node(data);

        // if head... set and return
        if (head == null) {
            head = newNode;
            return;
        }

        // Else starting at head...
        Node current = head;

        // Walk until to hit tail
        while (current.next != null) {
            current = current.next;
        }

        // Set current node to equal newNode
        current.next = newNode;
    }

    public void removeDuplicates() {
        // Starting at head...
        removeDuplicates(head);
    }

    public void removeDuplicates(Node current) {
        // Create a hash table to store the unique values.
        // Then delete the duplicate as soon as we detect it while walking the list.
        // Algorithm is O(n).

        HashSet<Integer> uniques = new HashSet<Integer>();
        Node previous = null;

        while (current != null) {
            if (uniques.contains(current.data)) {
                previous.next = current.next; // skip this duplicate
            } else {
                uniques.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public int size() {

        if (head == null) {
            return 0;
        }

        int count = 1;
        Node current = head;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        return count;
    }

}
