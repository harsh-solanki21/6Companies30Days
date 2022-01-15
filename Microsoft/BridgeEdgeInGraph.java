package Microsoft;

import java.util.Iterator;
import java.util.LinkedList;

public class BridgeEdgeInGraph {

    private int V;  // No. of vertices

    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    // Constructor
    @SuppressWarnings("unchecked")
    BridgeEdgeInGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void bridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext()) {
            int v = i.next();

            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u])
                    System.out.println(u + " " + v);
            }
            else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }

    void bridge() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                bridgeUtil(i, visited, disc, low, parent);
        }

    }

    public static void main(String args[]) {
        System.out.println("Bridges in Graph");
        BridgeEdgeInGraph g = new BridgeEdgeInGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.bridge();
    }

}
