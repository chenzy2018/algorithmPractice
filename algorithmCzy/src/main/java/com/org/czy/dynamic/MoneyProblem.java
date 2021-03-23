package main.java.com.org.czy.dynamic;

/**
 * 钱包问题
 */
public class MoneyProblem {

    /**
     * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
     * 数字，能不能累加得到aim，返回true或者false
     */
    public static boolean canGetNum(int[] matrix,int i, int num, int res){
        if(res == num) return true;
        else if(res > num) return false;

        if(i == matrix.length) return false;

        return canGetNum(matrix, i+1, num, res + matrix[i]) || canGetNum(matrix, i+1, num, res);
    }

    /**
     * 动态规划
     */
    public static boolean canGetNum1(int[] matrix, int num){

        int len = matrix.length;
        int sum =0;
        for (int i = 0; i < len; i++) {
            sum+=matrix[i];
        }
        if(sum < num) return false;
        boolean[][] dp  =new boolean[len+1][sum+1];
        for (int i = 0; i <= sum; i++) {
            dp[len][i] = i == num;
        }

        int sumt = 0;
        for (int i = len-1; i >= 0; i--) {
            sumt = sumt + matrix[i];
            for (int j = 0; j < sum-sumt+1; j++) {
                dp[i][j] = dp[i+1][j] || dp[i+1][j+matrix[i]];
            }
        }

        return dp[0][0];
    }

    public static boolean money2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 };
        int aim = 8;
        System.out.println(canGetNum(arr,0, aim,0));
        System.out.println(canGetNum1(arr, aim));
    }
}
