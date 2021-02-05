package com.org.czy.sortPractice;

/**
 * 归并排序
 * 求一个数组的小和
 * 当前位置数值减去前面所有比自己小的数的差的和即为该位置的小和，所有位置小和加起来即为整个数组的小和
 * 数组[1,3,4,2,5]，1没有，3为3-1,4为4-1+4-3,2为2-1,5为5-1+5-3+5-4+5-2
 */
public class MergeSort_SmallSum {

    public static int mergeSort(int[] arr){
        if(arr == null || arr .length < 2){
            return 0;
        }
        return mergeProcess(arr, 0, arr.length-1);
    }

    public static int mergeProcess(int[] arr, int start, int end){
        if(start == end){
            return 0;
        }
        int mid =start + ((end - start) >> 1);//等价(start+end)/2,但这样可能会溢出
        return mergeProcess(arr, start, mid) + mergeProcess(arr, mid+1, end) + merge(arr, start, mid, end);
    }

    public static int merge(int[] arr, int start, int mid, int end){

        int i = start;
        int j = mid + 1;
        int index = 0;
        int[] help = new int[end - start + 1];
        int result = 0;
        while(i<=mid && j<= end){
            result += arr[i] < arr[j] ? arr[i]*(end - j + 1) : 0;
            help[index++] = arr[i]<arr[j] ? arr[i++] : arr[j++];
        }
        //此处已经可以返回结果，但是还是把归并排序做完
        while(i<=mid){
            help[index++] = arr[i++];
        }
        while(j<= end){
            help[index++] = arr[j++];
        }
        for(i =0; i < help.length; i++){
            arr[start+i] = help[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
