package main.java.com.org.czy.sortPractice.interview;

import java.util.Queue;

/**
 * 数组实现大小固定的队列
 *
 * 数组需要循环利用才能模拟队列
 */
public class ArrayQueue {

    private int arr[];
    private int start;//首节点
    private int end;//尾结点
    private int size;//数组当前长度，如果大于零，表示start没有追上end，简化start和end的关系

    public ArrayQueue(int len){
        if(len < 0) throw new IllegalArgumentException("输入异常");

        arr = new int[len];
        start = 0;
        end=0;
        size=0;
    }

    public Integer peek(){
        if(size == 0) return null;

        return arr[start];
    }

    public void add(int num){
        if(size == arr.length) throw new ArrayIndexOutOfBoundsException("越界");

        arr[end] = num;
        end = end == arr.length - 1 ? 0: end +1;
        size++;
    }

    public Integer pop(){
        if(size == 0) return null;
        size--;
        int tem = start;
        start = start == arr.length - 1 ? 0: start + 1;
        return arr[tem];
    }
}
