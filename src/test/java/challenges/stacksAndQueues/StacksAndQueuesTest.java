package challenges.stacksAndQueues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StacksAndQueuesTest {

    private MinStack minStack;

    @Before
    public void SetUp() {
        minStack = new MinStack();
    }

    @Test
    public void MinStack() {
        // Challenge: Design a stack which, in addition to push and pop, has a function
        // 'min' which returns the minimum element? Push, pop and min should all operate in
        // O(1) time.

        minStack.push(5);
        minStack.push(6);
        minStack.push(3);
        minStack.push(7);
        Assert.assertEquals(3, minStack.min());
        minStack.pop();
        Assert.assertEquals(3, minStack.min());
        minStack.pop();
        Assert.assertEquals(5, minStack.min());
    }

    @Test
    public void StackOfPlates() {
        //
        // Challenge: Imagine you have a stack of plates. If the plates get too high,
        // they will topple over. So what you need to do is design a Stack such that
        // when the Stack reaches some threshold, it creates a new Stack to hold the new
        // items.
        // To the outside world it should appear that there is only one stack.
        // But behind the scenes there should be multiple.
        //

        StackOfPlates plates = new StackOfPlates(3);
        plates.push(1);
        plates.push(2);
        plates.push(3);
        plates.push(4);
        plates.push(5);
        Assert.assertEquals(5, plates.pop());
        Assert.assertEquals(4, plates.pop());
        Assert.assertEquals(3, plates.pop());
        Assert.assertEquals(2, plates.pop());
        Assert.assertEquals(1, plates.pop());
    }

}
