package com.sheldon.code04;

import java.util.Arrays;

/**
 * @ClassName E04MemoizationFibonacci
 * @Author 26483
 * @Date 2023/12/6 12:22
 * @Version 1.0
 * @Description 优化-记忆法(Memoization,备忘录
 */
public class E04MemoizationFibonacci {

    public static int fibonacci(int n){
        int[] cache = new int[n+1];
        Arrays.fill(cache,-1);
        cache[0]=0;
        cache[1]=1;
        return f(n, cache);
    }

    public static int f(int n, int[] cache){
        if(cache[n] != -1){
            return cache[n];
        }
        int x = f(n-1,cache);
        int y = f(n-2,cache);
        cache[n] = x + y;
        return cache[n];
    }

}
