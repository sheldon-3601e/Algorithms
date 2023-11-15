package com.sheldon.random;

/**
 * @ClassName code02
 * @Author 26483
 * @Date 2023/11/15 17:12
 * @Version 1.0
 * @Description // 01不等概率 =》 01等概率
 */
public class code02 {

    public static void main(String[] args) {

    }

    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 等概率返回01
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }
}
