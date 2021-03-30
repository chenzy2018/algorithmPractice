package main.java.com.org.czy.leetcode;

import main.java.com.org.czy.leetcode.util.ListNode;

/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 *
 * 快慢指针
 */
public class NC4HasCircle {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
