package com.dreamer.algorithm.day20221007;

/**
 * LeetCode-283
 * <p>
 * 题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * 示例：
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class LeetCode283 {


    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }


        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
