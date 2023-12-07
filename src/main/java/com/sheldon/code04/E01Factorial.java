package com.sheldon.code04;

/**
 * @ClassName E01Factorial
 * @Author 26483
 * @Date 2023/12/6 12:08
 * @Version 1.0
 * @Description 递归求斐波那契数列
 */
public class E01Factorial {

    public static void main(String[] args) {
        System.out.println(f(1));
        System.out.println(f(2));
        System.out.println(f(3));
    }

    public static int f(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int x = f(n - 1);
        int y = f(n - 2);
        return x + y;
    }

}
