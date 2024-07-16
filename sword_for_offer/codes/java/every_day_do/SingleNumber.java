package every_day_do;

/**
 * description:
 *
 * @author : ghy
 * @date : 2024/7/1
 */

import java.util.HashMap;
import java.util.Map;

/**

 136. 只出现一次的数字
     给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 示例 1 ：
     输入：nums = [2,2,1]
     输出：1
 示例 2 ：
     输入：nums = [4,1,2,1,2]
     输出：4
 示例 3 ：
     输入：nums = [1]
     输出：1
 提示：
     1 <= nums.length <= 3 * 104
     -3 * 104 <= nums[i] <= 3 * 104
     除了某个元素只出现一次以外，其余每个元素均出现两次。

 */

public class SingleNumber {

    public static void main(String[] args) {

    }

}

class SingleNumberSolution{

    /**
     * 笨方法
     * HashMap 存放数字，不存在放入，存在的，移出
     *  时间复杂度  O(n)  空间复杂度 O(n)
     */
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> returnMap = new HashMap<>();

        // nums.length >= 1 直接遍历
        for(int i = 0; i<nums.length;i++){
            if(returnMap.containsKey(nums[i])){
                returnMap.remove(nums[i]);
            }else{
                returnMap.put(nums[i],nums[i]);
            }
        }
        for(Integer key : returnMap.keySet()){
            return key;
        }
        return 0;
    }

    /**
     * 如果想满足 实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     * 答案是使用位运算。对于这道题，可使用异或运算 ⊕。异或运算有以下三个性质。
     * 1、任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 2、任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 3、异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     *
     */
    public int singleNumberTrue(int[] nums){

        int returnNum = 0;
        for(int num : nums){
            returnNum ^= num;
        }
        return returnNum;
    }

}
