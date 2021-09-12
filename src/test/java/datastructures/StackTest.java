package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack stack;

    @Before
    public void SetUp() {
        stack = new Stack();
    }

    @Test
    public void Push() {
        stack.push(15);
        stack.push(25);
        stack.push(75);

        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(75, stack.peek());
        Assert.assertEquals(false, stack.isEmpty());
    }

    @Test
    public void Pop() {
        stack.push(15);
        stack.push(25);
        stack.pop();
        stack.push(35);
        stack.pop();

        Assert.assertEquals(15, stack.peek());
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(false, stack.isEmpty());
        Assert.assertEquals(15, stack.pop());
    }
}
