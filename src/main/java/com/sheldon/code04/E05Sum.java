package com.sheldon.code04;

/**
 * @ClassName E05Sum
 * @Author 26483
 * @Date 2023/12/6 12:41
 * @Version 1.0
 * @Description 递归-爆栈问题
 */
public class E05Sum {

    public static void main(String[] args) {
        System.out.println(sum(1000000));
    }

    public static Long sum(long n) {
        if (n == 1L) {
            return 1L;
        }
        return n + sum(n - 1);
    }


}
