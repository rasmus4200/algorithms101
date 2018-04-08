package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DepthFirstSearch {

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

        public String toString() {
            return Integer.toString(data);
        }
    }

    void recursivelyFrom(Node node) {
        System.out.print(node.data + " ");

        node.visited = true;
        List<Node> neighbours = node.getNeighbours();

        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                recursivelyFrom(n);
            }
        }
    }

    void iterativelyFrom(Node node) {

        // Setup the starting node
        Stack<Node> stack = new Stack<Node>();
        stack.add(node);

        node.visited = true;

        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.data + " ");

            List<Node> neighbours = element.getNeighbours();
            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    n.visited = true;
                    stack.add(n);
                }
            }
        }
    }
}