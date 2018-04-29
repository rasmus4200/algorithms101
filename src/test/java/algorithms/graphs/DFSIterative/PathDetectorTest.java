package algorithms.graphs.DFSIterative;

import org.junit.Assert;
import org.junit.Test;

public class PathDetectorTest {

    @Test
    public void HasPath() throws Exception {
        PathDetector g = new PathDetector(8);

        g.addEdge(0, 1);
        g.addEdge(1, 4);
        g.addEdge(4, 6);
        g.addEdge(1, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 2);
        g.addEdge(2, 7);
        g.addEdge(0, 3); // this edge missed! naive :)


        System.out.println("Depth First Search HasPath:");

        g.DFS(0, 0);
//        Assert.assertTrue(g.hasPath(0, 1));
//        Assert.assertTrue(g.hasPath(0, 4));
//        Assert.assertTrue(g.hasPath(0, 6));
//        Assert.assertTrue(g.hasPath(0, 5));
//        Assert.assertTrue(g.hasPath(0, 3));
//        Assert.assertTrue(g.hasPath(0, 2));
//        Assert.assertTrue(g.hasPath(0, 7));
//
//        Assert.assertFalse(g.hasPath(4, 7));
//        Assert.assertFalse(g.hasPath(3, 7));
//        Assert.assertFalse(g.hasPath(6, 0));
    }
}
