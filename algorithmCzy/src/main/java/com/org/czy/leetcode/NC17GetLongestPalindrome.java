package main.java.com.org.czy.leetcode;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
public class NC17GetLongestPalindrome {

    public int getLongestPalindrome(String A, int n) {
        if(n == 0) return 0;

        int maxLen = 1;
        //以i为中心扩散
        for (int i = 0; i < A.length()-1; i++) {
            //以i和i+1分别扩散，哪个大取哪个
            int len1 = getMaxLength(A,i,i);
            int len2 = getMaxLength(A,i,i+1);
            maxLen = Math.max(Math.max(len1,len2),maxLen);
        }

        return maxLen;
    }

    public int getMaxLength(String A, int left, int right){
        while(left >=0 && right<=A.length()-1){
            if(A.charAt(left) == A.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        //减2的原因是左右都多走了一步
        return right - left + 1 - 2;
    }
}
