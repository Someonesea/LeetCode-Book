package every_day_do;

import java.util.Arrays;

/***
 *@description :
 *@author : ghy
 *@create : 2024/9/3
 **/

public class ProductExceptSelf {

    public static void main (String[] args) {
        ProductExceptSelfSolution solution = new ProductExceptSelfSolution();
        int[] nums = {1,2,3,4};
        solution.productExceptSelf1(nums);
    }


}

/**
 238. 除自身以外数组的乘积
     给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 示例 1:
     输入: nums = [1,2,3,4]
     输出: [24,12,8,6]
 示例 2:
     输入: nums = [-1,1,0,-3,3]
     输出: [0,0,9,0,0]
 提示：
     2 <= nums.length <= 10^5
     -30 <= nums[i] <= 30
    保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */
class ProductExceptSelfSolution {

    /**
     * 存在除法的   垃圾
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] re = new int[nums.length];
        int zero = 0;
        int ex = 1;
        for(int i =1;i<nums.length;i++){
            if(nums[i] == 0){
                if(zero != 0){
                    // 多个 0
                    return re;
                }
                zero = i;
            }
            ex = ex * nums[i];
        }
        // 1- nums.length 里面存在一个 在 zero 位置的 0
        if(zero != 0){
            int zeroEx = 1;
            for(int i = 0;i<nums.length;i++){
                if(i == 0 && nums[i] == 0){
                    return re;
                }
                if(i != zero){
                    zeroEx = zeroEx * nums[i];
                }
            }
            re[zero] = zeroEx;
            return re;
        }
        // 1- nums.length 里面不存在 0
        for(int i = 0;i<nums.length;i++){
            if(i == 0 && nums[i] == 0){
                re[0] = ex;
                return re;
            }
            // 都不为 0
            if(i == 0){
                re[i] = ex;
            }else{
                re[i] = ex/nums[i]*nums[0];
            }
        }
        return re;
    }

    /**
     * 双指针
     */

    public int[] productExceptSelf1(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int beforeSum=1;
        int afterSum=1;
        for(int i=0,j=n-1;i<n;i++,j--){
            ans[i]*=beforeSum;
            ans[j]*=afterSum;
            beforeSum*=nums[i];
            afterSum*=nums[j];
        }
        return ans;
    }
}
