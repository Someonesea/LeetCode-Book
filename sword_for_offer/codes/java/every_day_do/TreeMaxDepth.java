package every_day_do;


import include.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class TreeMaxDepth {
}

/**
 104. 二叉树的最大深度
 给定一个二叉树 root ，返回其最大深度。
 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 示例 1：
 输入：root = [3,9,20,null,null,15,7]
 输出：3
 示例 2：
 输入：root = [1,null,2]
 输出：2
 提示：
 树中节点的数量在 [0, 104] 区间内。
 -100 <= Node.val <= 100
 */
class MaxDepthSolution {

    /**
     * 递归方案
     * 深度优先遍历  DFS--Depth-First Search
     *
     * @param root :根节点
     * @return ：返回最大深度
     */
    public int maxDepthDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 分别遍历左右节点
        int left = maxDepthDFS(root.left);
        int right = maxDepthDFS(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 广度优先算法 BFS  Breadth-First Search
     */
    public int maxDepthBFS(TreeNode root) {

        if(root == null) {
            return 0;
        }
        // 定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }

            }
            depth ++;
        }
        return depth;
    }
}
