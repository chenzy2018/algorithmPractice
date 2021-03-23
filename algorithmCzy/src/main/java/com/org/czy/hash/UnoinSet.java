package main.java.com.org.czy.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        public boolean isSameSet(Node node1, Node node2){
            return findHead(node1) == findHead(node2);
        }

        public void union(Node node1, Node node2){
            Node father1 = fatherMap.get(node1);
            Node father2 = fatherMap.get(node2);
            if(father1 != father2){
                int size1 = sizeMap.get(father1);
                int size2 = sizeMap.get(father2);

                if(size1 < size2){
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
