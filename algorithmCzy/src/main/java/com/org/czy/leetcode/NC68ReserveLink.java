package main.java.com.org.czy.leetcode;

import main.java.com.org.czy.leetcode.util.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 *
 * 思路：原地反转
 */
public class NC68ReserveLink {

    public ListNode ReverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode nex = null;

        while(cur!=null){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
