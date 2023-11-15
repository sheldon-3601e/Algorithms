package com.sheldon.dichotomy;

import com.sheldon.util.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName code01
 * @Author 26483
 * @Date 2023/11/15 17:50
 * @Version 1.0
 * @Description 二分法入门
 */
public class code01 {

    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 100;
        int testTime = 50000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = lenRandomValueRandom(maxLen, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random() - (int) (maxValue * Math.random()));
            if (testMostRight(arr, value) != mostRightNoGreaterNumIndex(arr, value)) {
                ArrayUtils.printArray(arr);
                System.out.println();
                System.out.println(value);
                System.out.println(testMostRight(arr, value));
                System.out.println(mostRightNoGreaterNumIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "NICE" : "Fucking fucked");
    }


    /**
     * 局部最小
     * 无序数组，相邻两位不相等
     */
    public static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        ;
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = arr.length;
        int ans = -1;
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
                continue;
            }
            if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
                continue;
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    //生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    //用于测试
    public static boolean checkOneMinIndex(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    @Test
    public void testOneMinIndex() {
        int maxLen = 10;
        int maxValue = 100;
        int testTime = 50000;
        System.out.println("start...");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!checkOneMinIndex(arr, ans)) {
                ArrayUtils.printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("end...");
    }

    /**
     * 二分法。有序数组找一个数num
     */
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    /**
     * 找到大于num最左的位置
     */
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static int mostRightNoGreaterNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int t = -1;
        while (L <= R) {
            int mid = (R + L) / 2;
            if (arr[mid] <= num) {
                t = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return t;
    }

    public static int testMostRight(int[] arr, int value) {
        int t = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= value) {
                t = i;
            }
        }
        return t;
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
}
