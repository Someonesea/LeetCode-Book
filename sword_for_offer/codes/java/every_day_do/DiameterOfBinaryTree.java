package every_day_do;

import include.TreeNode;

public class DiameterOfBinaryTree {
}


/**
 543. 二叉树的直径
     给你一棵二叉树的根节点，返回该树的 直径
     二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     两节点之间路径的 长度 由它们之间边数表示。
 示例 1：
     输入：root = [1,2,3,4,5]
     输出：3
     解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 示例 2：
     输入：root = [1,2]
     输出：1
 提示：

 树中节点数目在范围 [1, 104] 内
 -100 <= Node.val <= 100
 */
class DiameterOfBinaryTreeSolution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        maxDepth(root);
        return ans;
    }

    /**
     * 当前节点最大深度
     */
    private int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int right = maxDepth(node.right);
        int left = maxDepth(node.left);
        ans = Math.max(ans,right+left);
        return Math.max(right,left)+1;
    }
}