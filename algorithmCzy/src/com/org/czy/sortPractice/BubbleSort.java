package com.org.czy.sortPractice;

import com.org.czy.Utils.SortUtil;

/**
 * 冒泡排序
 * O[n^2]
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){

        if(arr == null || arr .length < 2){
            return;
        }

        //每次循环都确定一个最大值放在数据最后
        for(int i = arr.length-1; i > 0; i--){
            for(int j = 0; j < i && arr[j]>arr[j+1] ; j++){
                SortUtil.change(arr,j,j+1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
