package com.sheldon.code03;

/**
 * @ClassName ReversePrintString
 * @Author 26483
 * @Date 2023/12/5 17:29
 * @Version 1.0
 * @Description 反转打印字符串
 */
public class ReversePrintString {

    public static void main(String[] args) {
        f2(0,"hello");
    }

    public static void f2(int n, String str) {
        if(n == str.length()) {
            return;
        }
        f2(n + 1, str);
        System.out.println(str.charAt(n));
    }

}
