package algorithms.graphs.DFSRecursive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings("unchecked")
class Graph
{
    private int V;             // No. of vertices
    private LinkedList[] adj;  // Adjacency List

    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v,boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v)
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print findPath traversal
        DFSUtil(v, visited);
    }

    // based on https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
}