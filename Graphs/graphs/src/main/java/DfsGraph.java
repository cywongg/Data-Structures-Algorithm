import java.util.LinkedList;

public class DfsGraph {
    /**
     * Instance variables
     */
    private int verticeNumber;
    private LinkedList<Integer> adjacencyList[]; // use Adjacency List to represent the graph

    /**
     * Constructor
     * @param verticeNumber
     */
    public DfsGraph(int verticeNumber) {
        this.verticeNumber = verticeNumber;
        this.adjacencyList = new LinkedList[verticeNumber];

        for (int i = 0; i < verticeNumber; ++i) //what's this ++i
            adjacencyList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int edgeFrom, int edgeTo) {
        adjacencyList[edgeFrom].add(edgeTo);
    }

    // The function to do DFS traversal.
    // It uses recursive DFSUtil()

    void dfs(int sourceVertex) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean[] marked = new boolean[verticeNumber];

        // Call the recursive helper function to print DFS traversal
        dfs(sourceVertex, marked);
    }

    // A function used by DFS
    void dfs(int v, boolean marked[]) {
        // Mark the current node as visited and print it
        marked[v] = true;
        System.out.print(v + " ");

        for (int w : this.adjacencyList[v]) {
            if (!marked[w]){
                dfs(w, marked);
            }
        }
    }
}
