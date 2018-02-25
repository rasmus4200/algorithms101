package algorithms;

import algorithms.DynamicProgrammingMemoized;
import algorithms.DynamicProgrammingRecursive;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicProgrammingMemoizedTest {

    private DynamicProgrammingMemoized empty2x2;
    private DynamicProgrammingMemoized empty3x3;

    @Before
    public void setUp() throws Exception {

        int[][] paths2x2 = new int[][] {
                {0,0},
                {0,0}
        };
        empty2x2 = new DynamicProgrammingMemoized(paths2x2);

        int[][] paths3x3 = new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        empty3x3 = new DynamicProgrammingMemoized(paths3x3);

    }

    /*
    2 1
    1 x
     */
    @Test
    public void TwoByTwoEmptyPathCount() throws Exception {
        Assert.assertEquals(2, empty2x2.countPaths(0,0));
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

