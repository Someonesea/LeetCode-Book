package every_day_do;

/**
 509. 斐波那契数
     斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     F(0) = 0，F(1) = 1
     F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     给定 n ，请计算 F(n) 。
 示例 1：
     输入：n = 2
     输出：1
     解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 示例 2：
     输入：n = 3
     输出：2
     解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 示例 3：
     输入：n = 4
     输出：3
     解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 提示：
 0 <= n <= 30
 */

class FibSolution {
    /**
     * 最简单的
     * 递归 从顶向下
     */
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    /**
     * 上面第一种，存在大量重复计算，效率不高，可以将所有已计算的结果，存储下来，然后直接取
     *
     *
     */
    public int fib2(int n){
        if(n==0 || n==1){
            return n;
        }
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        for(int i=2;i<=n;i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];

    }
    public int fib3(int n){
        if(n==0 || n==1){
            return n;
        }
        int a1=0;
        int a2=1;
        int a = 0;
        for(int i=2;i<=n;i++){
            a = a2+a1;
            a1 = a2;
            a2 = a;
        }
        return a;

    }
    public int fib4(int n){
        if(n==0 || n==1){
            return n;
        }
        int a1=0;
        int a2=1;
        for(int i=2;i<=n;i++){
            a2 = a1+a2;
            a1 = a2-a1;
        }
        return a2;

    }


    /**
     * 自底向上
     * 遍历
     */
    public int fib44(int n) {

        return n;
    }
}


/**
 * description:
 *
 * @author : ghy
 * @date : 2024/3/19
 */
public class ClassicQuestion {

    public static void main(String[] args) {

    }
}
