package algorithms.graphs.BFS;

import java.util.*;

class Graph
{
    private int V;                     // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited (false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        System.out.println("Starting at " + s);
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.println("De-queueing " + s);
//            System.out.print(s + " ");

            // Get all adjacent vertices of the de-queued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    System.out.println("Queueing " + n);
                    queue.add(n);
                }
            }
        }
    }
}

// based on https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/