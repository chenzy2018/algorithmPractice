package main.java.com.org.czy.sortPractice.interview;

import java.util.Stack;

/**
 * 用数组实现大小固定的栈
 */
public class ArrayStack {

    private int[] arr;
    private int index;

    public ArrayStack(int len) {
        if(len < 0){
            throw new IllegalArgumentException("输入异常");
        }

        arr = new int[len];
        index = 0;
    }

    public void push(int num){
        if(index == arr.length) throw new ArrayIndexOutOfBoundsException("已经满了");
        arr[index++] = num;
    }

    public Integer peek(){
        if(index == 0) return null;
        return arr[index-1];
    }

    public Integer pop(){
        if(index == 0) return null;
        return arr[--index];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int i =0;
        System.out.println("1."+arr[i++]);
        System.out.println(i);
        System.out.println("2."+arr[++i]);
        System.out.println(i);
    }
}
