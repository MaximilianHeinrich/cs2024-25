package dev.maximilian;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The Graph class represents a simple directed graph using an adjacency matrix.
 */
public class Graph {

    // List of nodes in the graph
    ArrayList<Node> nodes;
    // Adjacency matrix to represent edges between nodes
    int[][] matrix;

    /**
     * Constructs a Graph with the specified size.
     *
     * @param size the number of nodes in the graph
     */
    public Graph(int size) {
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    /**
     * Adds a node to the graph.
     *
     * @param node the node to be added
     */
    public void addNode(Node node) {
        nodes.add(node);
    }

    /**
     * Adds a directed edge from the node at the start index to the node at the end index.
     *
     * @param start the index of the starting node
     * @param end   the index of the ending node
     */
    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
    }

    /**
     * Checks if there is a directed edge from the node at the start index to the node at the end index.
     *
     * @param start the index of the starting node
     * @param end   the index of the ending node
     * @return true if there is an edge from start to end, false otherwise
     */
    public boolean checkEdge(int start, int end) {
        return matrix[start][end] == 1;
    }

    /**
     * Prints the adjacency matrix of the graph.
     */
    public void print() {
        System.out.print("  ");

        nodes.forEach(node -> System.out.print(node.name + " "));

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).name + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Führt eine Breitensuche (Breadth-First Search, BFS) aus, beginnend bei einem Knoten,
     * der durch seinen Index angegeben ist.
     *
     * @param start der Index des Startknotens, von dem die Suche ausgehen soll
     */
    public void bfs(int start) {
        /**
         * Initialisiere eine Warteschlange, um die Knoten zu speichern, die besucht werden sollen.
         * @see <a href="https://www.baeldung.com/java-queue">Was ist eine Queue</a>
         */
        Queue<Integer> queue = new LinkedList<>();

        // Array, das verfolgt, ob ein Knoten bereits besucht wurde.
        // Die Größe des Arrays entspricht der Anzahl der Knoten (Anzahl der Zeilen/Spalten in der Matrix).
        boolean[] explored = new boolean[matrix.length];

        // Füge den Startknoten in die Warteschlange ein und markiere ihn als besucht.
        queue.offer(start);
        explored[start] = true;

        // Solange die Warteschlange nicht leer ist, besuche die Knoten.
        while (!queue.isEmpty()) {
            // Hole den nächsten Knoten aus der Warteschlange (FIFO-Prinzip).
            start = queue.poll();

            // Gib den Namen des aktuellen Knotens aus, um anzuzeigen, dass er besucht wurde.
            System.out.println(nodes.get(start).getName() + " = visited");

            // Durchlaufe alle Nachbarn des aktuellen Knotens.
            for (int i = 0; i < matrix[start].length; i++) {
                // Überprüfe, ob es eine Verbindung zum Nachbarknoten gibt (matrix[start][i] == 1)
                // und ob der Nachbarknoten noch nicht besucht wurde.
                if (matrix[start][i] == 1 && !explored[i]) {
                    // Füge den Nachbarknoten in die Warteschlange ein, damit er später besucht wird.
                    queue.offer(i);

                    // Markiere den Nachbarknoten als besucht, um Doppelbesuche zu vermeiden.
                    explored[i] = true;
                }
            }
        }
    }

}