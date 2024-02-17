package org.example;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Node nodeA = new Node();
        Node nodeB = new Node();
        Node nodeC = new Node();
        Node nodeD = new Node();
        Node nodeE = new Node();
        Node nodeF = new Node();

        nodeA.name = "A";
        nodeB.name = "B";
        nodeC.name = "C";
        nodeD.name = "D";
        nodeE.name = "E";
        nodeF.name = "F";

        Edge edgeAB = new Edge();
        edgeAB.from = nodeA;
        edgeAB.to = nodeB;
        edgeAB.weight = 2;

        Edge edgeAC = new Edge();
        edgeAC.from = nodeA;
        edgeAC.to = nodeC;
        edgeAC.weight = 4;

        Edge edgeBC = new Edge();
        edgeBC.from = nodeB;
        edgeBC.to = nodeC;
        edgeBC.weight = 1;

        Edge edgeBD = new Edge();
        edgeBD.from = nodeB;
        edgeBD.to = nodeD;
        edgeBD.weight = 7;

        Edge edgeCD = new Edge();
        edgeCD.from = nodeC;
        edgeCD.to = nodeD;
        edgeCD.weight = 3;

        Edge edgeDE = new Edge();
        edgeDE.from = nodeD;
        edgeDE.to = nodeE;
        edgeDE.weight = 5;

        Edge edgeDF = new Edge();
        edgeDF.from = nodeD;
        edgeDF.to = nodeF;
        edgeDF.weight = 2;

        Edge edgeEF = new Edge();
        edgeEF.from = nodeE;
        edgeEF.to = nodeF;
        edgeEF.weight = 1;

        nodeA.edges = List.of(edgeAB, edgeAC);
        nodeB.edges = List.of(edgeBC, edgeBD);
        nodeC.edges = List.of(edgeCD);
        nodeD.edges = List.of(edgeDE, edgeDF);
        nodeE.edges = List.of(edgeEF);

        Agent agent007 = new Agent();
        agent007.name = "007";

        agent007.start(nodeA);

        // Display the shortest distances
        for (Map.Entry<Node, Integer> entry : agent007.distances.entrySet()) {
            System.out.println("Shortest distance from nodeA to " + entry.getKey() + ": " + entry.getValue());
        }

        Agent agent009 = new Agent();
        agent009.name = "009";

        agent009.start(nodeB);

        // Display the shortest distances
        for (Map.Entry<Node, Integer> entry : agent009.distances.entrySet()) {
            System.out.println("Shortest distance from nodeB to " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
