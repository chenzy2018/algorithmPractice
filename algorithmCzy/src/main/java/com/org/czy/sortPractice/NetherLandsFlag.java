package main.java.com.org.czy.sortPractice;

import main.java.com.org.czy.utils.SortUtil;

/**
 * 荷兰国旗问题
 * 给定一个数组和一个数字，将数组中比指定数字小的放左边，相等放中间，大的放右边
 */
public class NetherLandsFlag {

    public static void netherLandsFlag(int[] arr, int num){
        if(arr == null || arr.length < 2) return;

        netherLandsFlagSort(arr, 0, arr.length-1, num);
    }

    //l到r范围上的数字进行比较
    public static void netherLandsFlagSort(int[] arr, int l, int r, int num){
        int i = l-1;
        int j = r+1;
        while (l<j){
            if(arr[l]<num){
                SortUtil.change(arr,l++,++i);
            }else if(arr[l]>num){
                SortUtil.change(arr,l,--j);
            }else{
                l++;
            }
            int[] a = new int[]{i+1, j-1};
            //System.out.println("l="+l+"|| l="+l+"|| r="+r);
        }
    }

    public static void main(String[] args) {
        for(int time = 0; time < 1000; time ++){
            int[] arr = SortUtil.generateRondomArray(10,6);
            int[] arr1 = SortUtil.copyArray(arr);
            int[] arr2 = SortUtil.copyArray(arr);

            SortUtil.rightSort(arr1);
            netherLandsFlag(arr2,3);
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
