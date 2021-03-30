package main.java.com.org.czy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 */
public class NC41FindMaxLength {

    public int maxLength (int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int left=0,right = 0; right < arr.length; right++){
            if(map.containsKey(arr[right])){
                /*当某个数在之前出现过，这个时候就把子串的起点start往后推一个，但是有一种情况，
                    比如1，2，3，4，3，5，1。到第二个3时，以后的子串起点start为4，
                    到第二个1时，如果不取最大的start，按start = map.get(arr[end])+1
                    算出起点start为2，显然以起点start=2，结尾end=1的子串234351有重复的，
                    因此start要取最大的
                    */
                left = Math.max(left,map.get(arr[right])+1);
            }
            max = Math.max(max, right - left + 1);
            map.put(arr[right],right);

        }
        return max;
    }

}
