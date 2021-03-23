package main.java.com.org.czy.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全排列
 */

public class PrintAllPermutation {

    private static List<String> list = new ArrayList<>();

    public static void printAllPermutation(String str, String res){
        if(str.length() == 0){
            System.out.println(res);
            return;
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            printAllPermutation(str.substring(0,i)+str.substring(i+1,len),res+str.substring(i,i+1));
        }

    }

    /**
     * 打印所有不重复子串
     */
    public static void printAllPermutation1(String str, String res){
        if(str.length() == 0){
            if(list.contains(res)){
                return;
            }else{
                System.out.println(res);
                list.add(res);
                return;
            }

        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            printAllPermutation1(str.substring(0,i)+str.substring(i+1,len),res+str.substring(i,i+1));
        }

    }

    public static void process1(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            process1(chs, i + 1);
            //swap(chs, i, j);
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        printAllPermutation("abc", "");
        printAllPermutation1("aabc", "");
    }
}
