package every_day_do;

import java.util.ArrayList;
import java.util.List;

/***
 *@description :
 *@author : ghy
 *@create : 2024/9/3
 **/
public class SetMatrixZeroes {

    public static void main (String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10},{15,18}};
        SetMatrixZeroesSolution solution = new SetMatrixZeroesSolution();
        solution.setZeroes(intervals);
    }
}

/**
 73. 矩阵置零
     给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 示例 1：
     输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
     输出：[[1,0,1],[0,0,0],[1,0,1]]
 示例 2：
     输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 提示：
     m == matrix.length
     n == matrix[0].length
     1 <= m, n <= 200
     -2^31 <= matrix[i][j] <= 2^31 - 1
 进阶：
     一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     你能想出一个仅使用常量空间的解决方案吗？
 */
class SetMatrixZeroesSolution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        System.out.println(m);
        System.out.println(n);

        boolean[] lines = new boolean[m];
        boolean[] rows = new boolean[n];

        //初次遍历  标记对应 行列 那些需要标记为零
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    lines[i] = true;
                    rows[j] = true;
                }
            }
        }
        // 再次遍历 修改原 数组
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(lines[i] || rows[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
