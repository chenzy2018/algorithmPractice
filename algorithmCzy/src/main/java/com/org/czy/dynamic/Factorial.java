package main.java.com.org.czy.dynamic;

/**
 * 求n!
 */
public class Factorial {

    /**
     * 暴力法
     */
    public long getFactorial(int n){
        long result = 1L;
        for (int i = 1; i < n; i++) {
            result = result*n;
        }
        return result;
    }

    /**
     * 动态规划
     */
    public long getFactoria2(int n){
        if(n ==1) return 1L;
        return n*getFactoria2(n-1);
    }
}
