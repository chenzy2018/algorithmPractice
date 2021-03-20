package main.java.com.org.czy.sortPractice.interview;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
 * 回栈中最小元素的操作。
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 *
 * 思路：
 * 双栈，一个保存数据，一个保存当前数据里的最小值
 */
public class ArrayStarkMin<E> {

    private Stack<E> data;
    private Stack<E> minStk;//记录data在不同情况下的最小值

    public ArrayStarkMin(){
        data = new Stack<>();
        minStk = new Stack<>();
    }

    public E pop(){
        minStk.pop();
        return data.pop();
    }

    public void push(E num){
        E i = minStk.peek();
        if((Long)num > (Long)i){//这里有待优化，应该实现比较器的
            minStk.push(i);
        }else{
            minStk.push(num);
        }
        data.push(num);
    }

    public E getMin(){
        return minStk.peek();
    }
}
