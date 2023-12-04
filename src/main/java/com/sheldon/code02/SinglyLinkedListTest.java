package com.sheldon.code02;

import org.junit.Test;
import com.sheldon.code02.singlyLinkedList;

/**
 * @ClassName SinglyLinkedListTest
 * @Author 26483
 * @Date 2023/12/4 12:06
 * @Version 1.0
 * @Description TODO
 */
public class SinglyLinkedListTest {

    @Test
    public void test01() {
        singlyLinkedList list = new singlyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop(val -> {
            System.out.println(val);
        });
        System.out.println("================================");

        list.addLast(0);
        list.loop(val -> {
            System.out.println(val);
        });
        System.out.println("================================");

        list.insert(1,11);
        list.loop(val -> {
            System.out.println(val);
        });
        System.out.println("================================");

        System.out.println("success");
    }

}
