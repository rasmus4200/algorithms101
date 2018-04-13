package algorithms.graphs.DFSRecursive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings("unchecked")
class NaivePath
{
    private int V;             // No. of vertices
    private LinkedList[] adj;  // Adjacency List

    NaivePath(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[], Stack tracker)
    {
        visited[v] = true;
        tracker.add(v);
        System.out.print(v + " ");
        System.out.println("Adding = " + tracker);

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited, tracker);
        }

        // Check to see if we have exhausted all paths
        Iterator<Integer> j = adj[v].listIterator();
        if (allNeighborsVisited(j, visited)) {
            System.out.println("All visited: Popping " + v);
            tracker.pop();
        }
    }

    private boolean allNeighborsVisited(Iterator<Integer> j, boolean visited[]) {
        while (j.hasNext())
        {
            int n = j.next();
            if (!visited[n]) {
                return false;
            }
        }
        return true;
    }

    void DFS(int v)
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Setup our tracker
        Stack tracker = new Stack<Integer>();

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited, tracker);
    }

    // based on https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
}