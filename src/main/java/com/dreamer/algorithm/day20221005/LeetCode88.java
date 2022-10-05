package com.dreamer.algorithm.day20221005;


import java.util.Arrays;

/**
 * LeetCode-88 题
 *
 * 题目：给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 示例：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 *
 */
public class LeetCode88 {


    // 方法一
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }


    // 方法二 双指针
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 设置两个指针
        int p1 = 0, p2 = 0;
        // 生成一个数组用于存放数据
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            // 如果指针到数组1末尾了，就复制数组2剩下所有元素
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {  // 如果指针到数组2末尾了，就复制数组1剩下所有元素
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) { // 如果数组1元素小于数组2元素 则把数组1的值赋值给排序数组
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];  // 如果数组2元素小于数组1元素 则把数组2的值赋值给排序数组
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }

    }

    // 方法三 逆向双指针
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int end = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[end--] = cur;
        }
    }



}
