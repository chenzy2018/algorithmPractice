package main.java.com.org.czy.sortPractice.interview;

/**
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 打印结果为：1，2，3，4，8，12，16，15，14，13，9，
 * 5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1)。
 *
 * 思路：
 * 一层一层打印，从最外层往里面打印
 */
public class PrintEdge {

    public void print(int[][] arr){
        int tR =0, tC = 0;
        int dR = arr.length-1,dC=arr[0].length-1;
        while(tR <= dR && tC <= dC){//一旦左上角重叠或者超过右下角，就停止
            printEdge(arr, tR++, tC++, dR--, dC--);
        }
    }

    //左上角(tR,tC)  右下角(dR,dC)
    public void printEdge(int[][] arr, int tR, int tC, int dR, int dC){

        if(tR == dR){//只有一条横向的链
            while(tC != dC){
                System.out.println(arr[tR][tC]);
                tC++;
            }
        }else if(tC == dC){//只有一条纵向的链
            while(tR != dR){
                System.out.println(arr[tR][tC]);
                tR++;
            }
        }else{
            int curR = tR;
            int curC = tC;
            while(curC != dC){
                System.out.println(arr[tR][curC]);
                curR++;
            }
            while (curR != dR){
                System.out.println(arr[curR][dC]);
                curC++;
            }
            while (curC != tC){
                System.out.println(arr[dR][curC]);
                curC--;
            }
            while (curR != tR){
                System.out.println(arr[curR][tC]);
                curR--;
            }
        }
    }
}
