package com.sheldon.code04;

/**
 * @ClassName E02RabbitProblem
 * @Author 26483
 * @Date 2023/12/6 12:10
 * @Version 1.0
 * @Description 斐波那契数列-兔子问题
 */
public class E02RabbitProblem {

    public static void main(String[] args) {
        System.out.println(f(6));
    }

    public static int f(int n){
        if(n==1 || n == 2){
            return 1;
        }
        int x = f(n-1);
        int y = f(n-2);
        return x + y;
    }

}
