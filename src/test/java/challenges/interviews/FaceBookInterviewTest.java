package challenges.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FaceBookInterviewTest {

    private FaceBookArrayIntersector intersector;

    // Question asked during my interview with FaceBook

    /*

    Part I - General knowledge
        Q1. What is an Optional and how would you write on yourself?
        Q2. What is concurrency and how does it work?

    Part II - Algorithms

        Q3. Find the intersection between two arrays.

        Binary Tree
        Q4. Define a node for a binary tree.
        Q5. Implement copy.
        Q6. Implement inOrderTraversal.
        Q7. Implement allValues.
        Q8. Walk me through inOrderTraversal slowly.

        Bonus - Sort an array of 1s and 0s into 0s first and then 1s.

     */


    @Before
    public void SetUp() {
        intersector = new FaceBookArrayIntersector();
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

}
