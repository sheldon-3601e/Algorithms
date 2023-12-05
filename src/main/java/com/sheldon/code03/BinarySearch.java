package com.sheldon.code03;

/**
 * @ClassName BinarySearch
 * @Author 26483
 * @Date 2023/12/5 17:32
 * @Version 1.0
 * @Description 递归版二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {5,6,8,4,2};
        int search = search(a, 6);
        System.out.println(search);
    }

    public static int search(int[] a, int target) {
        return f3(a, target, 0, a.length - 1);
    }

    private static int f3(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            return f3(a, target, i, m - 1);
        } else if (a[m] < target) {
            return f3(a, target, m + 1, j);
        } else {
            return m;
        }
    }


}
