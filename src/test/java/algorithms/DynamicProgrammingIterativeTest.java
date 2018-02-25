package algorithms;

import algorithms.DynamicProgrammingIterative;
import junit.framework.Assert;
import org.junit.Test;

public class DynamicProgrammingIterativeTest {

    /*
    2 1
    1 x
     */
    @Test
    public void TwoByTwoEmptyPathCount() throws Exception {
        int[][] paths2x2 = new int[][] {
                {0,0},
                {0,0}
        };
        DynamicProgrammingIterative empty2x2 = new DynamicProgrammingIterative(paths2x2);
        Assert.assertEquals(2, empty2x2.countPaths(1,1)); // start lower right
    }

    /*
    1 x
    1 1
    */
    @Test
    public void TwoByTwoOneCellBlocked() throws Exception {
        int[][] paths2x2 = new int[][] {
                {0,1},
                {0,0}
        };
        DynamicProgrammingIterative iterative = new DynamicProgrammingIterative(paths2x2);
        Assert.assertEquals(1, iterative.countPaths(1,1));
    }

    /*
    6 3 1
    3 2 1
    1 1 1
    */
    @Test
    public void ThreeByThreeEmpty() throws Exception {
        int[][] paths3x3 = new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        DynamicProgrammingIterative empty3x3 = new DynamicProgrammingIterative(paths3x3);
        Assert.assertEquals(6, empty3x3.countPaths(2,2));
    }

    /*
    3 1 0
    2 1 x
    1 1 1
    */
    @Test
    public void ThreeByThreeBlocked() throws Exception {
        int[][] paths3x3 = new int[][] {
                {0,0,0},
                {0,0,1},
                {0,0,0}
        };
        DynamicProgrammingIterative iterative = new DynamicProgrammingIterative(paths3x3);
        Assert.assertEquals(3, iterative.countPaths(2,2));
    }

    /*
    3 1 0
    2 1 x
    1 1 1
    */
    @Test
    public void ThreeByThreeBlocked2() throws Exception {
        int[][] paths3x3 = new int[][] {
                {0,0,0},
                {1,0,0},
                {0,0,0}
        };
        DynamicProgrammingIterative iterative = new DynamicProgrammingIterative(paths3x3);
        Assert.assertEquals(3, iterative.countPaths(2,2));
    }

    /*
    1 1 1
    x x 1
    1 1 1
    */
    @Test
    public void ThreeByThreeBlocked3() throws Exception {
        int[][] paths3x3 = new int[][] {
                {0,0,0},
                {1,1,0},
                {0,0,0}
        };
        DynamicProgrammingIterative iterative = new DynamicProgrammingIterative(paths3x3);
        Assert.assertEquals(1, iterative.countPaths(2,2));
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
        DynamicProgrammingIterative iterative = new DynamicProgrammingIterative(paths);
        Assert.assertEquals(27, iterative.countPaths(7,7));
    }

}

