package every_day_do;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
}

/**
 560. 和为 K 的子数组
     给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     子数组是数组中元素的连续非空序列。
 示例 1：
     输入：nums = [1,1,1], k = 2
     输出：2
 示例 2：
     输入：nums = [1,2,3], k = 3
     输出：2
 提示：
     1 <= nums.length <= 2 * 10^4
     -1000 <= nums[i] <= 1000
     -10^7 <= k <= 10^7
 */

class SubArraySumSolution {

    public int subarraySumForce(int[] nums, int k) {
        int res = 0;
        // 原始，  暴力解法
        for(int i =0;i<nums.length;i++){
            int sum = 0;
            for(int j = i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum == k){
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // 用于记录当前已经存在的可以计算出来的值，即计算出当前值的次数
        Map<Integer,Integer> resMap = new HashMap<>();
        resMap.put(0,1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            if(resMap.containsKey(sum-k)){
                res = res+ resMap.get(sum-k);
            }
            resMap.put(sum,resMap.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
