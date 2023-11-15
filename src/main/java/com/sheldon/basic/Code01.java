package com.sheldon.basic;

/**
 * @ClassName Code01
 * @Author 26483
 * @Date 2023/11/13 1:40
 * @Version 1.0
 * @Description 位运算
 */
public class Code01 {

    public static void main(String[] args) {

        int a = 125456;
        int b = 325456;

        print(a);
        print(b);
        System.out.println("================================================");
        print(a & b);
        print(a | b);
        print(a ^ b);

        /*
        * >> 带符号右移
        * >>> 不带符号右移
        * */
        System.out.println("================================");

        // 取反
        // 负数逻辑为：取反加一
        // 最小值的负数就是他自己
        a = 5;
        b = (~a + 1);
        System.out.println(a);
        System.out.println(b);

    }

    /**
     * 输出整数值的32位
     * @param num
     */
    public static void print(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (num << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


}
