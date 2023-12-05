package com.sheldon.code03;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Author 26483
 * @Date 2023/12/5 17:46
 * @Version 1.0
 * @Description 递归实现插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {5,1,4,54,6,3};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));

    }


    public static void sort(int[] a ){
        insertion(a, 1);
    }

    /**
     * 将low位置的元素插入到[0, low-1]的已排序区域内
     * @param a
     * @param low 未排序区域左边界
     */
    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        int t = a[low];
        int i = low - 1;    // 已排序区域指针

        while (i >= 0 && a[i] > t) {   // 没有找到插入位置
            a[i + 1] =a[i];
            i--;
        }

        // 找到插入位置
        if (i + 1 != low) {
            a[i + 1] = t;
        }

        insertion(a, low + 1);
    }

}
