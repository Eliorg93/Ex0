# Ex0
OOP/ex0
**author:Elior gueta**

this project is created to make an implementation of an undirected unweighted graph in java.

in This project we need to implements 3 interfaces:
1.**node_data**-represtning every node on the graph

2.**graph**-representing a graph with all the given nodes.

3.**graph_algorithms**- in this interface we will implement some basic algorithms on our graph.

We have 3 classes and in those classes we have some helpful functions:
**Class : NodeData:**

functions:
1.hasNi()-boolean method,return true if the node of this given key is a neighbour of this node.

2.addNi()-adding a neighboure for this node neighbours collection.

3.removeNode()-remove node from our collection(node neighbours).


**class:Graph_DS**
methods:
1.connect() -connect between 2 nodes 
(just if those nodes are exist)

2.hasEdge()- boolean method that return true if there is an edge between 2 nodes.

4.getV()-return the collection of our graph nodes.

5.removeNode()-remove node from our graph by given key

6.removeEdge()-if 2 nodes are connected,this method disconnect between them (y given 2 keys of nodes)

7.nodeSize()-return the size(num of nodes)in our graph

8.edgeSize()-return the quantity of the Edges in our graph.

9.getMC()- return the quantity of changes in our graph.

10.addNode()- method to add a new node to our graph.

**class: graph_algo**
methods:
in this class we used the BFS(Breadth-first) algorithm,that helps us to solve the shortest path problem(finding a path between two nodes(or vertices) in a graph.
1.isConnected()-Returns true if and only if (iff) there is a valid path from EVREY node to each other node.

2.shortestPathDist()eturns the length of the shortest path between src to dest

3.shortestPath()- return a list of nodes that we travelled with the shortestPathDist method.









