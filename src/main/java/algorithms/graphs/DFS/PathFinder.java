package algorithms.graphs.DFS;

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

    PathFinder(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int from, int to)
    {
        Stack<Integer> tracker = new Stack<Integer>();
        boolean visited[] = new boolean[V];

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(from);

        visited[from] = true;

        while (!stack.isEmpty()) {

            int current = stack.pop();
            visited[current] = true;
            tracker.add(current);
            System.out.print(current + " ");
            System.out.println("Adding = " + tracker);

            // Check for path
            if (hasPath(tracker, startingFrom, to) && path == null) {
                path = tracker.toString();
            }

            // If we have exhausted all paths...
            Iterator<Integer> j = adj[current].listIterator();
            if (allNeighborsVisited(j, visited)) {
                // Pop until we find a node with neighbors
                // that haven't been visited
                popTillYouDrop(tracker, visited);
            }

            Iterator<Integer> i = adj[current].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n]) {
                    stack.add(n);
                }
            }
        }
    }

    private void popTillYouDrop(Stack<Integer> tracker, boolean[] visited) {
        if (tracker.isEmpty()) return;

        int current = tracker.peek();

        Iterator<Integer> j = adj[current].listIterator();

        if (allNeighborsVisited(j, visited)) {
            tracker.pop();
            System.out.println("Popping = " + current);
            popTillYouDrop(tracker, visited);
        }
    }

    private boolean allNeighborsVisited(Iterator<Integer> neighbors,
                                        boolean visited[]) {
        while (neighbors.hasNext())
        {
            int n = neighbors.next();
            if (!visited[n]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasPath(Stack<Integer> path, int from, int to) {
        if (path.contains(from) && path.contains(to)) {
            if (path.indexOf(from) < path.indexOf(to)) { // from must be before
                return true;
            }
        }
        return false;
    }

    String findPath(int from, int to)
    {
        startingFrom = from;
        path = null;
        DFS(from, to);

        return path;
    }
}