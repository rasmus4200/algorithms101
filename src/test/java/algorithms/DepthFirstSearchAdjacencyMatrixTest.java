package algorithms;

import algorithms.DepthFirstSearchAdjacencyMatrix.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class DepthFirstSearchAdjacencyMatrixTest {

    private Node node10;
    private Node node20;
    private Node node30;
    private Node node40;
    private Node node50;
    private Node node60;
    private Node node70;

    private DepthFirstSearchAdjacencyMatrix dfs;


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

        // Collect them in a list
        ArrayList<Node> nodes=new ArrayList<Node>();

        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);

        // Define our edges in an Adjacency Matrix
        int[][] edges = {
                {0,1,1,0,0,0,0},  // Node 1: 40
                {0,0,0,1,0,0,0},  // Node 2 :10
                {0,1,0,1,1,1,0},  // Node 3: 20
                {0,0,0,0,1,0,0},  // Node 4: 30
                {0,0,0,0,0,0,1},  // Node 5: 60
                {0,0,0,0,0,0,1},  // Node 6: 50
                {0,0,0,0,0,0,0},  // Node 7: 70
        };

        dfs = new DepthFirstSearchAdjacencyMatrix(nodes, edges);

    }

    @Test
    public void DepthFirstSearchRecursive_With_Adjacency_Matrix() throws Exception {
        System.out.println("The DFS traversal recursively with Adjacency Matrix:");
        dfs.clearVisitedFlags();
        dfs.dfsRecursive(node40);
    }

    @Test
    public void DepthFirstSearchIterative_With_Adjacency_Matrix() throws Exception {
        System.out.println("The DFS traversal iteratively with Adjacency Matrix:");
        dfs.dfsIterativeUsingStack(node40);
    }

}
