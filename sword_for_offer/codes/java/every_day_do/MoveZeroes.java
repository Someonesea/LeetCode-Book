package every_day_do;

/**
 * description:  283. 移动零
 *
 * @author : ghy
 * @date : 2024/6/25
 */

import include.ListNode;

/**
 283. 移动零
     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 示例 1:
     输入: nums = [0,1,0,3,12]
     输出: [1,3,12,0,0]
 示例 2:
     输入: nums = [0]
     输出: [0]
 提示:
     1 <= nums.length <= 104
     -231 <= nums[i] <= 231 - 1
 进阶：你能尽量减少完成的操作次数吗？

 */

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroesSolution solution = new MoveZeroesSolution();
        solution.moveZeroes(nums);
        System.out.println("999999999");
    }

}

class MoveZeroesSolution{

    /**
        双指针
        1、双层嵌套
     */
    public void moveZeroes(int[] nums) {
        // 记录 0 所在位置
        int zeroPos = 0;
        int noZero = 0;

        //
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                continue;
            }
            zeroPos = i;
            if(noZero ==nums.length-1){
                break;
            }
            noZero = Math.max(zeroPos,noZero);
            for(int j = noZero+1;j<nums.length;j++){
                if(nums[j] == 0){
                    noZero = j;
                    continue;
                }
                nums[zeroPos] = nums[j];
                nums[j] = 0;
                noZero = j;
                break;
            }
        }

    }

    /**

     双指针
     1、一次遍历将所有大于0的数字，依次放入数组中
     2、数组剩余位置补零

     */
    public void moveZeroes1(int[] nums) {
        // 记录 0 所在位置
        int zeroPos = 0;
        // 一次遍历将所有大于0的数字，依次放入数组中
        for(int i = 0;i<nums.length;i++){
            if(nums[i] >0){
                nums[zeroPos] = nums[i];
                zeroPos ++;
            }
        }
        // 剩余位置补零
        for(int i = zeroPos;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}


class intersectionNodeSolution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        return headA;
    }
}
