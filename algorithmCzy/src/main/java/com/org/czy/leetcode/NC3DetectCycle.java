package main.java.com.org.czy.leetcode;

import main.java.com.org.czy.leetcode.util.ListNode;

public class NC3DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {//快慢确定是否有环
                fast = head;
                while(fast != slow){//同速相遇就是入环接节点
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
