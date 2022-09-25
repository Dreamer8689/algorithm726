package com.dreamer.algorithm.day20220925;


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode-70
 * <p>
 * 问题描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 输出:
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */

public class LeetCode70 {

    private Map<Integer, Integer> resultStore = new HashMap<>();

    // 方法二
    public int climbStairs2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (null == resultStore.get(n)) {
            int result = climbStairs2(n - 1) + climbStairs2(n - 2);
            resultStore.put(n, result);
        }
        return resultStore.get(n);
    }

    // 方法一
    public int climbStairs(int n) {
        int num1 = 0, num2 = 0, result = 1;
        for (int i = 1; i <= n; i++) {
            num1 = num2;
            num2 = result;
            result = num1 + num2;
        }

        return result;
    }





}
