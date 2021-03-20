package main.java.com.org.czy.sortPractice;

import main.java.com.org.czy.Utils.SortUtil;

/**
 * 插入排序
 * 最好情况升序O(n),最坏情况降序O[n^2],取最坏情况，因此是O[n^2]
 *
 * 小样本量情况下插排非常快，因为常数项很小
 */
public class InsertSort {

    public static void insertSort(int[] arr){

        if(arr == null || arr .length < 2){
            return;
        }

        //每次将当前数和前面的数字依次比较，遇到比自己大的就交换
        for(int i = 1; i < arr.length; i++){
            int index = i;
            for(int j = i-1; j >= 0 && arr[j]>arr[j+1]; j--){
                SortUtil.change(arr,j,j+1);
            }
        }

    }

    public static void main(String[] args) {

    }
}
