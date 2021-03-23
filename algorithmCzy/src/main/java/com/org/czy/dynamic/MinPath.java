package main.java.com.org.czy.dynamic;

/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 加起来。返回最小的路径和。
 */
public class MinPath {

    //暴力法，存在大量重复计算，比如(1,1)会被多次计算
    public static int minPath1(int[][] matrix, int i, int j){
        if(i == matrix.length-1 && j == matrix[0].length-1) return matrix[i][j];

        //到达最下面
        if(i == matrix.length - 1){
            return matrix[i][j] + minPath1(matrix, i, j+1);
        }

        //到达最左边
        if(j == matrix[0].length - 1){
            return matrix[i][j] + minPath1(matrix, i+1, j);
        }

        int right = minPath1(matrix, i, j+1);//向右走的最小结果
        int down = minPath1(matrix, i+1, j);//向下走的最小结果
        return matrix[i][j] + Math.min(right,down);
    }

    //动态规划
    public static int minPath2(int[][] matrix){
        if(matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0]+matrix[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j-1]+matrix[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m,0,0));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m,0,0));
        System.out.println(minPath2(m));
    }
}
