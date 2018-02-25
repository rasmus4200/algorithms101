package algorithms;

import org.junit.Assert;
import org.junit.Test;

public class MaxIntHeapTest {

    private MaxIntHeap maxHeap;

    @Test
    public void ExtractMax() throws Exception {
        maxHeap = new MaxIntHeap();
        maxHeap.insert(42);
        maxHeap.insert(29);
        maxHeap.insert(18);

        // Insert(35)
        maxHeap.insert(35);



        // Test insert
        Assert.assertEquals(42, maxHeap.items[0]);
        Assert.assertEquals(35, maxHeap.items[1]);
        Assert.assertEquals(18, maxHeap.items[2]);
        Assert.assertEquals(29, maxHeap.items[3]);

        // Text extract max
        Assert.assertEquals(42, maxHeap.extractMax());
        Assert.assertEquals(35, maxHeap.extractMax());
        Assert.assertEquals(29, maxHeap.extractMax());
        Assert.assertEquals(18, maxHeap.extractMax());

        maxHeap.print();
    }

    @Test
    public void ExtractMaxBigger() throws Exception {
        maxHeap = new MaxIntHeap();
        maxHeap.insert(42);
        maxHeap.insert(29);
        maxHeap.insert(18);
        maxHeap.insert(14);
        maxHeap.insert(7);
        maxHeap.insert(18);
        maxHeap.insert(12);
        maxHeap.insert(11);
        maxHeap.insert(13);

        Assert.assertEquals(42, maxHeap.extractMax());
        Assert.assertEquals(29, maxHeap.extractMax());
        Assert.assertEquals(18, maxHeap.extractMax());
        Assert.assertEquals(18, maxHeap.extractMax());
        Assert.assertEquals(14, maxHeap.extractMax());
        Assert.assertEquals(13, maxHeap.extractMax());
        Assert.assertEquals(12, maxHeap.extractMax());
        Assert.assertEquals(11, maxHeap.extractMax());
        Assert.assertEquals(7, maxHeap.extractMax());
    }

}
