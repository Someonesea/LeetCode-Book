package every_day_do;

public class Trap {
}

/**
 42. 接雨水
     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 示例 1：
     输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     输出：6
     解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 示例 2：
     输入：height = [4,2,0,3,2,5]
     输出：9
 提示：
     n == height.length
     1 <= n <= 2 * 104
     0 <= height[i] <= 105
 */
class TrapSolution {

    /**
     owner  laji
     双指针
     一开始想的是  从一遍开始，快慢指针
     但是解决不了。。。
     中间可高可低，不同情况，只记录当前的首位位置，行不通

     */
    public int trap(int[] height) {
        int first = 0;
        for(int last = 1;last<height.length;last++){
            // 起始位置为 0  或 当前位置与前一位置无顺差，无法形成面积
            if((height[first] == 0) || (height[first] <= height[last] && first==last-1)){
                first = last;
                continue;
            }
            //

        }
        return 0;
    }

    /**
     双指针   题解版本
     头尾指针
     */
    public int trapDoublePointers(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0,rightMax = 0;
        int res = 0;
        while(left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(height[left]< height[right]){
                res = res + (leftMax-height[left]);
                left ++;
            }else{
                res = res + rightMax - height[right];
                right++;
            }
        }
        return res;
    }


    /**
     动态规划

     */
    public int trapDynamic(int[] height) {
        // todo
        return 0;
    }
}
