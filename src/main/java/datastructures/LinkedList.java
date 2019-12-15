package datastructures;

public class LinkedList<E> {

    public class Node<E> {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public void addFront(E data) {
        Node<E> newFront = new Node<E>(data);
        if(head != null) {
            newFront.next = head;
        }
        head = newFront;
    }

    public E getFirst() {
        if(head != null) {
            return (E) head.data;
        }
        return null;
    }

    public E getLast() {
        if(head != null) {
            Node current = head;
            while (current.next != null) {
                //Go next step
                current = current.next;
            }
            return (E) current.data;
        }
        return null;
    }

    public void addBack(E data) {
        Node<E> newTail = new Node<E>(data);

        if(head == null) {
            head = newTail;
        } else {
            Node current = head;
            while (current.next != null) {
                //Go next step
                current = current.next;
            }
            current.next = newTail;
        }
    }

    public int size() {
        int size = 0;
        if(head != null) {
            size++;
            Node current = head;
            while(current.next != null) {
                size++;
                //Go next step
                current = current.next;
            }
        }
        return size;
    }

    public void clear() {
        head = null;
    }

    public void deleteValue(E data) {
        if(head != null) {
            if(head.data == data) {
                head = head.next;
            }
            Node current = head;
            while(current.next != null) {
                if(current.next.data == data) {
                    if(current.next.next == null) {
                        current.next = null;
                        break;
                    } else {
                        Node nextPlusOne = current.next.next;
                        current.next = nextPlusOne;
                        break;
                    }
                }
                //Go next step
                current = current.next;
            }
        }
    }

    public void print() {
        if(head != null) {
            if(head.data == null) {
                System.out.println("empty");
            } else {
                System.out.println(head.data.toString());
            }
            Node current = head;
            while(current.next != null) {
                //Go next step
                current = current.next;
                if(current.data == null) {
                    System.out.println("empty");
                } else {
                    System.out.println(current.data.toString());
                }
            }
        } else {
            System.out.println("empty");
        }

    }

}
