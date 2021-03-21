package main.java.com.org.czy.tree;

/**
 * 在二叉树中找到一个节点的后继节点
 * 【题目】 现在有一种新的二叉树节点类型如下：
 * public class Node { public int value; public Node left;
 * public Node right; public Node parent;
 * public Node(int data) { this.value = data; }
 * }
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假
 * 设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针
 * 都正确地指向 自己的父节点，头节点的parent指向null。只给一个在
 * 二叉树中的某个节点 node，请实现返回node的后继节点的函数。在二
 * 叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
 *
 * 思路：
 *  由于是中序遍历，左中右方式，因此分下面两种情况讨论
 *  当前节点是否有右子树
 *      有：右子树中的最左边的节点就是后继节点
 *      没有：找他的父亲，直到父亲是某个节点K的左孩子位置，K就是后继节点
 */
public class FindNextNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node findNextNode(Node currentNode){

        if(currentNode == null) return null;

        if(currentNode.right != null){
            Node node = currentNode.right;
            while (node != null && node.left != null){
                node = node.left;
            }
            return node;
        }else{
            // while(currentNode != null){
            //     if(currentNode.parent == null) return currentNode;
            //     if(currentNode.parent.left == currentNode) return currentNode.parent;
            //     currentNode = currentNode.parent;
            // }
            Node node = currentNode.parent;
            while (node != null && node.left != currentNode){
                currentNode = node;
                node = node.parent;
            }
            return  node;
        }
    }

    /**
     * 衍生：找前驱节点，同样中序遍历
     *
     * 思路：
     *  当前节点是否有左子树
     *      有：左子树中的最右边的节点就是后继节点
     *      没有：找他的父亲，直到父亲是某个节点K的右孩子位置，K就是后继节点
     */
    public Node findPreNode(Node currentNode){

        if(currentNode == null) return null;

        if(currentNode.left != null){
            Node node = currentNode.left;
            while (node != null && node.right != null){
                node = node.right;
            }
            return node;
        }else{
            // while(currentNode != null){
            //     if(currentNode.parent == null) return currentNode;
            //     if(currentNode.parent.left == currentNode) return currentNode.parent;
            //     currentNode = currentNode.parent;
            // }
            Node node = currentNode.parent;
            while (node != null && node.right != currentNode){
                currentNode = node;
                node = node.parent;
            }
            return  node;
        }
    }

}
