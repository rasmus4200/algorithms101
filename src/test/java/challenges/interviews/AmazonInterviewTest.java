package challenges.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AmazonInterviewTest {

    private AmazonArrayMerger merger;

    @Before
    public void SetUp() {
        merger = new AmazonArrayMerger();
    }

    @Test
    public void Merge() {

        int[] L1 = { 2,5,8,11,14 };
        int[] L2 = { 1,3,5,7 };

        int[] result = merger.merge(L1, L2);
        int[] expected = { 1,2,3,5,5,7,8,11,14 };

        Assert.assertTrue(Arrays.equals(expected, result));
    }

    @Test
    public void L1Empty() {

        int[] L1 = { };
        int[] L2 = { 1,3,5,7 };

        int[] result = merger.merge(L1, L2);
        int[] expected = { 1,3,5,7 };

        Assert.assertTrue(Arrays.equals(expected, result));
    }

    @Test
    public void L2Empty() {

        int[] L1 = { 2,5,8,11,14 };
        int[] L2 = { };

        int[] result = merger.merge(L1, L2);
        int[] expected = { 2,5,8,11,14 };

        Assert.assertTrue(Arrays.equals(expected, result));
    }

    @Test
    public void NoOverlap() {

        int[] L1 = { 1,2,3 };
        int[] L2 = { 4,5,6 };

        int[] result = merger.merge(L1, L2);
        int[] expected = { 1,2,3,4,5,6 };

        Assert.assertTrue(Arrays.equals(expected, result));
    }

    @Test
    public void Merge2() {

        int[] L1 = { 1,7,9 };
        int[] L2 = { 4,5,6 };

        int[] result = merger.merge(L1, L2);
        int[] expected = { 1,4,5,6,7,9 };

        Assert.assertTrue(Arrays.equals(expected, result));
    }

}
