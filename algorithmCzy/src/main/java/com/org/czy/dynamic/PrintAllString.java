package main.java.com.org.czy.dynamic;

/**
 * 打印字符串的所有子串，包括空串
 *
 * 当前字符要或者不要
 */
public class PrintAllString {

    public static void printAllString(char[] str, int i, String res){
        if(i == str.length){
            System.out.println(res);
            return;
        }
        printAllString(str, i+1, res+" ");//当前字符不要
        printAllString(str, i+1, res+String.valueOf(str[i]));//当前字符要
    }

    public static void main(String[] args) {
        printAllString("abc".toCharArray(),  0, "");
    }
}
