package every_day_do;

import include.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
}

/**
 101. 对称二叉树
     给你一个二叉树的根节点 root ， 检查它是否轴对称。
 示例 1：
     输入：root = [1,2,2,3,4,4,3]
     输出：true
 示例 2：
     输入：root = [1,2,2,null,3,null,3]
     输出：false
 提示：
     树中节点数目在范围 [1, 1000] 内
     -100 <= Node.val <= 100
 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
class IsSymmetricSolution {

    /**
     * 递归方法，分别对比左右节点
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return checkSymmetric(root.right,root.left);
    }

    private boolean checkSymmetric(TreeNode p,TreeNode q){
        // 都为空则  到底，返回
        if(p == null && q == null){
            return true;
        }
        // 其中一个为空，不等 返回
        if(p == null || q == null){
            return false;
        }
        // 判定当前节点值 以及  当前节点的左右节点是否对称
        return p.val == q.val && checkSymmetric(p.right,q.left) && checkSymmetric(p.left,q.right);
    }



    public boolean isSymmetricIteration(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            if(p==null && q==null){
                continue;
            }

            if(p==null || q==null || p.val != q.val){
                return false;
            }
            // 当前节点对应的 下层节点分别左右对应，放入队列
            queue.offer(p.right);
            queue.offer(q.left);

            queue.offer(p.left);
            queue.offer(q.right);
        }
        return true;
    }

}

