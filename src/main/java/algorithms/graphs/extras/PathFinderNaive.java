package algorithms.graphs.extras;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PathFinderNaive {

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
        Stack tracker = new Stack<Integer>();
        recursiveUtils(node, tracker);
    }

    void recursiveUtils(Node node, Stack tracker) {
        tracker.add(node);
        System.out.print(node.data + " ");
        System.out.println("Adding " + tracker);
        node.visited = true;

        List<Node> neighbours = node.getNeighbours();

        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                recursiveUtils(n, tracker);
            }
        }

        // check to see if we have exhausted all paths
        if (neighbours.isEmpty() || allNodesVisited(neighbours)) {
            System.out.println("Empty or all visited: Popping " + node.data + " from path");
            tracker.pop();
        }
    }

    public boolean allNodesVisited(List<Node> neighbours) {
        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                return false;
            }
        }
        return true;
    }

    // Iterative pops the stacks as you descend down...
    // So you can't track with iterative...
}