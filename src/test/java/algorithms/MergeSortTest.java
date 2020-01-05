package algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private MergeSort mergeSort;

    @Before
    public void SetUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void Sort() {

        int arr[] = {4, 7, 14, 1, 3, 9, 17};

        mergeSort.sort(arr);

        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(3, arr[1]);
        Assert.assertEquals(4, arr[2]);
        Assert.assertEquals(7, arr[3]);
        Assert.assertEquals(9, arr[4]);
        Assert.assertEquals(14, arr[5]);
        Assert.assertEquals(17, arr[6]);

        System.out.println("\nSorted array");
        mergeSort.printArray(arr);
    }

}
