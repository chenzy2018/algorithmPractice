package main.java.com.org.czy.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 宽(广)度优先
 *
 * 离根节点近的先输出，使用队列
 */
public class BFS {
    public static void bfs(Node node){
        if(node == null) return;

        Queue<Node> queue = new LinkedList<>();
        Set<Node> map = new HashSet<>(); //保证节点不重复进队列
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next : cur.nexts){
                if(!map.contains(next)){
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
