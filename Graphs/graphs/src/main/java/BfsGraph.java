import java.util.LinkedList;

public class BfsGraph {
    /**
     * Instance variables
     */
    private int verticeNumber;
    private LinkedList<Integer> adjacencyList[]; // use Adjacency List to represent the graph

    /**
     * Constructor
     * @param verticeNumber
     */
    public BfsGraph(int verticeNumber) {
        this.verticeNumber = verticeNumber;
        this.adjacencyList = new LinkedList[verticeNumber];

        for (int i = 0; i < verticeNumber; ++i) //what's this ++i
            adjacencyList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int edgeFrom, int edgeTo) {
        adjacencyList[edgeFrom].add(edgeTo);
    }

//    public static int degree(BfsGraph g, int v) {
//        int degree = 0;
//        for (int w : g.adj[v]) {
//            degree += 1;
//        }
//        return degree;
//    }

//    public static void print(BfsGraph g) {
//        for (int v = 0; v < g.verticeNumber; v += 1){
//            for (int w : g.adj[v]) {
//                System.out.println(v + " - " + w);
//            }
//        }
//    }

    // run BFS traversal from a given source s
    void bfs(int sourceVertex) {
        // Mark all the vertices as not visited (By default set as false)
        boolean[] marked = new boolean[verticeNumber];
        // Create a queue for BFS
        LinkedList<Integer> fringe = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        marked[sourceVertex] = true;
        fringe.add(sourceVertex);

        while (!fringe.isEmpty()) {
            // Take last inserted vertex from queue
            sourceVertex = fringe.poll();
            System.out.print(sourceVertex + " ");

            // Get all adjacent vertices of the dequeued vertex s.
            // If an adjacent has not been visited, then mark it visited and enqueue it
            for (int adjacentVertex : adjacencyList[sourceVertex]) {
                if (!marked[adjacentVertex]) {
                    fringe.add(adjacentVertex);
                    marked[adjacentVertex] = true;
                }
            }
        }
    }
}