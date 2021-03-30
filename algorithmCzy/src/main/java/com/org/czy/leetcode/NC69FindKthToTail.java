package main.java.com.org.czy.leetcode;

import main.java.com.org.czy.leetcode.util.ListNode;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 */
public class NC69FindKthToTail {

    //入栈法
    public ListNode FindKthToTail (ListNode pHead, int k) {

        if(pHead == null) return null;
        Stack<ListNode> stack = new Stack<>();

        while(pHead!=null){
            stack.push(pHead);
            pHead = pHead.next;
        }

        if(k > stack.size()) return null;

        while(k>0){
            pHead = stack.pop();
            k--;
        }
        return pHead;
    }

    //双指针
    public ListNode FindKthToTail1 (ListNode pHead, int k) {

        if(pHead == null) return null;

        ListNode last = pHead;
        while(k>0 ){
            if(last == null) return null;
            last = last.next;
            k--;
        }

        while(last != null){
            pHead = pHead.next;
            last = last.next;
        }

        return pHead;
    }
}
