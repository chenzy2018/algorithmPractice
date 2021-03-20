package main.java.com.org.czy.sortPractice.interview;

/**
 * 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成
 * 顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 *
 * 思路：左上角和右下角，找到对应的四个点，交换位置，从外层往内层，完成所有旋转
 */
public class RotateEdge {

    public void totate(int[][] arr){
        int tR =0, tC = 0;
        int dR = arr.length-1,dC=arr[0].length-1;
        while(tR<dR){
            rotateEdge(arr, tR++, tC++, dR--, dC--);
        }
    }

    //完成一层的旋转
    public void rotateEdge(int[][] arr, int tR, int tC, int dR, int dC){
        int times = dC - tC;//需要遍历的次数，如果一行有n个数，就只需要遍历n-1次
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = arr[tR][tC+i];//保存第一个点的值
            arr[tR][tC+i] = arr[dR-i][dC];//将第二个点的值给第一个点
            arr[dR-i][dC] = arr[dR][dC-i];
            arr[dR][dC-i] = arr[tR+i][tC];
            arr[tR+i][tC] = tmp;
        }
    }
}
