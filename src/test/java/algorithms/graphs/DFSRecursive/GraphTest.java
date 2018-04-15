package algorithms.graphs.DFSRecursive;

import org.junit.Test;

public class GraphTest {


    @Test
    public void Recursive() throws Exception {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Search HasPath:");

        g.DFS(2);
    }

}
