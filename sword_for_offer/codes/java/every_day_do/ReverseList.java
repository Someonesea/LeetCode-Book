package every_day_do;

import include.ListNode;

/**
 * description:
 *
 * @author : ghy
 * @date : 2024/7/10
 */
public class ReverseList {
}
/**
 206. 反转链表
     给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 示例 1：
     输入：head = [1,2,3,4,5]
     输出：[5,4,3,2,1]
 示例 2：
     输入：head = [1,2]
     输出：[2,1]
 示例 3：
     输入：head = []
     输出：[]
 提示：
     链表中节点的数目范围是 [0, 5000]
     -5000 <= Node.val <= 5000
 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */


class ReverseListSolution {

    /**
     *  迭代
     *  定义 当前节点、尾节点，改变指向
     */
    public ListNode reverseListIteration(ListNode head) {

        if(head == null){
            return head;
        }
        ListNode reverseNode = head;
        ListNode tailNode = null;

        while (reverseNode !=null){
            // 记录当前指向下一节点
            ListNode next = reverseNode.next;
            // 当前节点的指向改变为当前尾节点
            reverseNode.next = tailNode;
            // 那么下一节点的尾结点就为当前循环节点
            tailNode = reverseNode;
            // 当前节点的下一节点，为下一循环的当前节点
            reverseNode = next;
        }
        return tailNode;
    }

    /**
     * 递归
     *  1,2,3,4,5
     *
     *  5,4,3,2,1
     */
    public ListNode reverseListRecursion(ListNode head) {
        //
        if(head.next == null){
            return head;
        }
        // 从最内层节点开始依次改变顺序返回
        ListNode preNode = reverseListRecursion(head.next);
        // 倒转方向
        // todo 这块还是不太理解
        head.next.next = head;
        head.next = null;
        return preNode;
    }
}