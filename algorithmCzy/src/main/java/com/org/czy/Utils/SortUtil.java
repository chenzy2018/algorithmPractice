package main.java.com.org.czy.Utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortUtil {

    /**
     * 数组交换函数
     */
    public static void change(int[] arr, int i, int j){

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 数组随机生成器
     */
    public static int[] generateRondomArray(int size, int value){

        //生成固定最大长度size的数组 [0,size]
        int[] arr = new int[(int)((size+1)*Math.random())];
        for(int i = 0; i < arr.length;i++){
            //生成基于value的随机数字，包含正负数
            do{
                arr[i] = Math.abs(((int) ((value+1)*Math.random()) - (int) (value*Math.random())));
            }while(arr[i]==0);
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

    /**
     * 排序绝对正确的方法
     */
    public static void rightSort(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 数组比较方法
     */
    public static boolean isEquals(int[] arr, int[] arr1){
        for(int i = 0; i< arr.length; i++){
            if(arr[i] != arr1[i]){
                return false;
            }
        }
        return true;
    }
}
