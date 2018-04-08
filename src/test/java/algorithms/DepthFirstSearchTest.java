package algorithms;

import org.junit.Before;
import org.junit.Test;
import algorithms.DepthFirstSearch.Node;

public class DepthFirstSearchTest {

    private Node node10;
    private Node node20;
    private Node node30;
    private Node node40;
    private Node node50;
    private Node node60;
    private Node node70;

    private DepthFirstSearch dfs;

    @Before
    public void SetUp() throws Exception {

        // Define our vertices
        node40 = new Node(40);
        node10 = new Node(10);
        node20 = new Node(20);
        node30 = new Node(30);
        node60 = new Node(60);
        node50 = new Node(50);
        node70 = new Node(70);

        // Setup our edges
        node40.addNeighbour(node10);
        node40.addNeighbour(node20);
        node10.addNeighbour(node30);
        node20.addNeighbour(node10);
        node20.addNeighbour(node30);
        node20.addNeighbour(node60);
        node20.addNeighbour(node50);
        node30.addNeighbour(node60);
        node60.addNeighbour(node70);
        node50.addNeighbour(node70);

        dfs = new DepthFirstSearch();
    }

    @Test
    public void DepthFirstSearchRecursive() throws Exception {
        System.out.println("The DFS traversal iterative");
        dfs.recursivelyFrom(node40);
    }

    @Test
    public void DepthFirstSearchIterative() throws Exception {
        System.out.println("The DFS traversal of the graph using recursion ");
        dfs.iterativelyFrom(node40);
    }
}
