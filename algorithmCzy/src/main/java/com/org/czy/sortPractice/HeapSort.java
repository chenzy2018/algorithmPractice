package main.java.com.org.czy.sortPractice;

import main.java.com.org.czy.Utils.SortUtil;

/**
 * 堆排序  O(n*logn) 空间复杂度O(1)
 * 堆：是完全二叉树，即每一层都是从左往右，中间不能缺节点
 *      完全二叉树可以用数组模拟，当前节点i的左子树为2*i+1，右子树为2*i+2，其父节点为(i-1)/2
 * 大顶堆：完全二叉树中的任一子树(包括本身)中的最大值即为根节点。（小顶堆则是根节点未最小值）
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2 ) return;

        for(int i : arr){
            heapInsert(arr, i );
        }
        int heapSize = arr.length-1;
        SortUtil.change(arr,0,heapSize);
        while (heapSize>0){
            heapify(arr,0,heapSize);
            SortUtil.change(arr,0,--heapSize);
        }
    }

    /**
     * 将一个树加入大顶堆中的操作过程
     */
    public static void heapInsert(int[] arr, int i){
        while (arr[i] > arr[(i-1)/2]){
            SortUtil.change(arr, i, (i-1)/2 );
            i = (i-1)/2;
        }

    }

    /**
     * 数组中数字变动，重构大顶堆
     * @param heapSize 堆上一共有多少个数(可能目前数组只有heapSize个数构成了二叉树，剩下的还没进入二叉树，最大为数组的长度，用于判断是否越界了)
     */
    public static void heapify(int[] arr, int i, int heapSize){
        int left = 2*i+1;
        while(left<heapSize){
            int index = left+1<heapSize && arr[left+1]>arr[left] ? left+1: left;//获取i的左右子节点最大的数的节点下标
            index = arr[index] > arr[i] ? index : i;//和当前节点i比较获取较大的下标
            if(index == i) break;
            SortUtil.change(arr, i, index);
            i = index;
            left = index*2+1;
        }
    }

    public static void main(String[] args) {

    }
}
