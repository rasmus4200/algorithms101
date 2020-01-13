package algorithms.graphs.DFS;

import java.util.LinkedList;

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

    }

    void DFS(int v)
    {

    }
}