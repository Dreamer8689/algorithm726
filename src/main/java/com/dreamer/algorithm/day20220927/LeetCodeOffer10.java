package com.dreamer.algorithm.day20220927;

import java.util.HashMap;
import java.util.Map;

/**
 * 链接：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof
 * 题目：剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */


public class LeetCodeOffer10 {


    // 递归可能超时
    public int fib(int n) {
        int result;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }


        result = (fib2(n - 1) + fib2(n - 2)) % 1000000007;

        return result;

    }

    // 使用递归加数据存储
    private Map<Integer, Integer> storeMap = new HashMap<>();

    public int fib2(int n) {

        int result;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (null != storeMap.get(n)) {
            return storeMap.get(n);
        } else {
            result = (fib2(n - 1) + fib2(n - 2)) % 1000000007;
            storeMap.put(n, result);
            return result;
        }
    }


    // 使用动态规划方案
    public int fib1(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
