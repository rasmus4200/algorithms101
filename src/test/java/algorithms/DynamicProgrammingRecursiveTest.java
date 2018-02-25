package algorithms;

import algorithms.DynamicProgrammingIterative;
import algorithms.DynamicProgrammingRecursive;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicProgrammingRecursiveTest {

    private DynamicProgrammingIterative empty2x2;
    private DynamicProgrammingIterative empty3x3;

    @Before
    public void setUp() throws Exception {

        int[][] paths2x2 = new int[][] {
                {0,0},
                {0,0}
        };
        empty2x2 = new DynamicProgrammingIterative(paths2x2);

        int[][] paths3x3 = new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        empty3x3 = new DynamicProgrammingIterative(paths3x3);

    }

    /*
        2 1
        1 x
     */
    @Test
    public void TwoByTwoEmptyPathCount() throws Exception {
        Assert.assertEquals(2, empty2x2.countPaths(1,1));
    }

    /*
    6 3 1
    3 2 1
    1 1 x
    */
    @Test
    public void ThreeByThreeEmptyPathCount() throws Exception {
        Assert.assertEquals(6, empty3x3.countPaths(0,0));
    }

    @Test
    public void IsAtEnd() throws Exception {
        int row = 0;
        int column = 0;
        Assert.assertTrue(empty2x2.isAtEnd(row, column));
    }

    @Test
    public void IsInBounds() throws Exception {
        Assert.assertTrue(empty2x2.isInBounds(0,0));
        Assert.assertTrue(empty2x2.isInBounds(0,1));
        Assert.assertTrue(empty2x2.isInBounds(1,0));
        Assert.assertTrue(empty2x2.isInBounds(1,1));
        Assert.assertFalse(empty2x2.isInBounds(0,2));
        Assert.assertFalse(empty2x2.isInBounds(2,0));
    }

    @Test
    public void IsBlocked() throws Exception {
        int[][] paths = new int[][] {
                {0,0},
                {0,1}
        };
        DynamicProgrammingRecursive brute = new DynamicProgrammingRecursive(paths);
        Assert.assertFalse(brute.isBlocked(0,0));
        Assert.assertFalse(brute.isBlocked(0,1));
        Assert.assertFalse(brute.isBlocked(1,0));
        Assert.assertTrue(brute.isBlocked(1,1));
    }

    @Test
    public void CountBlockedPaths() throws Exception {
        int[][] paths = new int[][] {
                {0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,1,0},
                {0,0,0,0,1,0,0,0},
                {1,0,1,0,0,1,0,0},
                {0,0,1,0,0,0,0,0},
                {0,0,0,1,1,0,1,0},
                {0,1,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,0}
        };
        DynamicProgrammingRecursive brute = new DynamicProgrammingRecursive(paths);
        Assert.assertEquals(27, brute.countPaths(0,0));
    }

}

