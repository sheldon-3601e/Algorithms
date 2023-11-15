package com.sheldon.random;

/**
 * @ClassName code03
 * @Author 26483
 * @Date 2023/11/15 17:23
 * @Version 1.0
 * @Description 对数器
 */
public class code03 {

    /**
     * 对数器
     * 生成随机样本，大容量进行对比
     * @param args
     */
    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue = 100;
        int testTime = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] arr2 = copyArray(arr1);
            selectSort(arr1);
            bubbleSort(arr2);
            if (!isSorted(arr1)) {
                for (int j = 0; j < arr2.length; j++) {
                    System.out.println(arr2[j]);
                }
                System.out.println("err1");
            }

        }
    }

    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    /**
     * 选择排序
     * 直接将最小值移到第一位
     * @param arr
     */
    public static void selectSort(int[] arr) {

        //先想边界条件
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     * 每每相邻的两个数进行交换
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        // 0 ~ n - 1
        // 0 ~ n - 2
        for (int end = N - 1; end >= 0; end--) {
            // 0 ~ end
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second, second - 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
