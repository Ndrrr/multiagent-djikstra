# Multi-Agent Shortest Path Algorithm

This Java program demonstrates a distributed shortest path algorithm using asynchronous agents. The program simulates a network of nodes connected by weighted edges, where each node represents a location and each edge represents a path between two locations. The goal is to find the shortest path distances from a starting node to all other nodes in the network.

# Components
1. Node Class

   The Node class represents a node in the network and contains a name and a list of edges connecting to other nodes. The toString method is overridden to provide a meaningful string representation.

2. Edge Class

   The Edge class represents a directed edge between two nodes, containing the source node (from), destination node (to), and the weight of the edge.

3. Agent Class

   The Agent class represents an asynchronous agent that traverses the network to calculate the shortest path distances. Agents are created for each outgoing edge from a starting node. The agent runs in a separate thread and utilizes a priority queue to explore nodes in order of increasing distance.

4. Main Class

   The Main class contains the main method to execute the distributed shortest path algorithm. It creates nodes, edges, and agents to perform the algorithm. A ScheduledExecutorService is used to periodically synchronize agents and check if all agents have stopped.

# Algorithm Overview
Nodes are connected by directed edges with associated weights.
Agents are created for each outgoing edge from the starting node.
Each agent asynchronously explores the network to calculate shortest path distances using Dijkstra's algorithm.
Agents periodically synchronize their distances with other agents to update the global view.
The program terminates when all agents have stopped, and the final shortest path distances are displayed.
# Customization
You can customize the network topology, edge weights, and synchronization intervals in the Main class. Adjusting the parameters may impact the convergence speed and accuracy of the algorithm.

Feel free to experiment with different network configurations and observe how the distributed shortest path algorithm adapts to the changes.