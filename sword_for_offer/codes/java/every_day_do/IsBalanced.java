package every_day_do;

import include.TreeNode;

public class IsBalanced {
}

/**
 110. 平衡二叉树
     给定一个二叉树，判断它是否是
     平衡二叉树
 示例 1：
     输入：root = [3,9,20,null,null,15,7]
     输出：true
 示例 2：
     输入：root = [1,2,2,3,3,null,null,4,4]
     输出：false
 示例 3：
     输入：root = []
     输出：true
 提示：
     树中的节点数在范围 [0, 5000] 内
     -104 <= Node.val <= 104
 */
class IsBalancedSolution {
    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right)) <=1 && isBalanced(root.right) && isBalanced(root.left);

    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.right),height(root.left))+1;
    }
}