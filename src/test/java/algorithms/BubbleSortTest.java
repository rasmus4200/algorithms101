package algorithms;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Before
    public void SetUp() throws Exception {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void Sort() throws Exception {
        int[] array = {5, 1, 4, 2, 8};

        int[] sorted = bubbleSort.sort(array);

        Assert.assertEquals(1, sorted[0]);
        Assert.assertEquals(2, sorted[1]);
        Assert.assertEquals(4, sorted[2]);
        Assert.assertEquals(5, sorted[3]);
        Assert.assertEquals(8, sorted[4]);
    }

}
