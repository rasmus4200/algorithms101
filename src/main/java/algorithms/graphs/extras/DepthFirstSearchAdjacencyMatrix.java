package algorithms.graphs.extras;

import java.util.ArrayList;
import java.util.Stack;

class DepthFirstSearchAdjacencyMatrix {

    // Our vertices
    private ArrayList<Node> nodes=new ArrayList<Node>();

    // Our edges
    private int[][] adjacencyMatrix;

    public DepthFirstSearchAdjacencyMatrix(ArrayList<Node> nodes, int[][] edges) {
        this.nodes = nodes;
        this.adjacencyMatrix = edges;
    }

    static class Node
    {
        int data;
        boolean visited;

        // Note: Notice how there are no neighbours ArrayList<>
        // defined here? That's because our matrix
        // is going to define the edges between our vertices

        Node(int data)
        {
            this.data=data;
        }
    }

    // find neighbors of node using adjacency matrix
    // if adjacency_matrix[i][j]==1,
    // then nodes at index i and index j are connected
    public ArrayList<Node> findNeighbours(Node node)
    {
        int nodeIndex=-1;

        ArrayList<Node> neighbours = new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).equals(node))
            {
                nodeIndex=i;
                break;
            }
        }

        if(nodeIndex!=-1)
        {
            for (int j = 0; j < adjacencyMatrix[nodeIndex].length; j++) {
                if(adjacencyMatrix[nodeIndex][j]==1)
                {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }


    // Recursive DFS
    public  void dfsRecursive(Node node)
    {
        System.out.print(node.data + " ");
        ArrayList<Node> neighbours=findNeighbours(node);
        node.visited=true;
        for (int i = 0; i < neighbours.size(); i++) {
            Node n=neighbours.get(i);
            if(n!=null && !n.visited)
            {
                dfsRecursive(n); // recursion here...
            }
        }
    }

    // Iterative DFS using stack
    public  void dfsIterativeUsingStack(Node node)
    {
        Stack<Node> stack= new Stack<Node>();
        stack.add(node);
        node.visited=true;
        while (!stack.isEmpty())
        {
            Node currentNode = stack.pop();
            System.out.print(currentNode.data + " ");

            ArrayList<Node> neighbours = findNeighbours(currentNode);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n=neighbours.get(i);
                if(n!=null &&!n.visited)
                {
                    stack.add(n);
                    n.visited=true;
                }
            }
        }
    }

    public void clearVisitedFlags()
    {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited=false;
        }
    }

}

// based on https://java2blog.com/depth-first-search-in-java/