package com.org.czy.sortPractice;

/**
 * 归并排序
 * O(nlogn)
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr == null || arr .length < 2){
            return;
        }

        mergeProcess(arr, 0, arr.length-1);
    }

    public static void mergeProcess(int[] arr, int start, int end){
        if(start == end) return;

        int mid = start + ((end - start) >> 1);
        mergeProcess(arr, start , mid);
        mergeProcess(arr, mid + 1, end);

        //把左右半边的排序结果进行合并
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int i = start;//leftPoint
        int j = mid+1;//rightPoint
        int index = 0;//arrayPoint
        int[] tmp = new int[end - start + 1];//helpArray
        while(i<=mid && j<=end){
            //if(arr[i]<arr[j]){
            //    tmp[index++] = arr[i++];
            //}else{
            //    tmp[index++] = arr[j++];
            //}
            tmp[index++] = arr[i]<arr[j] ? arr[i++] : arr[j++];
        }
        while(i<=mid){
            tmp[index++] = arr[i++];
        }
        while(j<=end){
            tmp[index++] = arr[j++];
        }
        for(index = 0; index < tmp.length; index++){
            arr[start+index] = tmp[index];
        }
    }

    public static void main(String[] args) {


    }

}
