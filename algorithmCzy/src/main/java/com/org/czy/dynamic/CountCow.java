package main.java.com.org.czy.dynamic;

/**
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只
 * 母牛，假设不会死。求N年后，母牛的数量
 */
public class CountCow {

    //O(n)
    public static int countCow(int n){
        if(n<1) return 0;
        if(n == 1 || n == 2 || n == 3){
            return n;
        }

        return countCow(n-1) + countCow(n-3);
    }

    //O(logn)
    public static int cowNumber2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countCow(1));
        System.out.println(countCow(2));
        System.out.println(countCow(3));
        System.out.println(countCow(4));
        System.out.println(countCow(5));
        System.out.println(countCow(6));
        System.out.println(countCow(7));
        System.out.println(countCow(8));
        System.out.println(countCow(9));
    }
}
