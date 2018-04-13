package algorithms.graphs.extras;

import algorithms.graphs.extras.PathFinderNaive.Node;
import org.junit.Before;
import org.junit.Test;

public class PathFinderNaiveTest {

    private PathFinderNaive naive;

    @Before
    public void SetUp() throws Exception {
        naive = new PathFinderNaive();
    }

    @Test
    public void PathFinderNaive() throws Exception {

        // Challenge: See if you can detect a path
        // Stub it out
        // ask them to fill in

        // Todo: Change method signature below to take a from and a to

        // Note: Explain how you don't make all edges here bi-directional
        // else there will always be a path and never a dead end
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node0.addNeighbour(node1);
        node1.addNeighbour(node4);
        node1.addNeighbour(node5);
        node2.addNeighbour(node7);
        node4.addNeighbour(node6);
        node5.addNeighbour(node3);
        node5.addNeighbour(node2);

        naive.recursivelyFrom(node0);
    }

}
