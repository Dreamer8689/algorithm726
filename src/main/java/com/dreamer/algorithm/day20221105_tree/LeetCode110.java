package com.dreamer.algorithm.day20221105_tree;


import com.dreamer.algorithm.common.TreeNode;

/**
 * 题目LeetCode-110  给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
