package algorithms.graphs.DFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings("unchecked")
class Graph
{
    private int V;             // No. of vertices
    private LinkedList[] adj;  // Adjacency List

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int v)
    {
        boolean visited[] = new boolean[V];

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(v);

        visited[v] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");

            Iterator<Integer> i = adj[current].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n]) {
                    stack.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    // based on https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
}