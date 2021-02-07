package main.java.com.org.czy.sortPractice;

import main.java.com.org.czy.Utils.SortUtil;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2) return ;
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r){
        //只有左边界小于有边界才是有效
        if(l < r){
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0]-1);
            quickSort(arr, p[1]+1, r);
        }
    }

    //用于返回l到r区间上和arr[r]相等的区间的起点和终点
    public static int[] partition(int[] arr, int l, int r) {
        //int num = arr[r];
        int i = l - 1;
        int j = r;
        while (l < j) {
            if (arr[l] < arr[r]) {
                SortUtil.change(arr, l++, ++i);
            } else if (arr[l] > arr[r]) {
                SortUtil.change(arr, l, --j);
            } else {
                l++;
            }
        }
        SortUtil.change(arr, j, r);
        return new int[]{i+1, j};
    }
    public static void main(String[] args) {
        for(int time = 0; time < 1000; time ++){
            int[] arr = SortUtil.generateRondomArray(10,6);
            int[] arr1 = SortUtil.copyArray(arr);
            int[] arr2 = SortUtil.copyArray(arr);

            SortUtil.rightSort(arr1);
            quickSort(arr2);
            if(!SortUtil.isEquals(arr1, arr2)){
                System.out.println("wrong");
                for(int i = 0; i< arr.length ; i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println("");
                for(int i = 0; i< arr.length ; i++){
                    System.out.print(arr1[i]+" ");
                }
                System.out.println("");
                for(int i = 0; i< arr.length ; i++){
                    System.out.print(arr2[i]+" ");
                }
                System.out.println("");
                break;
            }else{
                System.out.println("right");
            }
        }
    }
}
