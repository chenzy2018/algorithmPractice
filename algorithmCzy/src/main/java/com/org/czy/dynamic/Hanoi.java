package main.java.com.org.czy.dynamic;

/**
 * 汉诺塔
 */
public class Hanoi {

    public static void process(int n, String from, String to, String help){
        if(n == 1){
            System.out.println("move " + n + " " + from + " to " + to);
        }else{
            /**
             * 第一步：把n-1从form挪到help
             * 第二步：把n从from挪到to
             * 第三步：把n-1从help挪到to
             */
            process(n-1, from, help, to);
            System.out.println("move "+n + " from "+ from + " to " + to);
            process(n-1,help, to, from);
        }
    }

    public static void main(String[] args) {
        process(4,"左","右","中");
    }
}
