package g_graph;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<String>> adjcencyList = new HashMap();

    public boolean addVertex(String vertex) {
        if (adjcencyList.get(vertex) == null) {
            adjcencyList.put(vertex, new ArrayList<>());
            return true;
        }

        return false;
    }

    public boolean removeVertex(String vertex) {
        ArrayList<String> target = adjcencyList.get(vertex);

        if (target == null) {
            return false;
        }

        for (String destinationVertex : target) {
            adjcencyList.get(destinationVertex).remove(vertex);
        }

        adjcencyList.remove(vertex);

        return false;
    }

    public boolean addEdge(String vertex, String destinationVertex) {

        ArrayList<String> startVertex = adjcencyList.get(vertex);
        ArrayList<String> endVertex = adjcencyList.get(destinationVertex);

        if (startVertex != null && endVertex != null) {
            adjcencyList.get(vertex).add(destinationVertex);
            adjcencyList.get(destinationVertex).add(vertex);
            return true;
        }

        return false;
    }

    public boolean removeEdge(String vertex, String destinationVertex) {

        ArrayList<String> startVertex = adjcencyList.get(vertex);
        ArrayList<String> endVertex = adjcencyList.get(destinationVertex);

        if (startVertex != null && endVertex != null) {
            startVertex.remove(destinationVertex);
            endVertex.remove(vertex);
            return true;
        }

        return false;
    }

    public void print() {
        System.out.println(adjcencyList);
    }
}
