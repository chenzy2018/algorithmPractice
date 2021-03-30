package main.java.com.org.czy.leetcode;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */
public class NC52CilcleList {

    public boolean isValid (String s) {
        boolean flag = true;
        while(flag){
            int len = s.length();
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
            if(s.length() == len){
                flag = false;
            }
        }
        return s.length() == 0;
    }

    //压栈法
    public boolean isValid1 (String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
            else if(s.charAt(i) == ']' && stack.peek() == '[') stack.pop();
            else if(s.charAt(i) == '}' && stack.peek() == '{') stack.pop();
            else stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }
}
