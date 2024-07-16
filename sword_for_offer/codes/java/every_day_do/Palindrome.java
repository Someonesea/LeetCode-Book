package every_day_do;

import include.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ghy
 * @date : 2024/7/8
 */
public class Palindrome {

    public static void main(String[] args) {
        ListNode head = ListNode.arrToLinkedList(new int[] { 1, 2 });
        IsPalindromeSolution solution = new IsPalindromeSolution();
        solution.isPalindromeSlowFast(head);
        System.out.println("333333");
    }

}

/**
 234. 回文链表
     给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 示例 1：
     输入：head = [1,2,2,1]
     输出：true
 示例 2：
     输入：head = [1,2]
     输出：false
 提示：
     链表中节点数目在范围[1, 105] 内
     0 <= Node.val <= 9
     进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
class IsPalindromeSolution {

    /**
     *  1、将链表数转存数组
     *  2、双指针分别从头尾遍历，看是否相同
     *  时间复杂度  O(2n) == O(n)
     *  空间复杂度  O(n)
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> nodeList = new ArrayList<>();

        while (head!=null){
            nodeList.add(head.val);
            head = head.next;
        }

        for(int i=0;i<nodeList.size();i++){
            if(!nodeList.get(i).equals(nodeList.get(nodeList.size()-i-1))){
                return false;
            }
            if(i>nodeList.size()-i-1){
                return true;
            }
        }
        return true;

    }

    /**
     * 时间复杂度  O(n)  空间复杂度O(1)  todo
     * 1、快慢指针找到  链表中间点
     * 2、后半段链表反转
     * 3、依次对比
     * 4、恢复链表
     * 5、返回结果
     */
    public boolean isPalindromeSlowFast(ListNode head) {

        ListNode slowNode = head;
        ListNode fastNode = head;
        // 找到中点位置 奇数个节点，中点在前半段
        while(fastNode !=null && fastNode.next !=null && slowNode !=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        // 根据慢指针 ，反转后半部分链表
        ListNode reversalNode = slowNode.next;
        ListNode tailNode = null;
        while (reversalNode != null){
            ListNode nextNode = reversalNode.next;
            reversalNode.next = tailNode;
            tailNode =reversalNode;
            reversalNode = nextNode;
        }
        // 遍历比较反转指针与前半段
        while(tailNode!=null && head != null){
            if (tailNode.val != head.val){
                return false;
            }
            tailNode = tailNode.next;
            head = head.next;
        }
        return true;

    }
}
