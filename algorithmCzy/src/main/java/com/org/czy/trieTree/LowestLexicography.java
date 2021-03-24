package main.java.com.org.czy.trieTree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所
 * 有字 符串拼起来之后形成的字符串具有最低的字典序。
 *
 * 字典序：
 *  按照字典顺序排序 ： a<b<c<....
 *
 *  比如：abc < acb , ac < ace , abedsg < ac
 *
 *
 */
public class LowestLexicography {

    static class MyCompare implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }

    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0) return "";

        Arrays.sort(strs, new MyCompare());

        StringBuilder res = new StringBuilder();
        for(String str : strs){
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
