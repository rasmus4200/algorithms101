package algorithms.graphs.DFSRecursive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings("unchecked")
class PathDetector
{
    private int V;             // No. of vertices
    private LinkedList[] adj;  // Adjacency List
    private boolean pathFound;

    PathDetector(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean hasPath(int from, int to)
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Reset path found
        pathFound = false;

        // Setup our tracker
        Stack tracker = new Stack<Integer>();

        // Call the recursive helper function to print findPath traversal
        DFSUtil(from, to, visited, tracker);

        return pathFound;
    }

    void DFSUtil(int from, int to, boolean visited[], Stack tracker)
    {
        tracker.add(from);
        System.out.print(from + " ");
        System.out.println("Adding = " + tracker);

        visited[from] = true;

        // Check for path
        if (tracker.contains(to)) {
            pathFound = true;
        }

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[from].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, to, visited, tracker);
        }

        // Check to see if we have exhausted all paths
        Iterator<Integer> j = adj[from].listIterator();
        if (allNeighborsVisited(j, visited)) {
            System.out.println("All visited: Popping " + from);
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

}