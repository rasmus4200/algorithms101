package algorithms.graphs.BFS;

import java.util.*;

class Graph
{
    private int V;                     // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists
    private Queue<Integer> que = new LinkedList<Integer>();
    private Set<Integer> visited = new HashSet<Integer>();

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        System.out.println(s);
        visited.add(s);
        for(int i=0; i < adj[s].size(); i++) {
            Integer vertice = adj[s].get(i);
            if(!visited.contains(vertice)) {
                que.add(vertice);
                visited.add(vertice);
            }
        }

        if(!que.isEmpty())
            BFS(que.poll());
    }
}