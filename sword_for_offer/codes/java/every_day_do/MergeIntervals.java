package every_day_do;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/***
 *@description :
 *@author : ghy
 *@create : 2024/9/3
 **/
public class MergeIntervals {

    public static void main (String[] args) {
        MergeIntervalsSolution solution = new MergeIntervalsSolution();
        int[][] intervals = {{1,3}, {2,6}, {8,10},{15,18}};
        int[][] merge = solution.merge(intervals);
        System.out.println(merge);
    }

}

/**
  56. 合并区间
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 示例 1：
     输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     输出：[[1,6],[8,10],[15,18]]
     解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：
     输入：intervals = [[1,4],[4,5]]
     输出：[[1,5]]
     解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 提示：
     1 <= intervals.length <= 10^4
     intervals[i].length == 2
     0 <= starti <= endi <= 10^4
 */

class MergeIntervalsSolution {
    /**
     * 先排序
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 排序
        List<int[]> ints = Arrays.stream(intervals).sorted(Comparator.comparing(e->e[0])).collect(Collectors.toList());
        List<int[]> reList = new ArrayList<>();
        int last = 0;
        reList.add(ints.get(last));
        for(int i=1;i<ints.size();i++){
            // 前一个为 独立区间
            if(ints.get(i)[0]>reList.get(last)[1]){
                last ++;
                reList.add(ints.get(i));
                continue;
            }
            // 前一个区间与当前区间存在交集
            // 当前区间后置位置，大于前一位置后置位置
            if(ints.get(i)[1]>=reList.get(last)[1]){
                int[] index = {reList.get(last)[0],ints.get(i)[1]};
                reList.set(last,index);
                continue;
            }
            // 当前区间后置位置，小于前一位置后置位置
        }


        return reList.toArray(new int[0][]);


    }
}
