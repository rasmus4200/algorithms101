package algorithms;

import algorithms.MinIntHeap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinIntHeapTest {

    private MinIntHeap minHeap;

    @Before
    public void setUp() throws Exception {
        minHeap = new MinIntHeap();
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);
    }

    @Test
    public void Insert() throws Exception {
        // Remember: The array walks top down / left to right
        Assert.assertEquals(1, minHeap.items[0]);
        Assert.assertEquals(3, minHeap.items[1]);
        Assert.assertEquals(2, minHeap.items[2]);
        Assert.assertEquals(6, minHeap.items[3]);
        Assert.assertEquals(4, minHeap.items[4]);
        Assert.assertEquals(5, minHeap.items[5]);
    }

    @Test
    public void ExtractMin() throws Exception {
        Assert.assertEquals(1, minHeap.extractMin());
        Assert.assertEquals(2, minHeap.extractMin());
        Assert.assertEquals(3, minHeap.extractMin());
        Assert.assertEquals(4, minHeap.extractMin());
        Assert.assertEquals(5, minHeap.extractMin());
        Assert.assertEquals(6, minHeap.extractMin());
    }
}
