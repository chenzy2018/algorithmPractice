package main.java.com.org.czy.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并查集
 */
public class UnoinSet {

    public static class Node{
        //whatever you like String / int / long / ...
    }

    public static class UnoinSetFind{
        public Map<Node,Node> fatherMap; // key：当前节点  value：当前节点的父节点
        public Map<Node,Integer> sizeMap; // key：当前节点 value：当前节点所在set的size

        public UnoinSetFind(List<Node> list){
            makeSets(list);
        }

        public void makeSets(List<Node> list){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for(Node node : list){
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        private Node findHead(Node node){
            Node father = fatherMap.get(node);
            if(father != node){
                father = findHead(node);
            }
            fatherMap.put(node, father);//让当前node的父节点直接指向最终父节点，下次找就快
            return father;
        }

        private Node findHeadUnRecur(Node node){
            Stack<Node> stack = new Stack<Node>();
            Node cur = node;
            Node parent  = fatherMap.get(cur);
            while (cur != parent){
                stack.push(cur);
                cur = parent;
                parent = fatherMap.get(cur);
            }
            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(),parent);
            }
            return parent;
        }

        public boolean isSameSet(Node node1, Node node2){
            return findHead(node1) == findHead(node2);
        }

        public void union(Node node1, Node node2){
            if(node1 == null || node2 == null) return;

            Node father1 = findHead(node1);
            Node father2 = findHead(node2);
            if(father1 != father2){
                int size1 = sizeMap.get(father1);
                int size2 = sizeMap.get(father2);

                if(size1 < size2){//把长度短的链变成长度长的子链
                    fatherMap.put(father1, father2);
                    sizeMap.put(father2, size1+size2);
                }else{
                    fatherMap.put(father2, father1);
                    sizeMap.put(father1, size1+size2);
                }
            }
        }
    }
}
