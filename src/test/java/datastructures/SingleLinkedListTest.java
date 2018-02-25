package datastructures;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

    private SingleLinkedList sll;

    @Before
    public void setUp() throws Exception {
        sll = new SingleLinkedList<Integer>();
    }

    @Test
    public void InitialState() throws Exception {
        Assert.assertNull(sll.head);
        Assert.assertEquals(0, sll.size);
    }

    @Test
    public void lastIndexOf() throws Exception {
        sll.push(99);
        sll.push(100);
        sll.push(101);
        Assert.assertEquals(2, sll.lastIndexOf(99));
        Assert.assertEquals(1, sll.lastIndexOf(100));
        Assert.assertEquals(0, sll.lastIndexOf(101));
    }

    @Test
    public void peek() throws Exception {
        sll.push(99);
        Assert.assertEquals(99, sll.peek());
    }

    @Test
    public void peekEmpty() throws Exception {
        Assert.assertEquals(null, sll.peek());
    }

    @Test
    public void pushAndPop() throws Exception {
        sll.push(99);
        sll.push(100);
        sll.push(101);
        Assert.assertEquals(101, sll.pop());
        Assert.assertEquals(100, sll.pop());
        Assert.assertEquals(99, sll.pop());
    }

    @Test
    public void popEmptyList() throws Exception {
        Assert.assertNull(sll.pop());
    }

    @Test
    public void remove() throws Exception {
        sll.push(99);
        sll.push(100);
        sll.push(101);

        Assert.assertTrue(sll.remove(101));
        Assert.assertEquals(100, sll.peek());

        Assert.assertTrue(sll.remove(100));
        Assert.assertEquals(99, sll.peek());

        Assert.assertTrue(sll.remove(99));
        Assert.assertEquals(null, sll.peek());
    }

    @Test
    public void pushSize() throws Exception {
        Assert.assertEquals(0, sll.size);
        sll.push(99);
        Assert.assertEquals(1, sll.size);
        sll.push(100);
        Assert.assertEquals(2, sll.size);
    }

    @Test
    public void popSize() throws Exception {
        sll.push(99);
        sll.push(100);
        Assert.assertEquals(2, sll.size);
        sll.pop();
        Assert.assertEquals(1, sll.size);
    }

    @Test
    public void removeSize() throws Exception {
        sll.push(99);
        sll.push(100);
        Assert.assertEquals(2, sll.size);
        sll.remove(100);
        Assert.assertEquals(1, sll.size);
    }

    @Test
    public void setIndex() throws Exception {
        sll.push(99);
        sll.push(100);
        sll.push(101);

        sll.set(0, 49);
        sll.set(1, 50);
        sll.set(2, 51);

        Assert.assertEquals(0, sll.lastIndexOf(49));
        Assert.assertEquals(1, sll.lastIndexOf(50));
        Assert.assertEquals(2, sll.lastIndexOf(51));
    }

//    @Test
//    public void realLinkedList() throws Exception {
//
//        // Here are some tests written against the Java datastructures.LinkedList class
//
//        LinkedList<Integer> linkedList = new LinkedList<Integer>();
//        linkedList.push(99);
//        linkedList.push(100);
//        linkedList.push(101);
//        Assert.assertEquals(2, linkedList.lastIndexOf(99));
//        Assert.assertEquals(1, linkedList.lastIndexOf(100));
//        Assert.assertEquals(0, linkedList.lastIndexOf(101));
//
//        linkedList.peek();
//    }
}
