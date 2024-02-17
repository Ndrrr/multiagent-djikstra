package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Agent {

    public String name;
    public Map<Node, Integer> distances;

    public void start(Node startingNode) {
        distances = new HashMap<>();

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(this::getDistanceTo));

        // Initialize distances with infinity
        for (Node node : startingNode.edges.stream().map(edge -> edge.to).toList()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        // Set distance of start node to 0
        distances.put(startingNode, 0);
        priorityQueue.add(startingNode);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            if (current.edges == null) {
                continue;
            }

            for (Edge edge : current.edges) {
                int newDistance = getDistanceTo(current) + edge.weight;

                // If the new distance is shorter, update the distance
                if (newDistance < getDistanceTo(edge.to)) {
                    distances.put(edge.to, newDistance);
                    priorityQueue.add(edge.to);
                }
            }
        }
    }

    private int getDistanceTo(Node node) {
        return distances.getOrDefault(node, Integer.MAX_VALUE);
    }
}
