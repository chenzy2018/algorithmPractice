package main.java.com.org.czy.sortPractice.interview;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回
 * 文结构。 例如： 1->2->1，返回true。 1->2->2->1，返回true。
 * 15->6->15，返回true。 1->2->3，返回false。
 *
 * 思路：
 *  1.遍历放到栈中，然后再遍历同时出栈
 *  2.优化1，增加快慢指针，只压后面一部分数据进入栈
 *
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂
 * 度达到O(1)
 *
 * 思路：
 *  使用快慢指针，然后改变后半部分的指向，让他反过来，然后前后同时遍历，最后把指针还原
 */
public class Palindrome {

    public boolean isPalindrome1(Node node){
        if(node == null || node.getNextNode() == null) return true;

        Stack<Node> stack = new Stack<>();
        Node cur = node;
        while(cur != null){
            stack.push(cur);
            cur = cur.getNextNode();
        }

        while(!stack.isEmpty()){
            if(stack.pop().getValue().equals(node.getValue())) return false;
            node = node.getNextNode();
        }
        return true;
    }

    public boolean isPalindrome2(Node node){
        if(node == null || node.getNextNode() == null) return true;

        Stack<Node> stack = new Stack<>();
        Node cur = node;
        Node curFast = node;
        //保证链表长度是双数的情况，慢指针能停留在前一个中点
        while(curFast.getNextNode() != null && curFast.getNextNode().getNextNode() != null){
            cur = cur.getNextNode();
            curFast = curFast.getNextNode().getNextNode();
        }
        while(cur != null){
            stack.push(cur);
            cur = cur.getNextNode();
        }

        while(!stack.isEmpty()){
            if(!stack.pop().getValue().equals(node.getValue())) return false;
            node = node.getNextNode();
        }
        return true;
    }

    public boolean isPalindrome3(Node node){
        if(node == null || node.getNextNode() == null) return true;

        Stack<Node> stack = new Stack<>();
        Node cur = node;
        Node curFast = node;
        //保证链表长度是双数的情况，慢指针能停留在前一个中点
        while(curFast.getNextNode() != null && curFast.getNextNode().getNextNode() != null){
            cur = cur.getNextNode();
            curFast = curFast.getNextNode().getNextNode();
        }
        curFast = cur.getNextNode();
        //调整指针
        cur.setNextNode(null);
        Node tmp = null;
        while(curFast != null){
            tmp = curFast.getNextNode();
            curFast.setNextNode(cur);
            cur = curFast;
            curFast = tmp;
        }
        //判断是否是回文
        tmp = cur;//保存最后一个节点
        curFast = node;
        boolean res = true;
        while(cur!=null && curFast != null){
            if(!cur.getValue().equals(curFast.getValue())){
                res =  false;
                break;
            }
            cur = cur.getNextNode();
            curFast = curFast.getNextNode();
        }
        //还原指针
        cur = null;
        curFast = tmp;
        while(curFast!=null){
            tmp = curFast.getNextNode();
            curFast.setNextNode(cur);
            cur = curFast;
            curFast = tmp;
        }

        return res;
    }
}

class Node{

    private String value;
    private Node nextNode;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}


/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个
 * 整 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot
 * 的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
 * 除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5-
 * >1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总
 * 之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部
 * 分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做 要求。
 *
 * 进阶： 在原问题的要求之上再增加如下两个要求。
 * 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左 到右的
 * 顺序与原链表中节点的先后次序一致。 例如：链表9->0->4->5->1，pivot=3。
 * 调整后的链表是0->1->9->4->5。 在满足原问题要求的同时，左部分节点从左到
 * 右为0、1。在原链表中也 是先出现0，后出现1；中间部分在本例中为空，不再
 * 讨论；右部分节点 从左到右为9、4、5。在原链表中也是先出现9，然后出现4，
 * 最后出现5。
 * 如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 *
 * 思路：需要保证稳定性
 *  一次遍历，找到第一个小于num的节点a，第一个等于num的节点b，第一个大于num的节点c，这三个节点分别作为重构链表的起点
 *  再做一次遍历，把小于的放到a后面，定义enda指向新来的节点，每进来一个新的，enda就指向新的，等于和大于同理
 *  之后再把小于的enda和b相连，endb和c相连，endc指向null，这里注意每部分都可能为空，判断好边界即可
 */

