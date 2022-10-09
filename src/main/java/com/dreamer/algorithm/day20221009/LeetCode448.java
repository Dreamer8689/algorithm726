package com.dreamer.algorithm.day20221009;


import java.util.ArrayList;
import java.util.List;

/**
 * 来源：leetcode-448
 * 题目：给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 示例：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 */

public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] = nums[x] + n;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }

        return result;
    }

}
