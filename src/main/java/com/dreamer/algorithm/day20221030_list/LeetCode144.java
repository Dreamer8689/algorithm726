package com.dreamer.algorithm.day20221030_list;


import com.dreamer.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 144
 * 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */
public class LeetCode144 {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return result;
    }

}
