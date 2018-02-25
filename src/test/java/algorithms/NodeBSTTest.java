package algorithms;

import algorithms.NodeBST;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeBSTTest {

    private NodeBST node;

    @Before
    public void setUp() throws Exception {
        node = new NodeBST(10);
        node.insert(5);
        node.insert(15);
        node.insert(8);
    }

    @Test
    public void Contains() throws Exception {
        Assert.assertTrue(node.contains(5));
        Assert.assertTrue(node.contains(15));
        Assert.assertTrue(node.contains(8));
    }

    @Test
    public void PrintOrder() throws Exception {
        node.printInOrder();
    }
}
