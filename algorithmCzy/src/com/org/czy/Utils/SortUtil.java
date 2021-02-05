package com.org.czy.Utils;

public class SortUtil {

    /**
     * 数组交换函数
     */
    public static void change(int[] arr, int i, int j){

        //int tmp = arr[i];
        //arr[i] = arr[j];
        //arr[j] = tmp;

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 数组随机生成器
     */
    public static int[] generateRondomArray(int size, int value){

        //生成固定最大长度size的数组 [0,size]
        int[] arr = new int[(int)((size+1)*Math.random())];
        for(int i = 0; i < arr.length;i++){
            //生成基于value的随机数字，包含正负数
            arr[i] = (int) ((value+1)*Math.random()) - (int) (value*Math.random());
        }
        return arr;
    }


    /**
     * 数组拷贝函数
     */
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return arr;
        }
        int[] res = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

}
