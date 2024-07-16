package every_day_do;

public class MaxArea {

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        MaxAreaSolution solution = new MaxAreaSolution();

        int maxArea = solution.maxArea(nums);
        System.out.println("maxArea:"+maxArea);

    }

}

/**
 11. 盛最多水的容器
     给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     返回容器可以储存的最大水量。
 说明：你不能倾斜容器。
 示例 1：
     输入：[1,8,6,2,5,4,8,3,7]
     输出：49
     解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 示例 2：
     输入：height = [1,1]
     输出：1
 提示：
     n == height.length
     2 <= n <= 10^5
     0 <= height[i] <= 10^4

 */
class MaxAreaSolution {

    /**
     * 双层循环
     * 其中 maxH 用于记录当前最大面积对应的 最大 maxH
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int maxH = 0;
        int p = 0;
        int q ;
        // int minHeight = height[0];
        while(p<height.length){
            if(height[p]>maxH ){
                q = p+1;
                while(q<height.length){
                    int h = Math.min(height[p],height[q]);
                    int area = (q - p) * h;
                    if( area > maxArea){
                        maxH = h;
                        maxArea = area;
                    }
                    q++;
                }
            }
            p++;
        }
        return maxArea;
    }


    public int maxAreaTwoPointers(int[] height){

        return 0;
    }
}