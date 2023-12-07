package com.sheldon.code05;

import org.junit.rules.Stopwatch;
import org.springframework.util.StopWatch;

/**
 * @ClassName E02PascalTriamgle
 * @Author 26483
 * @Date 2023/12/7 17:55
 * @Version 1.0
 * @Description 递归实现杨辉三角及其优化
 */
public class E02PascalTriangle {

    private static int element1(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }
        return element1(i - 1, j) + element1(i - 1, j - 1);
    }

    static void print1(int n) {
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element1(i, j));
            }
            System.out.println();
        }
    }

    // 采用二维数据优化
    private static int element2(int[][] triangle, int i, int j) {
        if (triangle[i][j] != 0) {
            return triangle[i][j];
        }
        if (j == 0 || i == j) {
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = element2(triangle,i - 1, j) + element2(triangle, i - 1, j - 1);
        return triangle[i][j];
    }

    static void print2(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element2(triangle, i, j));
            }
            System.out.println();
        }
    }

    // 采用一维数组优化
    private static void createRow(int[] triangle, int i) {

        if (i == 0){
            triangle[i] = 1;
            return;
        }

        for (int j = i; j > 0; j--) {
            triangle[j] = triangle[j] + triangle[j - 1];
        }

    }

    static void print3(int n) {
        int[] triangle = new int[n];
        for (int i = 0; i < n; i++) {
            createRow(triangle,i);
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d",triangle[j]);
            }
            System.out.println();
        }
    }

    static void printSpace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch("task");
        stopwatch.start("task01");
        print1(30);
        stopwatch.stop();
        stopwatch.start("task02");
        print2(30);
        stopwatch.stop();
        stopwatch.start("task03");
        print3(30);
        stopwatch.stop();
        System.out.println("------------------------");
        System.out.println(stopwatch.prettyPrint());

    }
}


