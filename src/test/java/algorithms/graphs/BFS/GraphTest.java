package algorithms.graphs.BFS;

import org.junit.Before;
import org.junit.Test;


public class GraphTest {

    private Graph g;

    @Before
    public void SetUp() throws Exception {
        g = new Graph(4);
    }

    @Test
    public void BreadFirstSearch() throws Exception {

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }

}
