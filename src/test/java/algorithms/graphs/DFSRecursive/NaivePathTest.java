package algorithms.graphs.DFSRecursive;

import org.junit.Test;

public class NaivePathTest {


    @Test
    public void Recursive() throws Exception {
        NaivePath g = new NaivePath(8);

        g.addEdge(0, 1);
        g.addEdge(1, 4);
        g.addEdge(4, 6);
        g.addEdge(1, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 2);
        g.addEdge(2, 7);


        System.out.println("Depth First Search Recursive:");

        g.DFS(0);
    }
}
