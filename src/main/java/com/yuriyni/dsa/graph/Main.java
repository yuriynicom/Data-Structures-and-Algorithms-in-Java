package com.yuriyni.dsa.graph;

import java.util.*;

class Node {
    int id;
    int distance;

    Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }
}

class Graph {
    int[][] matrix;
    int V;

    public Graph(int V) {
        this.V = V;
        matrix = new int[V][V];
    }

    public void addEdge(int src, int dest, int weight) {
        matrix[src][dest] = weight;
    }

    public int minDistance(int src) {
        boolean[] visited = new boolean[V];
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            visited[current.id] = true;

            for (int neighbor = 0; neighbor < V; neighbor++) {
                if (matrix[current.id][neighbor] > 0 && !visited[neighbor]) {
                    int newDistance = distances[current.id] + matrix[current.id][neighbor];
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        pq.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        return distances[V - 1]; // Replace V-1 with the target node if needed
    }
}

public class Main {
    public static void main(String[] args) {
        int V = 9;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 1);
        graph.addEdge(7, 8, 6);

        int shortestDistance = graph.minDistance(0);
        System.out.println("Shortest distance from node 0 to 8: " + shortestDistance);
    }
}