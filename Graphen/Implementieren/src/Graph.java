import util.Edge;
import util.Vertex;

import java.util.ArrayList;

class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);
        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if (!this.isDirected) {
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public void print() {
        for (Vertex vertex : vertices) {
            vertex.print(isWeighted);
        }
    }

    public Vertex getVertexByValue(String value) {
        for (Vertex vertex : vertices) {
            if (vertex.getData().equals(value)) {
                return vertex;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Graph busNetwork = new Graph(true, true);
        Vertex koenigsbrunnStop = busNetwork.addVertex("Königsbrunn");
        Vertex bobingenStop = busNetwork.addVertex("Bobingen");

        busNetwork.addEdge(koenigsbrunnStop, bobingenStop, 6000);

        busNetwork.print();

    }

}