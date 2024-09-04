package every_day_do;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
}

/**
 15. 三数之和
     给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     你返回所有和为 0 且不重复的三元组。
     注意：答案中不可以包含重复的三元组。
 示例 1：
     输入：nums = [-1,0,1,2,-1,-4]
     输出：[[-1,-1,2],[-1,0,1]]
     解释：
     nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     注意，输出的顺序和三元组的顺序并不重要。
 示例 2：
     输入：nums = [0,1,1]
     输出：[]
     解释：唯一可能的三元组和不为 0 。
 示例 3：
     输入：nums = [0,0,0]
     输出：[[0,0,0]]
     解释：唯一可能的三元组和为 0 。
 提示：
     3 <= nums.length <= 3000
     -105 <= nums[i] <= 105
 */

class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int one = 0;one<nums.length;one++){
            if(one > 0 && nums[one] == nums[one-1]){
                continue;
            }
            int oneNum = -nums[one];
            int three = nums.length-1;
            for(int two = one+1;two<nums.length;two++){
                if(two>one+1 && nums[two] == nums[two-1]){
                    continue;
                }
                while (two< three && nums[two] + nums[three] > oneNum){
                    three--;
                }
                if(two>=three){
                    break;
                }
                if(nums[two] + nums[three] == oneNum){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[one]);
                    list.add(nums[two]);
                    list.add(nums[three]);
                    res.add(list);
                }

            }
        }
        return res;
    }

    public List<List<Integer>> threeSumPractive(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        for(int i=0;i<length;i++){
            int res = -nums[i];
            int rel = length-1;
            for(int j= i+1;j<length;j++){
                // 当前值与前一位值相等，直接跳过遍历
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if(j >= rel){
                    break;
                }
                while(j<rel && (nums[j] + nums[rel] > res) ){
                    rel--;
                }
                if(nums[j]+nums[rel] == res){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[rel]);
                    resList.add(list);
                }

            }

        }
        return resList;
    }
}