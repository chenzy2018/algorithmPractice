package main.java.com.org.czy.sortPractice;

import main.java.com.org.czy.utils.SortUtil;

/**
 * 选择排序
 * O[n^2]
 */
public class SelectSort {

    public static void selectSort(int[] arr){
        if(arr == null || arr .length < 2){
            return;
        }

        //每次确定最小的数放到i位置
        for(int i = 0; i < arr.length-1; i++ ){
            //for(int j = i+1; j < arr.length && a[i]>a[j];j++){
            //    SortUtil.change(arr,i,j);
            //}
            int minIndex = i;
            for(int j = i+1; j < arr.length;j++){
                minIndex = arr[minIndex]>arr[j] ? j : minIndex;
            }
            SortUtil.change(arr,i,minIndex);
        }

    }

    public static void main(String[] args) {

    }
}
