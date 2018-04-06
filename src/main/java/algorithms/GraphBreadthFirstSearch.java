package algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBreadthFirstSearch {

    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    GraphBreadthFirstSearch(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int edge)
    {
        adj[v].add(edge);
    }

    // Prints BFS traversal from a given source s
    void BFS(int s) {

        // Unlike trees, graphs may contain cycles.
        // So to prevent circling back and visiting the same vertex twice
        // we can track with vertices we've visited with this array
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from head of queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

// based on https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/