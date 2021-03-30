package main.java.com.org.czy.leetcode;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class NC73MoreThanHalfNum {

    /**
     * 候选人法
     *
     * 消数，不相等就消除数，最后剩下的就是众数
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = 0;//候选人
        int cnt = 0;

        for (int i = 0; i < array.length; i++) {
            if(cnt == 0){
                res = array[i];
                ++cnt;
            }else{
                if(array[i] == res){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == res) cnt++;
        }
        res = cnt > (array.length>>1) ? res : 0;
        return res;
    }
}
