package main.java.com.org.czy.dynamic;

/**
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的
 * 重量，v[i]表示第i件商品的价值。
 * 再给定一个整数bag，要求你挑选商品的重量加起来一定不能超
 * 过bag，返回满足这个条件下，你能获得的最大价值
 */
public class Knaspack {

    public static int knaspack(int[] w, int[] v, int i, int bag, int weight, int res){
        if(weight > bag) return 0;
        if(i == w.length) return res;

        if(w==null || w.length ==0) return 0;

        return Math.max(knaspack(w,v,i+1,bag, weight,res),knaspack(w,v,i+1,bag, weight+w[i],res+v[i]));
    }

    public static int maxValue1(int[] c, int[] p, int bag) {
        return process1(c, p, 0, 0, bag);
    }

    public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag) {
        if (alreadyweight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(

                process1(weights, values, i + 1, alreadyweight, bag),

                values[i] + process1(weights, values, i + 1, alreadyweight + weights[i], bag));
    }

    public static int knaspack1(int[] w, int[] v, int bag){
        if(w==null || w.length ==0) return 0;
        //int len = ;
        //int col = Math.min(bag,len);
        int[][] dp = new int[w.length+1][bag+1];
        //dp[len][0] = v[0];
        // for(int i = 1; i<=bag; i++){
        //     dp[len][i] = dp[len][i-1] + v[i];
        // }

        for (int i = w.length-1; i >=0 ; i--) {
            for (int j = bag; j >= 0  ; j--) {
                dp[i][j] = dp[i+1][j];
                if(j + w[i]<= bag) dp[i][j] = Math.max(dp[i+1][j] , v[i]+dp[i+1][j + w[i]]);
            }

        }
        return dp[0][0];
    }

    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(c, p, bag));
        System.out.println(maxValue2(c, p, bag));
        System.out.println(knaspack(c,p,0,bag,0,0));
        System.out.println(knaspack1(c, p, bag));
    }
}
