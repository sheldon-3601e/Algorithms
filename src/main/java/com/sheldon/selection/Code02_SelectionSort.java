package com.sheldon.selection;

import com.sun.nio.sctp.SendFailedNotification;

/**
 * @ClassName Code02_SelectionSort
 * @Author 26483
 * @Date 2023/11/13 9:51
 * @Version 1.0
 * @Description 排序
 */
public class Code02_SelectionSort {

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

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        for (int end = 1; end < N - 1; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex -1] > arr[newNumIndex]){
                swap(arr,newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end - 1;
                 pre >= 0 && arr[pre] > arr[pre + 1];
                 pre --) {

                swap(arr,pre,pre + 1);
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

    public static void printSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 6, 3, 4, 8, 6, 2,};
        printSort(arr);

//        selectSort(arr);
//        printSort(arr);

//        bubbleSort(arr);
//        printSort(arr);

//        insertSort(arr);
//        printSort(arr);

        insertSort2(arr);
        printSort(arr);
    }

}
