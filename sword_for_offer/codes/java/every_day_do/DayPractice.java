package every_day_do;

/**
 * description: 28. 找出字符串中第一个匹配项的下标
 *
 * @author : ghy
 * @date :  2024/3/12
 */

import java.util.Arrays;

/**
 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 示例 1：

 输入：haystack = "sadbutsad", needle = "sad"
 输出：0
 解释："sad" 在下标 0 和 6 处匹配。
 第一个匹配项的下标是 0 ，所以返回 0 。
 示例 2：

 输入：haystack = "leetcode", needle = "leeto"
 输出：-1
 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。


 提示：

 1 <= haystack.length, needle.length <= 104
 haystack 和 needle 仅由小写英文字符组成

 */

class MatchFirstStrSolution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

/**
 35. 搜索插入位置
     给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     请必须使用时间复杂度为 O(log n) 的算法。
 示例 1:
     输入: nums = [1,3,5,6], target = 5
     输出: 2
 示例 2:
     输入: nums = [1,3,5,6], target = 2
     输出: 1
 示例 3:
     输入: nums = [1,3,5,6], target = 7
     输出: 4
 提示:
     1 <= nums.length <= 104
     -104 <= nums[i] <= 104
     nums 为 无重复元素 的 升序 排列数组
     -104 <= target <= 104
 */
class SearchInsertSolution {
    public int searchInsert(int[] nums, int target) {
        // 判定边界
        final int length = nums.length;
        if(nums[0]>target){
            return 0;
        }
        if(nums[length-1]<target){
            return length;
        }
        // target 在nums[] 数值中
        // 要求 O(log n) 时间复杂度--> 二分法？
        int left = 0;
        int right = length-1;
        while(left<=right){
            // 中间点坐标
            int middle = (left + right) / 2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle]>target){
                right = middle-1;
            }else if(nums[middle]<target){
                left =middle+1;
            }
        }
        return left;

    }
}

class LengthOfLastWordSolution {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        for(int i=s1.length-1;i>=0;i--){
            if(s1[i] != " "){
                return s1[i].length();
            }
        }
        return 0;
    }
}

class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int i=length-1;i>=0;i--){
            if(digits[i] == 9){
                digits[i] =0;
            }else{
                digits[i] = digits[i]+1;
                return digits;
            }
        }
        //如果所有位都是进位，则长度+1   特殊情况 99 -》 100这种，初始化数组 0,0,0 将首位设置为1即可
        digits= new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

/**
 2789. 合并后数组中的最大元素
     给你一个下标从 0 开始、由正整数组成的数组 nums 。
     你可以在数组上执行下述操作 任意 次：
     选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
     返回你可以从最终数组中获得的 最大 元素的值。
 示例 1：
    输入：nums = [2,3,7,9,3]
     输出：21
     解释：我们可以在数组上执行下述操作：
     - 选中 i = 1 ，得到数组 nums = [5,7,9,3] 。
     - 选中 i = 0 ，得到数组 nums = [5,16,3] 。
     - 选中 i = 0 ，得到数组 nums = [21,3] 。
     最终数组中的最大元素是 21 。可以证明我们无法获得更大的元素。
 示例 2：
     输入：nums = [5,3,3]
     输出：11
     解释：我们可以在数组上执行下述操作：
     - 选中 i = 1 ，得到数组 nums = [5,6] 。
     - 选中 i = 0 ，得到数组 nums = [11] 。
     最终数组中只有一个元素，即 11 。
 提示：
     1 <= nums.length <= 105
     1 <= nums[i] <= 106
 */
class MaxArrayValueSolution {
    /**
     贪心

     */
    public long maxArrayValue(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        long sum = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            sum = sum>=nums[i]? sum+nums[i]:nums[i];
        }
        return sum;
    }
}

