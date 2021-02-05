package com.org.czy.sortPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序
 * 逆序对问题
 * 数组中，左边的数比右边的数大，则两个数字构成一个逆序对
 * 数组[1,3,4,2,5]，(3,2)(4,2)
 */
public class MergeSort_DifSort {

    public static List<String> mergeSort(int[] arr){
        if(arr == null || arr .length < 2){
            return new ArrayList<String>();
        }
        return mergeProcess(arr, 0, arr.length-1);
    }

    public static List<String> mergeProcess(int[] arr, int start, int end){
        if(start == end) return new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        int mid = start + ((end - start) >> 1);
        list.addAll(mergeProcess(arr,start,mid));
        list.addAll(mergeProcess(arr,mid+1,end));
        list.addAll(merge(arr, start, mid, end));
        return list;
    }

    public static List<String> merge(int[] arr, int start, int mid, int end){
        int index = 0;
        int i = start;
        int j = mid+1;
        int[] help = new int[end - start + 1];
        List<String> list = new ArrayList<String>();
        while(i<=mid && j<=end){
            if(arr[i] > arr[j]){
                list.add("("+arr[i]+","+arr[j]+")");
            }
            help[index++] = arr[i]>arr[j] ? arr[j++] : arr[i++];
        }
        while(i<=mid){
            help[index++] = arr[i++];
        }
        while(j<=end){
            help[index++] = arr[j++];
        }
        for(i = 0; i<help.length; i++){
            arr[start+i] = help[i];
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
