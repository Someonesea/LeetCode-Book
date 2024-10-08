package every_day_do;

/**
 * description: 108. 将有序数组转换为二叉搜索树
 *
 * @author : ghy
 * @date : 2024/7/1
 */

import include.TreeNode;

/**
 108. 将有序数组转换为二叉搜索树
    给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
 示例 1：
     输入：nums = [-10,-3,0,5,9]
     输出：[0,-3,9,-10,null,5]
     解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 示例 2：
     输入：nums = [1,3]
     输出：[3,1]
     解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 提示：
     1 <= nums.length <= 104
     -104 <= nums[i] <= 104
     nums 按 严格递增 顺序排列

 */
public class SortedArrayToBST {
}

/**
 前序  中左右

 中序  左中右

 后序  左右中




 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SortedArrayToBSTSolution {
    public TreeNode sortedArrayToBST(int[] nums) {


        return new TreeNode(nums[0]);

    }
}
