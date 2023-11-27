package com.sheldon.codo01;


import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName BinarySearch
 * @Author 26483
 * @Date 2023/11/28 5:37
 * @Version 1.0
 * @Description 二分查找
 */
public class BinarySearch {

    public static int[] createArray(int length, int MaxNum) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * MaxNum);
        }
        return array;
    }

    public static int findNum(int[] array, int target) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
            }
        }
        return index;
    }


    /**
     * 二分查找基础班
     * @param a
     * @param target
     * @return -1为没有这个数
     */
    public static int binarySearch(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {        // 在左边
                j = m - 1;
            } else if (a[m] < target) {   // 在右边
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 改进版，循环次数减少
     * @param a
     * @param target
     * @return
     */
    public static int binarySearch2(int[] a, int target) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (a[m] < target) {
                i = m + 1;
            } else if (target < a[m]) {
                j = m;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 平衡版，时间复杂度都为
     * O（(log(n)）
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }

    /**
     * 查找重复元素的最左侧元素
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {        // 在左边
                j = m - 1;
            } else if (a[m] < target) {   // 在右边
                i = m + 1;
            } else {
                candidate = m;  // 记录当前侯选位置
                j = m -1;   // 继续向左移动
            }
        }
        return candidate;
    }

    /**
     * 查找 >= num 的最左侧的值
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchLeftmost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {        // 在左边
                j = m - 1;
            } else {   // 在右边
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * 查找最右侧的数
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {        // 在左边
                j = m - 1;
            } else if (a[m] < target) {   // 在右边
                i = m + 1;
            } else {
                candidate = m;  // 记录当前侯选位置
                i = m + 1;   // 继续向左移动
            }
        }
        return candidate;
    }

    /**
     * 查找 <= target 右侧的
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchRightmost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {        // 在左边
                j = m - 1;
            } else {   // 在右边
                i = m + 1;
            }
        }
        return i - 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int[] arr1 = createArray(10, 100);
            int target = (int) (Math.random() * 100);
            Arrays.sort(arr1);
            int index01 = binarySearchRightmost(arr1, target);
            int index02 = findNum(arr1, target);
            if (index01 != index02) {
                System.out.println("error");
                System.out.println(Arrays.toString(arr1));
                System.out.println("target" + target);
                System.out.println("index01:" + index01);
                System.out.println("index02:" + index02);
            } else {
                System.out.println("success");
            }
        }

    }

    @Test
    public void test() {
        int[] a = {0, 15, 35, 42, 65, 68, 73, 73, 91, 97};
        int num = findNum(a, 35);
        System.out.println(num);
    }

}
