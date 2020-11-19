package ex0;

import java.util.*;

/**
 * Graph_ds is responsible for nodes and edges that combine into a graph
 * Mc is stands for count the changes in the graph
 * node_list is Hashtable which contains all the nodes in the graph
 */

public class Graph_DS implements graph {
    int Edge_counter = 0 ;
    int MC=0;
    Hashtable<Integer, node_data> node_list =
            new Hashtable<Integer, node_data>();

    @Override

    public node_data getNode(int key) {

        return node_list.get(key);
    }

    /**
     * an empty constructor
     */
    public Graph_DS(){

    }

    @Override
    /**
     *
     */
    public boolean hasEdge(int node1, int node2) {

        if (node1 == node2) return true;

        return this.getNode(node1).hasNi(node2) && this.getNode(node2).hasNi(node1); // chacks if node1 is a neighbour of node2
    }

    @Override
    public void addNode(node_data n) {

        if (!node_list.containsKey(n.getKey())) {
            node_list.put(n.getKey(),n);
            MC++;
        }

    }

    @Override
    /**
     * Connect an edge both directions between node1 and node2.
     */
    public void connect(int node1, int node2) { //CONNECT(0, 2), CONNECT(0, 2)

        if (node1 != node2) {

            if (this.node_list.containsKey(node1) && this.node_list.containsKey(node2)) {

                node_data n1 = node_list.get(node1);
                node_data n2 = node_list.get(node2);

                if (n1 != null && n2 != null) {

                    if (!hasEdge(node1, node2) && !hasEdge(node2, node1)) {

                        this.getNode(node1).addNi(this.getNode(node2));
                        this.getNode(node2).addNi(this.getNode(node1));
                        Edge_counter++;
                        MC++;

                    }

                }
            }

        }

    }

    /**
     * return an iteratable collection of all nodes
     * @return
     */
    @Override

    public Collection<node_data> getV() {
        return this.node_list.values(); /// return all the values of the neighbours with a collection(O(1))

//		List<node_data> l = new ArrayList<node_data>(node_list.values());
//		return l;
    }
    /**
     *  return an iteratable collection of all nodes within a given node
     */

    @Override
    public Collection<node_data> getV(int node_id) {

        if (this.node_list.containsKey(node_id))
            return this.node_list.get(node_id).getNi();

        return null;
    }

    @Override
    /**
     * delete the node and all his neighbours by given key
     */
    public node_data removeNode(int key) {

        if (this.node_list.containsKey(key)) {

            node_data x = this.getNode(key);
            if(x==null) {
                return null;
            }

            if (this.node_list.get(key).getNi().size() > 0) {

                for (node_data ni : this.node_list.get(key).getNi()) {

                    ni.getNi().remove(key);
                    MC++;
                    Edge_counter--;

                }

                MC++;
                return node_list.remove(key);

            }

            node_list.remove(key);
        }

        return null;
    }


    /**
     * remove the Edge between node 1 and node 2
     * @param node1
     * @param node2
     */
    @Override
    public void removeEdge(int node1, int node2) {

        if (node1 != node2) {

            if (this.node_list.containsKey(node1) && this.node_list.containsKey(node2)) {

                if (this.node_list.get(node1) != null && this.node_list.get(node2) != null) {

                    if (hasEdge(node1, node2) && hasEdge(node2, node1)) {

//	    				this.node_list.get(node1).getNi().remove(node2);
//	    				this.node_list.get(node2).getNi().remove(node1);

                        this.node_list.get(node1).removeNode(getNode(node2));
                        this.node_list.get(node2).removeNode(getNode(node1));

                        Edge_counter--;
                        MC++;
                    }
                }
            }

        }

    }

    /**
     *
     * @return
     */
    @Override
    public int nodeSize() {
        return getV().size();
    }

    @Override
    public int edgeSize() {
        return Edge_counter;
    }

    @Override
    public int getMC() {
        return MC;
    }
}
