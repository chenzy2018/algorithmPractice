package main.java.com.org.czy.leetcode;

import main.java.com.org.czy.leetcode.util.ListNode;

/**
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 */
public class NC33MergeTwoLists {

    //建立新的链表
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode res = l1.val>l2.val? l2: l1;
        ListNode tail = res;
        l1 = (res == l1)? l1.next:l1;
        l2 = (res == l2)? l2.next:l2;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null)? l2 : l1;
        return res;
    }

    //辅助头结点
    public ListNode mergeTwoLists1 (ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode res = new ListNode(0);
        ListNode tail = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null)? l2 : l1;
        return res.next;
    }
}
