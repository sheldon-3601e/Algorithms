package com.sheldon.code03;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Author 26483
 * @Date 2023/12/5 17:43
 * @Version 1.0
 * @Description 递归实现冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {6,8,5,6,9,4,1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    // j 未排序的边界
    private static void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
        }
        bubble(a, x);
    }
}

