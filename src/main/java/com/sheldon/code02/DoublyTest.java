package com.sheldon.code02;

import org.junit.Test;

import java.util.Iterator;

/**
 * @ClassName DoublyTest
 * @Author 26483
 * @Date 2023/12/4 12:43
 * @Version 1.0
 * @Description TODO
 */
public class DoublyTest {

    @Test
    public void test01() throws Exception {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }

        list.loop1(value -> {
            System.out.println(value);
        });

    }

}
