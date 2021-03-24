package main.java.com.org.czy.graph;

import java.util.ArrayList;

/**
 * 图节点
 */
public class Node {
    public int value;//值
    public int in;//入度
    public int out;//出度
    public ArrayList<Node> nexts;//邻居节点，我是from
    public ArrayList<Edge> edges;//边，我是from

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
