package algorithms;

import algorithms.DynamicProgrammingIterative;
import algorithms.DynamicProgrammingMemoized;
import algorithms.DynamicProgrammingRecursive;
import org.junit.Before;
import org.junit.Test;

public class DynamicProgrammingTestHarness {

    private DynamicProgrammingRecursive brute;
    private DynamicProgrammingMemoized memoized;
    private DynamicProgrammingIterative iterative;

    @Before
    public void setUp() throws Exception {

        int[][] paths = new int[][] {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };

        brute = new DynamicProgrammingRecursive(paths);
        memoized = new DynamicProgrammingMemoized(paths);
        iterative = new DynamicProgrammingIterative(paths);
    }

    @Test
    public void TestRecursive() throws Exception {

        long startTime = System.currentTimeMillis();

        brute.countPaths(0,0);

        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime);
        System.out.println("elapsedTime recursive= " + elapsedTime); // 12s
    }

    @Test
    public void TestMemoized() throws Exception {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            memoized.countPaths(0,0);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime);
        System.out.println("elapsedTime memoized= " + elapsedTime); // 8s
    }

    @Test
    public void TestIterative() throws Exception {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            System.out.println(i);
            iterative.countPaths(16, 16);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime);
        System.out.println("elapsedTime memoized= " + elapsedTime); // 18s
    }
}

