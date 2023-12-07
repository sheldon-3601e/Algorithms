package com.sheldon.code05;

import java.util.LinkedList;

/**
 * @ClassName E01hanoiTower
 * @Author 26483
 * @Date 2023/12/7 17:50
 * @Version 1.0
 * @Description 递归实现汉诺塔
 */
public class E01hanoiTower {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for(int i = n; i >= 1;i--){
            a.addLast(i);
        }
    }

    public static void print() {
        System.out.println("--------------------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     *
     * @param n 移动的圆盘个数
     * @param a 原来的柱子
     * @param b 中介的柱子
     * @param c 目标柱子
     */
    static void move(int n,
                     LinkedList<Integer> a,LinkedList<Integer> b,LinkedList<Integer> c) {
        if(n == 0) {
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        move(n-1,b,a,c);
    }

    public static void main(String[] args) {
        init(64);
        print();
        move(64,a,b,c);
        print();
    }

}
