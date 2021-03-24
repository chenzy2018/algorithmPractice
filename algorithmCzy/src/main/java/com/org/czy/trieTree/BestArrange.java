package main.java.com.org.czy.trieTree;

import java.util.Arrays;
/**
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目
 * 的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数
 * 组，里面 是一个个具体的项目)，你来安排宣讲的日程，要求会
 * 议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。
 *
 * 思路：贪心策略
 *  找结束时间最早的项目，然后淘汰因为这个不能做的项目，重复这个过程，统计可以做的项目数就是最大值
 */
public class BestArrange {

    class Progrem{
        private int start;
        private int end;

        public Progrem(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(Progrem[] pro, int start){
        if(pro == null || pro.length == 0) return 0;
        Arrays.sort(pro, (o1, o2) -> o1.end - o2.end);
        int res = 0;
        for (int i = 0; i < pro.length; i++) {
            if(start <= pro[i].start){
                res++;
                start = pro[i].end;
            }
        }
        return res;
    }
}
