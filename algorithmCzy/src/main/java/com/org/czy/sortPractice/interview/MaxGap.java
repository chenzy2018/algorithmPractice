package main.java.com.org.czy.sortPractice.interview;

/**
 * 面试题：经典
 *
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
 * 间复杂度O(N)，且要求不能用非基于比较的排序。
 *
 * 原理：对于给定长度为N的数组，准备N+1个桶，然后将N个数分别放到对应桶里，至少存在一个空桶(这样可以保证结果一定不是来自同一个桶)
 * 然后再找到空桶前一个不空的桶的最大值和后一个不空桶的最小值，比较差值，最大的就是结果
 */
public class MaxGap {

    public static int maxGap(int arr[]){

        if(arr == null || arr.length < 1) return 0;
        int result= 0,max=0,min=0;
        int len = arr.length;

        //找到最大值和最小值
        for (int i = 0; i < len; i++) {
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }

        if(min == max) return 0;

        Boolean[] booleans = new Boolean[len+1];//记录桶是否放了数字
        int[] maxs = new int[len+1];//记录每个桶的最大值
        int[] mins = new int[len+1];//记录每个桶的最小值

        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max);
            maxs[bid] = booleans[bid] ? Math.max(arr[i],maxs[bid]) : arr[i];
            mins[bid] = booleans[bid] ? Math.min(arr[i],mins[bid]) : arr[i];
            booleans[bid] = true;
        }

        int lastmax = maxs[0];
        for (int i = 1; i < len; i++) {
            if(booleans[i]){
                result = Math.max(result, mins[i] - lastmax);
                lastmax = maxs[i];
            }
        }
        return result;
    }

    //定位当前数去几号桶
    public static int bucket(int num, int len, int min, int max){
        return (int) ((num - min) * len / (max-min));
    }
}
