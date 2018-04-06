package algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDepthFirstSearch {

    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    GraphDepthFirstSearch(int v)
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

    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited); // Dive deeper - depth first
        }
    }

    void DFS(int v)
    {
        // Track which vertices we have visited (default false)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
}

// based on https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/