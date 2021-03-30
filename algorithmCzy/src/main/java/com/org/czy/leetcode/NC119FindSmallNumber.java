package main.java.com.org.czy.leetcode;

import java.util.ArrayList;

/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 *
 * 思路：选择排序K次，快排，
 */
public class NC119FindSmallNumber {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || input.length == 0 || k > input.length) return new ArrayList<Integer>();

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {//最后一遍需要跑，不然k等于数组长度的时候，结果会少一个
            int minIndex = i;
            for (int j = i+1; j < input.length; j++) {
                minIndex = input[minIndex] > input[j] ? j : minIndex;
            }
            if(list.size() >= k){
                break;
            }
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
            list.add(temp);
        }
        return list;
    }
}
