package com.sheldon.code04;

import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @ClassName E03Staircase
 * @Author 26483
 * @Date 2023/12/6 12:11
 * @Version 1.0
 * @Description 斐波那契数列-爬楼梯问题
 */
public class E03Staircase {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("MyTask");
        stopWatch.start("task01");
        System.out.println(f(45));
        stopWatch.stop();
        stopWatch.start("task02");
        System.out.println(memo(45));
        stopWatch.stop();

        // 打印总体信息
        System.out.println(stopWatch.prettyPrint());
    }

    // 记忆法改造版
    public static int memo(int n) {
        int[] arr = new int[n + 2];
        Arrays.fill(arr, -1);
        arr[1] = 1;
        arr[2] = 2;
        return f(n, arr);
    }

    public static int f(int n, int[] arr){
        if (arr[n] != -1) {
            return arr[n];
        }
        int x = f(n-1, arr);
        int y = f(n-2, arr);
        arr[n] = x + y;
        return arr[n];
    }

    public static int f(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int x = f(n-1);
        int y = f(n-2);
        return x + y;
    }

}
