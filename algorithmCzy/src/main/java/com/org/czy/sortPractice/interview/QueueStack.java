package main.java.com.org.czy.sortPractice.interview;

import javafx.beans.binding.ObjectExpression;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 如何仅用队列结构实现栈结构
 *
 * 两个队列
 * 一个辅助队列，一个data队列
 *
 * 来数据往有数据的队列放，出数据，把有数据的前面数据放到另个队列，然后返回最后一个，以此反复
 */
public class QueueStack {
    private Queue data = new LinkedList();
    private Queue help = new LinkedList();

    public void push(int num){
        data.add(num);
    }

    public Object pop(){
        if(data.isEmpty()) throw new RuntimeException("栈没有数据1");
        while (data.size()>1){
            help.add(data.poll());
        }
        Object re = data.poll();
        // while (help.size() > 0){
        //     data.add(help.poll());
        // }
        //改变引用，保证data永远是有数据的那个队列
        Queue q = data;
        data = help;
        help = q;
        return re;
    }

    public Object peek(){
        if(data.isEmpty()) throw new RuntimeException("栈没有数据1");
        while (data.size()>0){
            help.add(data.poll());
        }
        Object re = help.peek();
        // while (help.size() > 0){
        //     data.add(help.poll());
        // }
        //改变引用，保证data永远是有数据的那个队列
        Queue q = data;
        data = help;
        help = q;
        return re;
    }

}
