package every_day_do;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAnagramsSolution solution = new FindAnagramsSolution();
        solution.findAnagrams(s,p);
        System.out.println("sss");
    }
}

/**
 438. 找到字符串中所有字母异位词
     给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 示例 1:
     输入: s = "cbaebabacd", p = "abc"
     输出: [0,6]
     解释:
     起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:
     输入: s = "abab", p = "ab"
     输出: [0,1,2]
     解释:
     起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 提示:
     1 <= s.length, p.length <= 3 * 10^4
     s 和 p 仅包含小写字母
 */
class FindAnagramsSolution {

    /**

     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sL = s.length();
        int pL = p.length();
        if(sL < pL){
            return res;
        }
        int[] sInts = new int[26];
        int[] pInts = new int[26];
        // 0-pL 长度 放入对应 26位数组中
        for(int i =0;i<pL;i++){
            sInts[s.charAt(i)-'a'] = ++sInts[s.charAt(i)-'a'];
            pInts[p.charAt(i)-'a'] = ++pInts[p.charAt(i)-'a'];
        }
        // 初始判断
        if(Arrays.equals(sInts,pInts)){
            res.add(0);
        }
        // 从 pL长度开始遍历 s中剩余长度，依次向后滑动，判断数组中值是否相等
        for(int i = 0;i<sL-pL;i++){
            // 移出 i 位置出 s中字母
            sInts[s.charAt(i) - 'a'] = --sInts[s.charAt(i) - 'a'];
            // 将 i+pL 位置出 s中字母放入
            sInts[s.charAt(i+pL) - 'a'] = ++sInts[s.charAt(i+pL) - 'a'];

            // 判断是否相等
            if(Arrays.equals(sInts,pInts)){
                res.add(i+1);
            }
        }
        return res;

    }
}
