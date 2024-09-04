package every_day_do;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
}

/**

 239. 滑动窗口最大值
     给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     返回 滑动窗口中的最大值 。
 示例 1：
     输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     输出：[3,3,5,5,6,7]
     解释：
     滑动窗口的位置                最大值
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
 示例 2：
     输入：nums = [1], k = 1
     输出：[1]
 提示：
     1 <= nums.length <= 105
     -104 <= nums[i] <= 104
     1 <= k <= nums.length
 */
class MaxSlidingWindowSolution {
    /**
     * 暴力解法  超时，我靠
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowForce(int[] nums, int k) {
        int max = nums[0];
        int[] res = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // 首个k
            if(i<k){
                max = Math.max(max,nums[i]);
                if(i==k-1){
                    res[0]=max;
                }
                continue;
            }
            // 遍历超过k
            if(nums[i-k]< max || nums[i] > max){
                max = Math.max(max,nums[i]);
            }else{
                max = nums[i-k+1];
                for(int j = i-k+1;j<=i;j++){
                    max = Math.max(max,nums[j]);
                }
            }
            res[i-k+1] = max;
        }
        return res;
    }

    /**
     滑动窗口 最大值  -- 最大堆

     */
    public int[] maxSlidingWindowHeap(int[] nums, int k) {
        int le = nums.length;
        int[] res = new int[le - k + 1];
        // 基于 数组 实现一个最大堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[0] != a2[0] ? a2[0] - a1[0] : a2[1] - a1[1]);
        // 首先放入前 k 个数据
        for(int i = 0;i<k;i++){
            // 放入队列中 int根据前两个坐标区分  0:nums数组对应位置值  1:nums当前位置
            queue.offer(new int[]{nums[i],i});
        }
        res[0] = queue.peek()[0];
        // 遍历 k - le 之间 数组，依次加入最大堆中，并返回堆顶数据
        for(int i=k;i<le;i++){
            // 放入当前元素
            queue.offer(new int[]{nums[i],i});
            // 获取当前堆顶元素，判定是否还在当前 i-le 位置内
            while(queue.peek()[1] <= i-k){
                queue.poll();
            }
            res[i-k+1] =  queue.peek()[0];
        }
        return res;

    }
}
