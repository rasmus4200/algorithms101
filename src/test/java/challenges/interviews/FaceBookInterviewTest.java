package challenges.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FaceBookInterviewTest {

    private FaceBookArrayIntersector intersector;

    @Before
    public void SetUp() {
        intersector = new FaceBookArrayIntersector();
    }

    @Test
    public void ArrayIntersection() {

        int[] array1 = { 1,2,4,5,6 };
        int[] array2 = { 2,3,5,7 };

        ArrayList<Integer> result = intersector.intersect(array1, array2);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);

        // this test currently fails - see if you can make it pass
        Assert.assertEquals(expected, result);
    }

    @Test
    public void ArrayIntersectionBruteForce() {

        int[] array1 = { 1,2,4,5,6 };
        int[] array2 = { 2,3,5,7 };
        ArrayList<Integer> result = intersector.intersectBruteForce(array1, array2);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void ArrayIntersectionElegant() {

        int[] array1 = { 1,2,4,5,6 };
        int[] array2 = { 2,3,5,7 };
        ArrayList<Integer> result = intersector.intersectElegant(array1, array2);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);

        Assert.assertEquals(expected, result);
    }

    // Q1: Write out binary tree node
    public class Node {

        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        // Q2: Implement copy
//        public Node copy() {
//
//            // you try
//
//        }

        public Node copy() {
            Node newNode = new Node(key);

            if (this.left != null) {
                newNode.left = this.left.copy();
            }

            if (this.right != null) {
                newNode.right = this.right.copy();
            }

            return newNode;
        }


        // Q3: Implement inOrderTraversal

//                     1
//                    / \
//                   2   3
//                  / \ / \
//                 4  5 6  7
//
//             4, 2, 5, 1, 6, 3, 7

//        public void inOrderTraversal() {
//
//            // you try
 //
//        }

        public void inOrderTraversal() {
            if (left != null) { // L
                left.inOrderTraversal();
            }

            System.out.println(key);// Root

            if (right != null) { // R
                right.inOrderTraversal();
            }
        }

    }

    @Test
    public void BinaryTree() {

        //          1
        //         / \
        //        2   3

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.left = node2;
        node1.right = node3;

        // Copy
        Node newNode1 = node1.copy();

        Assert.assertEquals(newNode1.key, node1.key);
        Assert.assertEquals(newNode1.left.key, node1.left.key);
        Assert.assertEquals(newNode1.right.key, node1.right.key);

        // InOrderTraversal
        node1.inOrderTraversal();
    }

}
