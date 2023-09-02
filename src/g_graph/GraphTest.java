package g_graph;

public class GraphTest {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Graph Add Vertex");
        System.out.println("-----------------------");
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.print();

        System.out.println();
        System.out.println("Graph Add Edge");
        System.out.println("-----------------------");
        graph.addEdge("A", "B");
        graph.print();


        System.out.println();
        System.out.println("Graph Remove Edge");
        System.out.println("-----------------------");
        graph.removeEdge("A", "B");
        graph.print();

        System.out.println();
        System.out.println("Graph Remove Vertex");
        System.out.println("-----------------------");
        graph.removeVertex("C");
        graph.print();
    }
}
