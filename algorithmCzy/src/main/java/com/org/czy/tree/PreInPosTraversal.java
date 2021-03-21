package main.java.com.org.czy.tree;

import java.util.Stack;

/**
 * 二叉树先序中序后序遍历，递归非递归
 */
public class PreInPosTraversal {

    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //先序遍历递归
    private static void preOrderRecur(Node head){
        if(head == null) return;

        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //中序遍历递归
    private static void inOrderRecur(Node head){
        if(head == null) return;

        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }

    //后序遍历递归
    private static void posOrderRecur(Node head){
        if(head == null) return;

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value);
    }

    //先序遍历非递归
    private static void preOrderUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                Node node = stack.pop();
                System.out.println(node.value);
                //先进后出，所以要保证右子树先入栈
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
            }
        }
    }

    //中序遍历非递归
    private static void inOrderUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            //stack.push(head);
            while(!stack.isEmpty() || head != null){
                if(head != null){//一直放左子树。直到head为null
                    stack.push(head);
                    head = head.left;
                }else{//打印左子树，然后放入右子树
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }

    //后序遍历非递归
    private static void posOrderUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            Stack<Node> stack1 = new Stack<>();
            //stack.push(head);
            while(!stack.isEmpty()){//利用先序遍历非递归，stack1保持了中右左的顺序进入，那就能左右中出
                Node node = stack.pop();
                stack1.push(node);
                //先进后出，所以要保证左子树先入栈
                if(node.left != null) stack.push(node.left);
                if(node.right != null) stack.push(node.right);
            }
            while(!stack1.isEmpty()){
                Node node = stack1.pop();
                System.out.println(node.value);
            }
        }
    }

    //后序遍历非递归 一个栈
    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur(head);
        posOrderUnRecur2(head);

    }
}
