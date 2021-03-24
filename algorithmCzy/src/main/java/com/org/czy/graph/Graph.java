package main.java.com.org.czy.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 */
public class Graph {
    public HashMap<Integer,Node> nodes;//节点
    public HashSet<Edge> edges;//边

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
