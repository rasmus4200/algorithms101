package datastructures;

public class SingleLinkedList<E> {

    public Node head;
    public int size;

    public void push(E e) {
        Node newNode = new Node(e, null);

        newNode.next = head;
        head = newNode;

        size++;
    }

    public int lastIndexOf(E e) {
        Node current = head;
        int index = 0;

        while (current.next != null) {
            if (current.item == e) return index;
            index++;
            current = current.next;
        }

        // check the last node
        if (current.item == e) return index;

        return -1;
    }

    public E peek() {
        Node<E> f = head;
        return (f == null) ? null : f.item;
    }

    public E pop() {
        // get the head
        // assign head to it's next
        // return head
        if (head == null) return null;

        Node<E> first = head;
        head = first.next;
        size--;

        return first.item;
    }

    public boolean remove(E e) {
        // walk the list from the beginning
        // delete and return true if found
        // return false

        // head
        Node prev = null;
        Node current = head;

        if (current.item.equals(e)) {
            // make the next element the new head
            head = current.next;
            size--;
            return true;
        }

        // all others
        while (current.next != null) {
            prev = current;
            current = current.next;

            if (current.item.equals(e)) {
                // connect the previous node next to this nodes next
                // thereby bypassing this current node we want to delete
                prev.next = current.next;
                size--;
                return true;
            }
        }

        return false;
    }

    public void set(int index, E e) {

        Node newNode = new Node(e, null);

        // head
        if (index == 0) {
            newNode.next = head.next;
            head = newNode;
            return;
        }

        // all others
        // take the previous node
        // attach it's next to this new node
        // attach this new node to current next node

        Node prev = head;
        Node current = head.next;

        for (int counter = 1; counter <= index; counter++) {
            if (counter == index) {
                prev.next = newNode;
                newNode.next = current.next;
                return;
            } else {
                prev = current;
                current = current.next;
            }
        }

    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}



/*
 push() is neat because you are basically:

Creating a new node, assigning the old head value to be the next chain in the link (like adding), and the making
new node you just created the next head. So you are just bumping everything down one.

 1. Creating a new node.
 2. Assigning it's next to the current head (which at first is null because it is empty).
 3. And then assigning this newNode to the head. So it is at the front of the list.

 Then when you add the next node you repeat the process.
 1. Create the new node.
 2. Assign it's next to the current head of the list (the last element you added).
 3. And then making this next node the head.

 So you are basically constantly taking making new nodes, assigning their next to be current head.
 And then assigning them to be the new head (while their next points to the old head).
 And you just keep doing this.

*/