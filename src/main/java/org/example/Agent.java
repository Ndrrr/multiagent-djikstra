package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Agent {

    public String name;
    public Map<Node, Integer> distances;
    public Boolean stopped = Boolean.FALSE;

    public Agent() {
        this.distances = new HashMap<>();
    }

    public static Agent fromEdgeAsync(Edge e) {
        Agent agent = new Agent();
        Node startingNode = e.from;

        for (Node node : startingNode.edges.stream().map(edge -> edge.to).toList()) {
            agent.distances.put(node, Integer.MAX_VALUE);
        }

        agent.distances.put(startingNode, 0);
        agent.distances.put(e.to, e.weight);

        Runnable start = () -> agent.start(e);
        new Thread(start).start();
        return agent;
    }

    public void start(Edge startingEdge) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(this::getDistanceTo));

        priorityQueue.add(startingEdge.to);

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
        stopped = Boolean.TRUE;
    }

    private int getDistanceTo(Node node) {
        return distances.getOrDefault(node, Integer.MAX_VALUE);
    }

    public void sync(List<Agent> agents) {
        for (Agent agent : agents) {
            if (agent == this) {
                continue;
            }

            for (Node node : agent.distances.keySet()) {
                int distance = agent.distances.get(node);
                if (distance < getDistanceTo(node)) {
                    distances.put(node, distance);
                }
            }
        }
    }
}
