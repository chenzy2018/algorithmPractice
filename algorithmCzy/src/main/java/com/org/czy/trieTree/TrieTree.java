package main.java.com.org.czy.trieTree;

/**
 * 前缀树
 *   路径表示一个字符，从根节点到每个节点，路径字符加起来就能表示一个字符串
 *
 *   和样本量没有关系，只和样本长度有关系，效率非常高(样本量越大，体现越明显)
 *
 * 给定一个字符串，给他加到树形结构里
 *
 * 比如abc
 * 每次都从根节点开始，有到a的路径吗，没有加上，以此类推
 * 再加入bec
 * 再从从根节点开始，有到b的路径吗，没有加上，以此类推
 * 再加入ace
 * 再从从根节点开始，有到a的路径吗，有，复用，有到c的路径吗，没有，加上，以此类推
 *
 * 有什么用？
 * 比如查是否有以ab开始的字符串 --> 简单，从根节点开始，查有到a的路径吗，有，有到b的吗，有，然后遍历b下面的所有子节点直到叶子结点，都返回
 * 比如查abc字符串出现了多少次 --> 扩充节点内容，以该节点结束的字符串有多少个
 * 比如查以ab开头的字符串出现多少次 --> 再扩充节点内容，以该节点路径开头的字符串有多少个(经过该节点，包括到该节点结束的)
 *
 * 因此有需求，就可以扩充节点内容
 */
public class TrieTree {

    public static class TreeNode{
        public int path;//经过次数
        public int end;//结束次数
        public TreeNode[] nextNode;//存储后续节点

        public TreeNode(){
            path = 0;
            end = 0;
            nextNode = new TreeNode[26];//a~z ，长度看具体题目要求
        }
    }

    public static class Trie{
        private TreeNode root;

        public Trie(){
            root = new TreeNode();
        }

        //将字符串加入到前缀树中
        public void insert(String str){
            if(str == null) return;
            char[] chars = str.toCharArray();
            TreeNode node = root;
            for(char c:chars){
                int index = c-'a';//计算是26里的哪个位置
                if(node.nextNode[index] == null) node.nextNode[index] = new TreeNode();
                node = node.nextNode[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String str) {
            if (search(str) != 0) {
                char[] chars = str.toCharArray();
                TreeNode node = root;
                for (char c : chars) {
                    int index = c - 'a';
                    if (--node.path == 0) {
                        node.nextNode[index] = null;
                        return;
                    }
                    node = node.nextNode[index];
                }
                node.end--;
            }
        }

        public int search(String str){
            if(str == null) return 0;

            char[] chars = str.toCharArray();
            TreeNode node = root;
            for(char c : chars){
                int index = c - 'a';
                if(node.nextNode[index] == null || node.nextNode[index].path == 0) return 0;
                node = node.nextNode[index];
            }
            return node.end;
        }

        public int prefixNumber(String str){
            if(str == null) return 0;
            char[] chars = str.toCharArray();
            TreeNode node = root;
            for(char c : chars){
                int index = c - 'a';
                if(node.nextNode[index] == null) return 0;
                node = node.nextNode[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }
}
