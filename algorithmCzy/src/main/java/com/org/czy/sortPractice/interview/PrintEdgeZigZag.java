package main.java.com.org.czy.sortPractice.interview;

/**
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这
 * 个矩阵，例如： 1 2 3 4 5 6 7 8 9 10 11 12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，
 * 8，12
 * 【要求】 额外空间复杂度为O(1)。
 *
 * 思路：
 * 对角线打印，每次都给两头，然后boolean控制从哪边开始
 */
public class PrintEdgeZigZag {

    public void print(int[][] arr){
        int tR = 0, tC = 0;
        int dR = 0,dC = 0;
        boolean flag = false;
        while(tR != dR || tC != dC){//两个点没有相遇
            printEdgeZigZag(arr, tR, tC, dR, dC, flag);
            //右上角只会往右走，走到头就往下走
            if(tR == arr.length){
                tC++;
            }else{
                tR++;
            }
            //左下角只会往下走，走到头就往右走
            if(dC == arr[0].length){
                dR++;
            }else{
                dC++;
            }

            //变更打印方向
            flag = !flag;
        }
    }

    //按照打印方向输出对角线
    public void printEdgeZigZag(int[][] arr, int tR, int tC, int dR, int dC, boolean flag){

        int curR = tR,curC = tC;
        if(flag){//从右上角打印到左下角
            while(curR < dR){
                System.out.println(arr[curR][dC]);
                dC = dC>0 ? dC - 1: dC;
            }
        }else{
            while (curC < tC){
                System.out.println(arr[dR][curC]);
                dR = dR>0 ? dR -1:dR;
            }
        }
    }
}
