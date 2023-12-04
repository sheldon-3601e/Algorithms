package com.sheldon.code02;

import org.junit.Test;

/**
 * @ClassName DoublyToroidalTest
 * @Author 26483
 * @Date 2023/12/4 17:57
 * @Version 1.0
 * @Description TODO
 */
public class DoublyToroidalTest {

    @Test
    public void testAddFirst() {

        DoublyToroidalLinkedListSentinel list = new DoublyToroidalLinkedListSentinel();
        for (int i = 1; i < 6; i++) {
            list.addLast(i);
        }

        list.removeByValue(4);

        for (Integer value : list) {
            System.out.println(value);
        }

    }

}
