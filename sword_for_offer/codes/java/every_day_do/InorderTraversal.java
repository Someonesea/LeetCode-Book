package every_day_do;

import include.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description:
 *
 * @author : ghy
 * @date : 2024/7/5
 */

/**
 94. 二叉树的中序遍历
    给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 示例 1：
     输入：root = [1,null,2,3]
     输出：[1,3,2]
     示例 2：
     输入：root = []
     输出：[]
 示例 3：
     输入：root = [1]
     输出：[1]
 */
class InorderTraversalSolution {

    /**
     * 中序：   左 根 右
     * 1、 递归遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> returnList = new ArrayList<>();
        recursiveTraversal(root,returnList);
        return returnList;

    }

    /**
     * 递归
     * @param node
     * @param list
     */
    private void recursiveTraversal(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        recursiveTraversal(node.left,list);
        list.add(node.val);
        recursiveTraversal(node.right,list);
    }

    /**
     *  结合栈  stack 采用迭代的方式实现
     *
     */
    public List<Integer> iteratorTraversal(TreeNode root) {
        // 实际需要返回list
        List<Integer> returnList = new ArrayList<>();
        // 中间栈，依赖其先入后出特性
        Stack<TreeNode> stack = new Stack<>();
        // 遍历边界校验，当前root点为空，并且，栈中都无数据时跳出
        while(root !=null || !stack.empty()){
            // 中序遍历，左中右，先遍历左子树，优先放入当前根节点，再放入左节点
            while(root !=null){
                stack.push(root);
                root = root.left;
            }
            // 遍历到最下层左子树后，依次弹出，左先弹出，然后再中，后续找到对应根节点右子树
            root = stack.pop();
            returnList.add(root.val);
            root = root.right;
        }
        return returnList;

    }
}

public class InorderTraversal {
    public static void main(String[] args) {
        System.out.println("99999");
    }
}
