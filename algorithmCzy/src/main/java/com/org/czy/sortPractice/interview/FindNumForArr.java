package main.java.com.org.czy.sortPractice.interview;

/**
 * 在行列都排好序的矩阵中找数
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，
 * matrix的每一行和每一列都是排好序的。实现一个函数，判断K
 * 是否在matrix中。 例如： 0 1 2 5 2 3 4 7 4
 * 4 4 8 5 7 7 9 如果K为7，返回true；如果K为6，返
 * 回false。
 * 【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)
 *
 * 思路：
 *  每一行和每一列都是排好序！！！
 *  从右上角开始找，如果比要找的数k大，就往左走，如果比k小，就往下走，直到越界，过程中找到就返回，越界就没找到
 *  或者从左下角开始，大往上，小往下
 */
public class FindNumForArr {

    public boolean findNumForArr(int[][] arr, int k){
        if(arr == null) return false;
        if(arr[0][0] == k) return true;

        int i = 0, j =arr[0].length;
        while(i<arr.length && j>=0){
            if(arr[i][j] == k) return true;
            else if(arr[i][j] > k) j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(""+getBoolean(3));
    }

    private static boolean getBoolean(int i) {
        while(i>0){
            if(i==1) return true;
            i = i-2;
        }
        return false;
    }
}
