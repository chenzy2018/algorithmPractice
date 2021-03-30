package main.java.com.org.czy.leetcode;

import main.java.com.org.czy.leetcode.util.ListNode;

/**
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 */
public class NC50ReverseKGroup {

    public ListNode reverseKGroup (ListNode head, int k) {

        if(head == null || k <= 0) return head;

        int length = 0;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode per = res;
        ListNode cur = head;
        ListNode nex = null;
        while(head != null){
            head = head.next;
            length++;
        }

        for (int i = 0; i < length/k; i++) {
            for (int j = 1; j < k; j++) {
                nex = cur.next;
                cur.next = nex.next;
                nex.next = per.next;
                per.next = nex;
            }
            per = cur;
            cur = cur.next;
        }

        return res.next;
    }
}
