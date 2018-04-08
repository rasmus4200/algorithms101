package algorithms;

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

            Node currentNode = queue.remove();
            System.out.print(currentNode.data + " ");

            List<Node> neighbours = currentNode.getNeighbours();

            // For each neighbour
            for (Node n : neighbours) {
                // If we haven't visited them before...
                if (n != null && !n.visited) {
                    // Add to end of queue so we can visit later
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }
}