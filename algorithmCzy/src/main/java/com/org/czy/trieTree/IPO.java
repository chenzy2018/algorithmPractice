package main.java.com.org.czy.trieTree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，
 * 正数k 参数4，正数m
 * costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
 * 费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多
 * 做k个项目 m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下
 * 一个 项目。
 * 输出： 你最后获得的最大钱数
 *
 * 思路：贪心策略如下，
 *  准备一个小根堆(根据花费)和一个大根堆(根据收益)，弹出小根堆比初始资金少的项目，放到大根堆
 *  然后弹出大根堆中的根节点，完成，算得到的钱，
 *  再重复上述过程，最后的结果就是答案
 *
 */
public class IPO {

    public static int ipo(int[] costs, int[] profits, int k, int m){
        if(costs == null || costs.length == 0) return m;
        PriorityQueue<Integer> costQ = new PriorityQueue<>();//小根堆
        PriorityQueue<Integer> profitQ = new PriorityQueue<>(new MyCompare());//大根堆
        for(int i : costs){
            costQ.add(i);
        }

        for (int i = 0; i < k; i++) {
            while (!costQ.isEmpty() && costQ.peek() <= m){
                profitQ.add(costQ.poll());
            }
            if(profitQ.isEmpty()) return m;//当前本金不够做任何一个项目，直接返回
            m += profitQ.poll();
        }
        return m;
    }

    public static class MyCompare implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
