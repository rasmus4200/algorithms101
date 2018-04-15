package algorithms.graphs.DFSRecursive;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class PathFinderTest {

    @Test
    public void FindPath() throws Exception {
        PathFinder g = new PathFinder(8);

        g.addEdge(0, 1);
        g.addEdge(1, 4);
        g.addEdge(4, 6);
        g.addEdge(1, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 2);
        g.addEdge(2, 7);
        g.addEdge(0, 3); // this edge missed! naive :)


        System.out.println("Depth First Search Find Path:");

        Assert.assertEquals("[0, 1, 5, 2, 7]", g.findPath(0, 7));
        Assert.assertEquals("[0, 1, 5, 2]", g.findPath(0, 2));
        Assert.assertEquals("[0, 1]", g.findPath(0, 1));
        Assert.assertEquals("[5, 2]", g.findPath(5, 2));
        Assert.assertEquals(null, g.findPath(2, 5));
    }

    @Test public void HasPath() throws Exception {
        // Say we have a Stack of vertices that we have travelled
        PathFinder g = new PathFinder(8);
        Stack<Integer> path = new Stack<Integer>();

        path.add(0);
        path.add(1);
        path.add(5);
        path.add(2);
        path.add(7);

        // Create a method that returns the contents of the Stack
        // in the form of a string
        Assert.assertTrue(g.hasPath(path, 0, 7));
        Assert.assertTrue(g.hasPath(path, 1, 5));
        Assert.assertFalse(g.hasPath(path, 2, 5));
    }
}
