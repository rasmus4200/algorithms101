package algorithms;

import algorithms.FibonacciMemoized;
import algorithms.FibonacciNaive;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

    private FibonacciNaive naive;
    private FibonacciMemoized memo;

    @Before
    public void setUp() throws Exception {
        naive = new FibonacciNaive();
        memo = new FibonacciMemoized();
    }

    @Test
    public void Naive() throws Exception {
        Assert.assertEquals(0, naive.fib(0));
        Assert.assertEquals(1, naive.fib(1));
        Assert.assertEquals(1, naive.fib(2));
        Assert.assertEquals(2, naive.fib(3));
        Assert.assertEquals(3, naive.fib(4));
        Assert.assertEquals(5, naive.fib(5));
        Assert.assertEquals(8, naive.fib(6));
        Assert.assertEquals(13, naive.fib(7));
        Assert.assertEquals(21, naive.fib(8));
    }

    @Test
    public void Memoized() throws Exception {
        Assert.assertEquals(0, memo.fib(0));
        Assert.assertEquals(1, memo.fib(1));
        Assert.assertEquals(1, memo.fib(2));
        Assert.assertEquals(2, memo.fib(3));
        Assert.assertEquals(3, memo.fib(4));
        Assert.assertEquals(5, memo.fib(5));
        Assert.assertEquals(8, memo.fib(6));
        Assert.assertEquals(13, memo.fib(7));
        Assert.assertEquals(21, memo.fib(8));
    }

    @Test
    public void RecordTimeNaive() throws Exception {
        long startTime = System.currentTimeMillis();
        naive.fib(30);
        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime) / 1000;
        System.out.println("elapsedTime = " + elapsedTime); // 19s
    }

    @Test
    public void RecordTimeMemoized() throws Exception {
        long startTime = System.currentTimeMillis();
        memo.fib(1000);
        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime) / 1000;
        System.out.println("elapsedTime = " + elapsedTime); // 20s
    }

}
