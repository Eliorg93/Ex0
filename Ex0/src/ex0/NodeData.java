package ex0;

import java.util.*;

/**
 * NodeData  (which implements node_data class) stores all the data of the node , including :
 * key , information and tag
 * we got hashmap to represent all the neighbours
 */
public class NodeData implements node_data {
    private int key;
    private String information;
    private int tag;
    private static int node_counter=0;
    private HashMap<Integer,node_data> ni;


    /**
     * Empty constructor
     */
    public NodeData(){
        this.key=node_counter;
        node_counter++;
        this.ni = new HashMap<Integer,node_data>();
        this.tag = 0; // 0 = white, 1 = grey, 2 = black
        this.information = "";
    }

    public NodeData(int key)
    {
        this.key = key;
        this.information = "";
        this.tag = 0;
        this.ni = new HashMap<Integer,node_data>();
    }


    @Override
    public int getKey() {

        return this.key;
    }

    @Override
    /**
     * return the values of the node neighbours
     */
    public Collection<node_data> getNi() {

        return this.ni.values();
    }

    @Override
    /**
     * return true if the key of the node has neighbours
     * return false if we dont have neighbours
     * (we dont have an edge between them)
     */
    public boolean hasNi(int key) {
        if (this.ni.containsKey(key))
            return true;
        return false;
    }

    @Override
    public void addNi(node_data t){
        if(!(this.ni.containsKey(t.getKey()))){
            this.ni.put(t.getKey(),t);
        }
    }

    @Override
    /**
     * search the neighbours of a given node, and remove the wanted node and all his neighbors.
     */
    public void removeNode(node_data node) {
        if(this.ni.containsKey(node.getKey())) {
            this.ni.remove(node.getKey());
        }


//        for(node_data y : this.getNi()) {
//            if(y.getKey()==node.getKey())
//            {
//                for (node_data x: y.getNi())
//                {
//                    x.removeNode(y);
//                }
//            }
//        }
        /// FINISHED!!!!!!
    }

    @Override
    public String getInfo() {
        return this.information;
    }

    @Override
    public void setInfo(String s) {
        this.information=s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag=t;
    }

}
