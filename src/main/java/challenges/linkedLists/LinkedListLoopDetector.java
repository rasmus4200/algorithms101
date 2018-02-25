package challenges.linkedLists;

public class LinkedListLoopDetector {

    public Node head;

    public void addBack(Node newNode) {

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

    //
    // Solution: Loop detection
    //
    // This is an implementation of Floyd's cycle-finding algorithm for detecting loops
    // https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
    // https://stackoverflow.com/questions/2663115/how-to-detect-a-loop-in-a-linked-list

    public boolean hasLoop() {
        return hasLoop(head);
    }

    boolean hasLoop(Node first) {
        Node slow = first;
        Node fast = first;

        while(fast != null && fast.next != null) {
            slow = slow.next;          // 1 hop
            fast = fast.next.next;     // 2 hops

            if(slow == fast)  // fast caught up to slow, so there is a loop
                return true;
        }
        return false;  // fast reached null, so the list terminates
    }

}
