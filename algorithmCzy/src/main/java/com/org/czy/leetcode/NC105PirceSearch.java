package main.java.com.org.czy.leetcode;

/**
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 *  [1,2,4,4,5],4  --> 2 即最左边
 */
public class NC105PirceSearch {
    public int search (int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int mid = 0;
        while(l<=r){
            mid = l + ((r-l)>>1);
            if(nums[mid] == target){
                while(mid>0 && nums[mid -1] ==nums[mid]) mid--;
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return -1;
    }
}
