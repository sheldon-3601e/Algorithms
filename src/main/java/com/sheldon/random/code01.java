package com.sheldon.random;

/**
 * @ClassName code01
 * @Author 26483
 * @Date 2023/11/14 10:24
 * @Version 1.0
 * @Description TODO
 */
public class code01 {

    public static void main(String[] args) {
        int testTime = 1000000;
        int count = 0;
        for (int i = 0; i < testTime; i++) {
            if (f2() == 0){
                count++;
            }
        }
        System.out.println((double) count /(double) testTime);
        System.out.println("================================================");

        int[] counts = new int[8];
        for (int i = 0; i < testTime; i++) {
            int num = g();
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现了" + counts[i]);
        }

    }

    //有一个随机函数，返回1~5的随机值，
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    //随机机制，等概率返回0、1
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    //得到000~111
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }

    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    public static int g() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 0);
        return ans;
    }
}
