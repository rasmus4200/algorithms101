package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DepthFirstSearchIterative {

    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours; // Adjacency list

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
        Stack stack = new Stack<Integer>();
        recursiveUtils(node, stack);
    }

    void recursiveUtils(Node node, Stack stack) {
        stack.add(node);
        System.out.print(node.data + " ");
        System.out.println("Add " + node.data + " to stack = " + stack);
        node.visited = true;
        List<Node> neighbours = node.getNeighbours();

        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                recursiveUtils(n, stack);
            }
        }

        // if no neighbours or all neighbours visited
        if (neighbours.isEmpty() || allNodesVisited(neighbours)) {
            System.out.println("Popping " + node.data + " from stack");
            stack.pop();
        }
    }

    public boolean allNodesVisited(List<Node> neighbours) {
        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                System.out.println("NOT all visited");
                return false;
            }
        }
        System.out.println("ALL visited");
        return true;
    }


    void searchFrom(Node node) {

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