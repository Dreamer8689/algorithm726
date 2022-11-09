package com.dreamer.algorithm.day20221109_sort;

public class BubbleSort {

    // 冒泡排序
    public int[] sortArray(int[] nums) {

        if (nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {


            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }

        }

        return nums;

    }
}