/**
 2312. 卖木头块
     给你两个整数 m 和 n ，分别表示一块矩形木块的高和宽。同时给你一个二维整数数组 prices ，其中 prices[i] = [hi, wi, pricei] 表示你可以以 pricei 元的价格卖一块高为 hi 宽为 wi 的矩形木块。
     每一次操作中，你必须按下述方式之一执行切割操作，以得到两块更小的矩形木块：
     沿垂直方向按高度 完全 切割木块，或
     沿水平方向按宽度 完全 切割木块
     在将一块木块切成若干小木块后，你可以根据 prices 卖木块。你可以卖多块同样尺寸的木块。你不需要将所有小木块都卖出去。你 不能 旋转切好后木块的高和宽。
     请你返回切割一块大小为 m x n 的木块后，能得到的 最多 钱数。
     注意你可以切割木块任意次。

 示例 1：
     输入：m = 3, n = 5, prices = [[1,4,2],[2,2,7],[2,1,3]]
     输出：19
     解释：上图展示了一个可行的方案。包括：
     - 2 块 2 x 2 的小木块，售出 2 * 7 = 14 元。
     - 1 块 2 x 1 的小木块，售出 1 * 3 = 3 元。
     - 1 块 1 x 4 的小木块，售出 1 * 2 = 2 元。
     总共售出 14 + 3 + 2 = 19 元。
     19 元是最多能得到的钱数。
 示例 2：
     输入：m = 4, n = 6, prices = [[3,2,10],[1,4,2],[4,1,3]]
     输出：32
     解释：上图展示了一个可行的方案。包括：
     - 3 块 3 x 2 的小木块，售出 3 * 10 = 30 元。
     - 1 块 1 x 4 的小木块，售出 1 * 2 = 2 元。
     总共售出 30 + 2 = 32 元。
     32 元是最多能得到的钱数。
     注意我们不能旋转 1 x 4 的木块来得到 4 x 1 的木块。
 提示：
     1 <= m, n <= 200
     1 <= prices.length <= 2 * 10^4
     prices[i].length == 3
     1 <= hi <= m
     1 <= wi <= n
     1 <= pricei <= 106
     所有 (hi, wi) 互不相同 。
 */
// todo

/**
 303. 区域和检索 - 数组不可变
    给定一个整数数组  nums，处理以下类型的多个查询:
     计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
     实现 NumArray 类：
     NumArray(int[] nums) 使用数组 nums 初始化对象
     int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 示例 1：
     输入：
     ["NumArray", "sumRange", "sumRange", "sumRange"]
     [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     输出：
     [null, 1, -1, -3]
     解释：
     NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
     numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
     numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 提示：
     1 <= nums.length <= 104
     -105 <= nums[i] <= 105
     0 <= i <= j < nums.length
     最多调用 104 次 sumRange 方法
  */

class NumArray {

    public NumArray(int[] nums) {

    }

    public int sumRange(int left, int right) {
        return 0;
    }
}

/**
 322. 零钱兑换
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     你可以认为每种硬币的数量是无限的。
 示例 1：
     输入：coins = [1, 2, 5], amount = 11
     输出：3
     解释：11 = 5 + 5 + 1
 示例 2：
     输入：coins = [2], amount = 3
     输出：-1
 示例 3：
     输入：coins = [1], amount = 0
     输出：0
 提示：
     1 <= coins.length <= 12
     1 <= coins[i] <= 231 - 1
     0 <= amount <= 104

 */
class CoinChangeSolution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-99);
        return dpCoinAmount(coins,amount);
    }

    private int dpCoinAmount(int[] coins, int amount){
        // 结束标识
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(memo[amount] != -99){
            return memo[amount];
        }
        // 定义 钱币初始数量
        int coinNum = Integer.MAX_VALUE;
        // 循环遍历各种钱币扣减情况
        for(int i=0;i<coins.length;i++){
            int min = dpCoinAmount(coins,amount - coins[i]);
            if(min < 0){
                continue;
            }
            coinNum = Math.min(coinNum,min+1);
        }
        memo[amount] = coinNum == Integer.MAX_VALUE ? -1 : coinNum;
        return memo[amount];
    }
}

public class DayPractice {

    public static void main(String[] args) {

        int[] nums = {1,2,5};
        CoinChangeSolution solution = new CoinChangeSolution();
        solution.coinChange(nums,100);
        System.out.println("999");

    }
}
