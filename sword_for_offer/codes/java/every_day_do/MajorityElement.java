package every_day_do;

/**
 * description:
 *
 * @author : ghy
 * @date : 2024/6/24
 */


import java.util.HashMap;
import java.util.Map;

/**
 169. 多数元素
     给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 示例 1：
     输入：nums = [3,2,3]
     输出：3
 示例 2：
     输入：nums = [2,2,1,1,1,2,2]
     输出：2
 提示：
     n == nums.length
     1 <= n <= 5 * 104
     -109 <= nums[i] <= 109
 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */

public class MajorityElement {

    public static void main(String[] args) {
        // ======= Test Case =======  [1,3,1,1,4,1,1,5,1,1,6,2,2]
        int[] nums = { 1,3,1,1,4,1,1,5,1,1,6,2,2};
        // ====== Driver Code ======
        MajorityElementSolution elementSolution = new MajorityElementSolution();
        final int returnInt = elementSolution.majorityElement(nums);
        System.out.println(returnInt);
    }
}


class MajorityElementSolution {

    /**
     * 1、结合hashMap 统计数组中各个数字所占个数
     *
     */
    public int majorityElement(int[] nums) {
        //
        Map<Integer,Integer> numMap = new HashMap<>(nums.length);
        // 遍历数组，统计数字
        for(int i = 0; i<nums.length;i++){
            if(numMap.containsKey(nums[i])){
                numMap.put(nums[i],numMap.get(nums[i])+1);
            }else{
                numMap.put(nums[i],1);
            }
            if(numMap.get(nums[i])*2 > nums.length){
                return nums[i];
            }
        }
        return nums[nums.length-1];

    }

    /**
     * 1、
     */
    public int maiorityElement2(int[] nums){

        int count = 0;
        Integer element = null;
        for (int num : nums){
            if(count == 0){
                element = num;
            }
            count += (num == element) ? 1:-1;
        }
        return element;
    }
}
