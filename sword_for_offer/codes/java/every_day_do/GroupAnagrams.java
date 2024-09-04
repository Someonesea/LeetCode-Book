package every_day_do;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
}

/**
 49. 字母异位词分组
     给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 示例 1:
     输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 示例 2:
     输入: strs = [""]
     输出: [[""]]
 示例 3:
     输入: strs = ["a"]
     输出: [["a"]]
 提示：
     1 <= strs.length <= 10^4
     0 <= strs[i].length <= 100
     strs[i] 仅包含小写字母
 */
class GroupAnagramsSolution {

    /**
     * 加载 -- 使用 -- 卸载
     * 加载 ： 加载 -- 连接（检验（文件格式、字节码、二进制兼容、元数据）--准备--解析） -- 初始化
     *
     * 初始化：new、静态变量、静态方法、反射、main方法、初始化类，父类未被加载
     */

    /**
     * hash
     * 1、想办法把 相同字母组成的字符串初始化成相同的key
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        // 定义一个hashMap
        Map<String,List<String>> map = new HashMap<>();
        //
        for(String str:strs){
            String key = getHashString(str, 0, str.length());
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.put(key,strings);
        }
        return new ArrayList<>(map.values());
    }

    private String getHashString(String s,int begin,int end){
        int[] charNum = new int[26];
        for(int i = begin;i<end;i++){
            int index = s.charAt(i) - 'a';
            charNum[index] = ++charNum[index];
        }
        StringBuilder returnS = new StringBuilder();
        for(int i= 0;i<charNum.length;i++){
            if(charNum[i]>0){
                char ic = (char)('a' + i);
                returnS.append(ic).append(charNum[i]);
            }
        }
        return returnS.toString();
    }
}