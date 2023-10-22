import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V; // No. of vertices
    private int E;
    private LinkedList<Integer> adj[]; // Adjacency Lists

    // Constructor
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adj[v]) {
            degree += 1;
        }
        return degree;
    }

    public static void print(Graph g) {
        for (int v = 0; v < g.V; v += 1){
            for (int w : g.adj[v]) {
                System.out.println(v + " - " + w);
            }
        }
    }
    // prints BFS traversal from a given source s
    void bfs(int s) {
        // Mark all the vertices as not visited (By default set as false)
        boolean marked[] = new boolean[V];
        // Create a queue for BFS
        LinkedList<Integer> fringe = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        marked[s] = true;
        fringe.add(s);

        while (!fringe.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = fringe.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s.
            // If an adjacent has not been visited, then mark it visited and enqueue it
            for (int w : adj[s]) {
                if (!marked[w]) {
                    fringe.add(w);
                    marked[w] = true;
                }
            }
//            Iterator<Integer> i = adj[s].listIterator();
//            while (i.hasNext()) {
//                int n = i.next();
//                if (!marked[n]) {
//                    marked[n] = true;
//                    fringe.add(n);
//                }
//            }
        }
    }
}