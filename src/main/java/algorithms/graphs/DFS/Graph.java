package algorithms.graphs.DFS;

import java.util.*;

@SuppressWarnings("unchecked")
class Graph
{
    private int V;             // No. of vertices
    private LinkedList<Integer>[] adj;  // Adjacency List
    private Stack<Integer> stack = new Stack<Integer>();
    private Set<Integer> visited = new HashSet<Integer>();

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
        System.out.println(v);
        visited.add(v);
        for(int i=0; i < adj[v].size(); i++) {
            Integer vertice = adj[v].get(i);
            if(!visited.contains(vertice)) {
                stack.add(vertice);
                visited.add(vertice);
            }
        }

        if(!stack.isEmpty())
            DFS(stack.pop());
    }
}