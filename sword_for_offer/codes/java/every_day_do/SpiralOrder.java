package every_day_do;

import java.util.ArrayList;
import java.util.List;


/***
 *@description
 *@author : ghy
 *@create : 2024/9/4
 **/
public class SpiralOrder {

    public static void main (String[] args) {
        //int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralOrderSolution solution = new SpiralOrderSolution();
        solution.spiralOrder(m);
    }
}

/**
 54. 螺旋矩阵
     给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 示例 1：
     输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     输出：[1,2,3,6,9,8,7,4,5]
 示例 2：
     输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 提示：
     m == matrix.length
     n == matrix[i].length
     1 <= m, n <= 10
     -100 <= matrix[i][j] <= 100
 */

class SpiralOrderSolution {
    /**
     *   错啦！！！ 垃圾
     *   题目你都看错了   是顺时针，不是来回穿  垃圾
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrderLJ(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;

        List<Integer> re = new ArrayList<>();
        boolean flag = true;

        for(int i = 0;i < m ;i++){

            if(flag){
                for(int j = 0;j < n ;j++){
                    re.add(matrix[i][j]);
                }
                flag = false;
            }else{
                for(int j=n-1;j>=0;j--){
                    re.add(matrix[i][j]);
                }
                flag = true;
            }

        }
        return re;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> re = new ArrayList<>();
        int top = 0,down = matrix.length-1,left = 0,right = matrix[0].length-1;

        while(top<=down && left <= right){
            for(int i = left;i<=right;i++){
                re.add(matrix[top][i]);
            }
            top ++;
            for(int i = top;i<=down;i++){
                re.add(matrix[i][right]);
            }
            right --;
            for(int i = right;i>=left && top<=down;i--){
                re.add(matrix[down][i]);
            }
            down --;
            for(int i = down;i>=top && left <= right;i--){
                re.add(matrix[i][left]);
            }
            left ++;
        }
        return re;

    }
}