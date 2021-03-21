package main.java.com.org.czy.tree;

import java.util.Stack;

/**
 * 判断一棵二叉树是否是平衡二叉树
 *  二叉树中的每个节点的左右子树高度差不能超过1，这样的树就是平衡二叉树
 *
 * 判断一棵树是否是搜索二叉树
 *  二叉树的每个节点的左子树都不右子树的值小
 *  方法：中序遍历的结果是递增的就是搜索二叉树
 *
 * 判断一棵树是否是完全二叉树
 *  二叉树的每一层都是从左往右完整出现，不完整的只能出现在最后一层
 *  方法：层序遍历
 *      判断节点是否只有右子树，如果是，不是完全二叉树
 *      如果一个节点出现只有左子树或左右子树都没有，后续遍历到的节点一定都是叶子节点
 */
public class BalanceTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }
    public static class ReturnData{
        private boolean isBalance;
        private int high;

        public ReturnData(boolean isBalance, int high) {
            this.isBalance = isBalance;
            this.high = high;
        }
    }

    //递归判断是否是平衡二叉树
    public static boolean isBalanceTreeRecur(Node node){
        return process(node).isBalance;
    }
    public static ReturnData process(Node node){
        if(node == null) return new ReturnData(true,0);

        ReturnData left = process(node.left);
        if(!left.isBalance) return  new ReturnData(false,0);//左子树不平衡直接返回
        ReturnData right = process(node.right);
        if(!right.isBalance) return  new ReturnData(false,0);//右子树不平衡直接返回

        //高度相差大于1，直接返回
        if(Math.abs(left.high - right.high) > 1) return  new ReturnData(false,0);

        return new ReturnData(true, Math.max(left.high,right.high)+1);
    }

    //递归判断是否是搜索二叉树
    public boolean isBST(Node node){
        return processBST(node).isBalance;

    }
    public ReturnData processBST(Node node){
        if(node == null) return new ReturnData(true,0);

        ReturnData left = processBST(node.left);
        if(!left.isBalance) return  new ReturnData(false,0);
        ReturnData right =processBST(node.right);
        if(!left.isBalance) return  new ReturnData(false,0);

        if(left.high > right.high) return  new ReturnData(false,0);

        return new ReturnData(true, Math.max(left.high,right.high));
    }
    public boolean processBSTUnRecur(Node node){
        if(node == null) return true;

        int pre = 0;
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node.left);
                node = node.left;
            }else{
                node = stack.pop();
                pre = stack.peek().value;
                if(node.value > pre) return false;//这里有问题
                node = node.right;
            }
        }
        return true;
    }
}
