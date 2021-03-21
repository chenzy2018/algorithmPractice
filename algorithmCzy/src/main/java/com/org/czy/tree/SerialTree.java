package main.java.com.org.czy.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 *
 * #表示null,_用于分割
 */
public class SerialTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //序列化
    public static String serialTree(Node head){
        if(head == null) return "#_";

        StringBuilder sb = new StringBuilder();
        sb.append(head.value + "_");
        sb.append(serialTree(head.left));
        sb.append(serialTree(head.right));
        return sb.toString();
    }

    //反序列
    public static Node getNodeQueue(String str){
        if(str == null || str.equals("")) return null;

        String[] strs = str.split("_");
        Queue<String> nodes = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            nodes.offer(strs[i]);
        }
        return reSerialTree(nodes);
    }
    public static Node reSerialTree(Queue<String> nodes){
        String value = nodes.poll();

        if(value.equals("#")) return null;

        Node node = new Node(Integer.valueOf(value));
        node.left = reSerialTree(nodes);
        node.right = reSerialTree(nodes);
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        System.out.println(serialTree(head));
    }
}
