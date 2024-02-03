public class Main {
    // Driver code
    public static void main(String args[])
    {
        BfsGraph g=new BfsGraph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("Following is Breadth First Traversal "+"(starting from vertex 2)");

        g.bfs(2);
//        Graph.print(g);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        DfsGraph graph = new DfsGraph(4);
        graph.addVertex(0,1);
        graph.addVertex(0,2);
        graph.addVertex(1,2);
        graph.addVertex(2,0);
        graph.addVertex(2,3);
        graph.addVertex(3,3);
        // Function call
        graph.dfs(2);
    }
}
