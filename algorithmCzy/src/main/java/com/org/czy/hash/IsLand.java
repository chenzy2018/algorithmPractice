package main.java.com.org.czy.hash;

/**
 * 岛问题
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
 * 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 * 矩阵中有多少个岛？
 *
 * 举例：
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * 这个矩阵中有三个岛。
 */

/**
 * 普通递归求解小型矩阵可以
 * 但是大型矩阵效率就低
 * 可以使用并查集分治，使用多线程跑：
 *   把大的矩阵切分成若干个小型矩阵
 *   分别求每个小型矩阵的岛数量，求出总和
 *   然后拿到每个小矩阵的边界信息(边界上的每个数所在集合是不是一个集合，已经合过的集合就不重复扣减)，求出需要合并的岛的数量
 *   两个数相减就是结果
 */
public class IsLand {

    public static int landNum(int[][] arr){
        if(arr == null || arr[0] == null) return 0;

        int row = arr.length;
        int col = arr[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == 1){
                    res++;
                    round(arr,i,i,row,col);
                }
            }
        }
        return res;
    }

    //把周围相连的1都给标记为2
    public static void round(int[][] arr, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || arr[i][j] != 1) return;

        arr[i][j] = 2;
        round(arr, i+1, j, m, n);
        round(arr, i, j+1, m, n);
        round(arr, i-1, j, m, n);
        round(arr, i, j-1, m, n);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(landNum(m1));
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(landNum(m2));
        System.out.println(countIslands(m2));

    }

    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }
}
