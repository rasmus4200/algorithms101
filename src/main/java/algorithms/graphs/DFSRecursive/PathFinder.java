package algorithms.graphs.DFSRecursive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings("unchecked")
class PathFinder
{
    private int V;             // No. of vertices
    private LinkedList[] adj;  // Adjacency List
    private String path;
    private int startingFrom;

    PathFinder(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int from, int to, boolean visited[], Stack tracker)
    {
        visited[from] = true;
        tracker.add(from);
        System.out.print(from + " ");
        System.out.println("Adding = " + tracker);

        // Check for path
        if (hasPath(tracker, startingFrom, to) && path == null) {
            path = tracker.toString();
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

    String findPath(int from, int to)
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Setup our tracker
        Stack tracker = new Stack<Integer>();

        // Track where we started from
        startingFrom = from;

        // Reset our path
        path = null;

        // Traverse graph
        DFSUtil(from, to, visited, tracker);

        return path;
    }

    public boolean hasPath(Stack<Integer> path, int from, int to) {
        if (path.contains(from) && path.contains(to)) {
            if (path.indexOf(from) < path.indexOf(to)) {
                return true;
            }
        }
        return false;
    }
}