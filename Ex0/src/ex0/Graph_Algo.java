package ex0;

import java.util.*;

/**
 * this class contains all the algorithms on the graph
 * dist is an int that stand for destination
 * path_list is an list which contains a series of nodes which leads from one node to another
 */
public class Graph_Algo implements  graph_algorithms{

    private graph g;

    private HashMap<Integer, Integer> dist;
    private HashMap<Integer, Integer> parent;

    @Override
    /**
     * shaloow copy
     */
    public void init(graph g) {
        this.g = g;

        this.dist = new HashMap<>();
        this.parent = new HashMap<>();
    }

    @Override
    /**
     * return a copy of a given graph
     */
    public graph copy() {

        graph new_graph = new Graph_DS();

        for (node_data node : this.g.getV()) {

            node_data new_node = new NodeData(node.getKey());
            new_node.setInfo(node.getInfo());
            new_node.setTag(node.getTag());

            new_graph.addNode(new_node);

        }

        for (node_data node : this.g.getV()) {

            for (node_data neighbor : node.getNi()) {

                new_graph.connect(node.getKey(), neighbor.getKey());

            }

        }


        return new_graph;
    }


    private void bfs(int src) {

        Queue<node_data> q = new LinkedList<>();

        for (node_data node : this.g.getV()) {

            node.setTag(0); // color = WHITE = not visited

            if (node.getKey() == src) {
                this.dist.put(src, 0);
                node.setTag(1);
            }
            else {
                this.dist.put(node.getKey(), -1);
                this.parent.put(node.getKey(), null);
            }
        }

        q.add(this.g.getNode(src));

        while (!q.isEmpty()) {

            node_data u = q.poll();

            for (node_data neighbor : u.getNi()) {

                if (neighbor.getTag() == 0) { //did not visit yet

                    neighbor.setTag(1); //color = GREY

                    this.dist.put(neighbor.getKey(), this.dist.get(u.getKey()) + 1);
                    this.parent.put(neighbor.getKey(), u.getKey());

                    q.add(neighbor);
                }

            }

            u.setTag(2); // color == BLACK

        }

    }


    @Override
    /**
     * checks if all the nodes in the graph is connected
     */
    public boolean isConnected() {

        if (this.g.nodeSize() == 0 || this.g.nodeSize() == 1)
            return true;

        List<node_data> list = new ArrayList<node_data>(this.g.getV());
        bfs(list.get(0).getKey());

        for (node_data node_data : this.g.getV()) {
            if (node_data.getTag() == 0) //node is still WHITE
                return false;
        }

        return true;
    }

    /**
     * in this function we got the shortest path with a BfS's algorithm
     * @param src - start node // [src, n1, n2, n3, n4, dest]
     * @param dest - end (target) node
     * @return
     */
    @Override
    public int shortestPathDist(int src, int dest) {
        bfs(src);
        return this.dist.get(dest);
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {

        bfs(src);

        List<node_data> result = new ArrayList<>();

        int father = dest;

        result.add(this.g.getNode(dest));

        while (true) {

            result.add(this.g.getNode(this.parent.get(father)));
            father = this.parent.get(father);

            if (father == src) break;

        }

        List<node_data> back_result = new ArrayList<>();

        for (int i = result.size() - 1; i >= 0; i--) {
            back_result.add(result.get(i));
        }

        return back_result;
    }
}
