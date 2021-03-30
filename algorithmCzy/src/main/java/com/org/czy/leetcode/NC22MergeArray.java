package main.java.com.org.czy.leetcode;

/**
 * 给出两个有序的整数数组A 和B ，请将数组B 合并到数组A 中，变成一个有序的数组
 * 注意：
 * 可以假设 数组A有足够的空间存放 数组B的元素， AB 中初始的元素数目分别为 m和n
 */
public class NC22MergeArray {

    public void merge(int A[], int m, int B[], int n) {

        int i = m -1;
        int j = n -1;
        int index = m + n - 1;

        while(i>=0 && j>=0) A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        while(j>=0) A[index--] = B[j--];//如果B没遍历完就把B放进去

    }
}
