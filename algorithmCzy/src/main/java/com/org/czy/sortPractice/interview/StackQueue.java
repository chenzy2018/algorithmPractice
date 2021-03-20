package main.java.com.org.czy.sortPractice.interview;

import java.util.Stack;

/**
 * 如何仅用栈结构实现队列结构
 *
 * 两个栈，push栈，pop栈，放数据一定往push栈放，拿数据一定从pop栈拿
 */
public class StackQueue {

    private Stack pushs = new Stack();
    private Stack pops = new Stack();

    public void push(Object num){
        pushs.push(num);
        changeData();
    }

    public Object pop(){
        if(pushs.isEmpty() && pops.isEmpty()) throw new RuntimeException("没数据");

        changeData();
        return pops.pop();
    }

    public Object peek(){
        if(pushs.isEmpty() && pops.isEmpty()) throw new RuntimeException("没数据");

        changeData();
        return pops.peek();
    }

    //数据从push到pop必须满足两个条件：1.pop栈没数据  2.push栈要一次性把数据全部转移到pop栈
    public void changeData(){
        if(!pops.isEmpty()) return;
        while(!pushs.isEmpty()){
            pops.push(pushs.pop());
        }
    }
}
