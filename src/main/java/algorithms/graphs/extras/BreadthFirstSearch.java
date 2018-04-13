package algorithms.graphs.extras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BreadthFirstSearch {

    private Queue<Node> queue;

    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int data) {
            this.data = data;
            this.neighbours = new ArrayList<Node>();
        }

        void addNeighbour(Node node) {
            this.neighbours.add(node);
        }

        List<Node> getNeighbours() {
            return neighbours;
        }
    }

    BreadthFirstSearch() {
        queue = new LinkedList<Node>();
    }

    public void searchFrom(Node node) {

        // Set our starting place
        queue.add(node);
        node.visited = true;

        // Starting visiting our neighbours
        while (!queue.isEmpty()) {

            // Pop the next nearest neighbour off the queue
            Node currentNode = queue.remove();
            System.out.print(currentNode.data + " ");

            // Get their neighbours
            List<Node> neighbours = currentNode.getNeighbours();

            // For each neighbour
            for (Node n : neighbours) {
                // We haven't visited yet
                if (n != null && !n.visited) {
                    // Add to end of queue so we can visit later
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }
}