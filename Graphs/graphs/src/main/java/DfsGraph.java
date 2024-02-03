import java.util.LinkedList;

public class DfsGraph {
    /**
     * Instance variables
     */
    // use Adjacency List to represent the graph
    private LinkedList<Integer> adjacencyList[];
    // Mark all the vertices as not visited (set as false by default in java)
    private boolean[] marked;
    /**
     * Constructor
     */
    public DfsGraph(int vertexNumber) {
        this.adjacencyList = new LinkedList[vertexNumber];
        this.marked = new boolean[vertexNumber];

        for (int i = 0; i < vertexNumber; ++i)
            adjacencyList[i] = new LinkedList();
    }

    public void addVertex(int vertexFrom, int vertexTo) {
        adjacencyList[vertexFrom].add(vertexTo);
    }

    void dfs(int v) {
        // Mark the current node as visited and print it
        marked[v] = true;
        System.out.print(v + " ");

        for (int w : this.adjacencyList[v]) {
            if (!marked[w]){
                dfs(w);
            }
        }
    }
}