/**
 * 复制含有随机指针节点的链表
 * 【题目】 一种特殊的链表节点类描述如下：
 * public class Node { public int value; public Node next; public
 * Node rand;
 * public Node(int data) { this.value = data; }
 * }
 * Node类中的value是节点值，next指针和正常单链表中next指针的意义
 * 一样，都指向下一个节点，rand指针是Node类中新增的指针，这个指
 * 针可能指向链表中的任意一个节点，也可能指向null。 给定一个由
 * Node节点类型组成的无环单链表的头节点head，请实现一个函数完成
 * 这个链表中所有结构的复制，并返回复制的新链表的头节点。
 *
 * 思路：
 *  使用map，第一次遍历，先复制节点(next和rand都指向null)，每复制一个就在map中添加一条这样的记录，key为原节点，value为拷贝节点，建立一对一关系
 *  第二次遍历，通过原节点找到next和rand以及复制节点，将复制节点的next和rand指向通过map找到next和rand各自对应的复制节点，遍历结束即完成复制
 *
 * 进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)内完成原问题要实现的函数。
 *
 * 思路：
 *  第一次遍历，复制节点，让原节点的next指向复制节点，复制节点指向原节点的next，即1->2->null 变成  1->1.->2->2.->null
 *      这样可以通过原节点直接找到拷贝节点，rand也同理
 *  第二次遍历，填充rand，取出1和1.，1.的rand指向1的rand的next，完成遍历，即完成rand的拷贝
 *  第三次遍历，分离原链表和拷贝链表
 */

/**
 * 两个单链表相交的一系列问题
 * 【题目】 在本题中，单链表可能有环，也可能无环。给定两个
 * 单链表的头节点 head1和head2，这两个链表可能相交，也可能
 * 不相交。请实现一个函数， 如果两个链表相交，请返回相交的
 * 第一个节点；如果不相交，返回null 即可。 要求：如果链表1
 * 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外
 * 空间复杂度请达到O(1)。
 *
 * 思路：map的方案都是提供解决方式，本题要求空间复杂度O(1)，map方案不满足
 *  先写个一个判断有环无环的方法：
 *      1.使用hashSet，如果节点已经在set中存在了，就说明有环，此节点就是环的入口节点
 *      2.快慢指针，快指针一次2步慢指针一次1步，如果快指针指向了null，无环
 *          如果相遇，证明有环，快指针回到头部，变为一次一步，快慢指针再次相遇，就是环的入口节点，这是结论
 *
 *  都无环：
 *      1.map，遍历链表1，节点放入map，再遍历链表2，判断map各种有没有节点，没有就没有
 *      2.遍历链表1，生成长度L1，最后节点end1，遍历链表2，生成长度L12，最后节点end2，判断end1和end2内存地址是否相等
 *          不相等就不相交，相等就长度长的先遍历到达短的长度，然后再一起遍历，当遇到第一个相同节点，该节点就是相交的第一个节点
 *
 *  一个有环一个无环：
 *      不可能相交(因为是单链表结构)
 *
 *  两个都有环：有三种可能拓扑图
 *      两个链表的入环节点相等，复用无环的解决方式
 *      如果入环节点不相等：
 *          链表1的入环节点一直next
 *              如果到达自己还没有和链表2的入环节点相同的节点，则不相交
 *              如果遇到了链表2的入环节点相同的节点，返回链表1的入环节点或者链表2的入环节点都行
 */
