package every_day_do;

import include.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 *
 * @author : ghy
 * @date : 2024/7/10
 */
public class HasCycle {
}

/**
 141. 环形链表
     给你一个链表的头节点 head ，判断链表中是否有环。
     如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 示例 1：
     输入：head = [3,2,0,-4], pos = 1
     输出：true
     解释：链表中有一个环，其尾部连接到第二个节点。
 示例 2：
     输入：head = [1,2], pos = 0
     输出：true
     解释：链表中有一个环，其尾部连接到第一个节点。
 示例 3：
     输入：head = [1], pos = -1
     输出：false
     解释：链表中没有环。
 提示：
     链表中节点的数目范围是 [0, 10^4]
     -10^5 <= Node.val <= 10^5
     pos 为 -1 或者链表中的一个 有效索引 。
 进阶：你能用 O(1)（即，常量）内存解决此问题吗？

 */
class HasCycleSolution {

    /**
     * 1、基于Hash判断
     */
    public boolean hasCycleHash(ListNode head) {
        // 临界值判断
        if(head == null || head.next == null){
            return false;
        }
        Set<ListNode> nodeSet = new HashSet<>();

        while(head!=null){
            // set中存在重复节点后，直接弹出，存在环
            if(!nodeSet.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * 如果链表中，慢节点和快节点再次相遇，则代表其中有环
     */
    public boolean hasCycleSlowFast(ListNode head) {
        // 临界值判断
        if(head == null || head.next == null){
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        // 依次向下遍历
        while(slowNode != fastNode){
            // 当快节点，遍历到null，链表结束，则不存在环
            if(fastNode == null || fastNode.next == null){
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        // 退出条件，重合
        return true;
    }
}
