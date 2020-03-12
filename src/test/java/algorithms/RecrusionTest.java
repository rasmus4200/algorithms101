package algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecrusionTest {

    private Recursion recursion;

    @Before
    public void SetUp() {
        recursion = new Recursion();
    }


    /*
    Channel formatter

    Write a recursive algorithm that strips the leading zeros off Strings of text.

    Simply strip off one zero at a time, and then recursively call yourself
    until no leading zeros from the original string are left.
     */
    @Test
    public void StripLeadingZeros() {
        Assert.assertEquals("1", recursion.stripZeros("0001"));
        Assert.assertEquals("11", recursion.stripZeros("00011"));
        Assert.assertEquals("1989", recursion.stripZeros("00001989"));
        Assert.assertEquals("VOD", recursion.stripZeros("VOD"));
    }

}
