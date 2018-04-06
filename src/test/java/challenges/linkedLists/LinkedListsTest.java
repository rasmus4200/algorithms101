package challenges.linkedLists;

import datastructures.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListsTest {

    private LinkedListAdder adder;
    private Palindrome palindrome;

    @Before
    public void SetUp() {
        adder = new LinkedListAdder();
        palindrome = new Palindrome();
    }

    @Test
    public void Duplicates() {
        // Challenge: Write a method that removes any duplicates from our Linked List.

        LinkedListRemoveDuplicates linkedList = new LinkedListRemoveDuplicates();
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(1); // duplication

        linkedList.removeDuplicates();

        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void SumLists() {
        // Challenge: You have two numbers represented by a linked list.
        // Each node represents a single digit, in reverse order, such that the
        // 1's digit is at the head. Write a function that adds the two numbers
        // and returns the sum as a linked list.

        // Example
        // Input:  (8 -> 2 -> 5) + (4 -> 9 -> 2). That is 528 + 294.
        // Output: (2 -> 2 -> 8). That is 822.

        // Create our two numbers
        Stack first = new Stack();
        first.push(8);
        first.push(2);
        first.push(5);

        Stack second = new Stack();
        second.push(4);
        second.push(9);
        second.push(2);

        // Add them together
        Stack sum = adder.sum(first, second);

        // Check the result
        Assert.assertEquals(3, sum.size());

        while(!sum.isEmpty()) {
            System.out.println(sum.pop());
        }

    }

    @Test
    public void LoopDetection() {
        // Challenge: Given a circular linked list, implement an algorithm determines
        // whether the linked list has a circular loop
        //
        // Definition: A circular linked list (corrupt) is one where a node's next pointer
        // points to an earlier node.

        // Example
        // Input: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (same as earlier)

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        LinkedListLoopDetector loopDetector = new LinkedListLoopDetector();

        loopDetector.addBack(node1);
        loopDetector.addBack(node2);
        loopDetector.addBack(node3);
        loopDetector.addBack(node4);
        loopDetector.addBack(node5);
        loopDetector.addBack(node3); // loop!


        Assert.assertTrue(loopDetector.hasLoop());
    }

}
