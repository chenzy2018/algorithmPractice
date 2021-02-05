package main.java.com.org.czy.sortPractice;

import main.java.com.org.czy.Utils.SortUtil;

/**
 * 荷兰国旗问题
 * 给定一个数组和一个数字，将数组中比指定数字小的放左边，相等放中间，大的放右边
 */
public class NetherLandsFlag {

    public static void netherLandsFlag(int[] arr, int num){
        if(arr == null || arr.length < 2) return;

        netherLandsFlagSort(arr, 0, arr.length, num);
    }

    //l到r范围上的数字进行比较
    public static void netherLandsFlagSort(int[] arr, int l, int r, int num){
        int cur = l;
        while (cur<r){
            if(arr[cur]<num){
                SortUtil.change(arr,l++,cur++);
            }else if(arr[cur]>num){
                SortUtil.change(arr,cur,r--);
            }else{
                cur++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
