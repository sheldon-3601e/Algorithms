package com.sheldon.hash;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @ClassName HashMapTreeMap
 * @Author 26483
 * @Date 2023/11/16 11:14
 * @Version 1.0
 * @Description TODO
 */
public class HashMapTreeMap {

    public static class Node {

        private Integer value;
        public Node(Integer value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(123456, "test123456");

        Integer a = 123456;
        Integer b = 123456;
        System.out.println(a == b);
        // 面对包装类，哈希表全是按值传递
        System.out.println(map.containsKey(a));
        System.out.println(map.containsKey(b));

        Node node1 = new Node(1);
        Node node2 = new Node(1);
        HashMap<Node, String> map2 = new HashMap<>();
        map2.put(node1, "test1");
        // 面对非原生类型，哈希表按引用传递
        System.out.println(map2.containsKey(node1));
        System.out.println(map2.containsKey(node2));

        System.out.println("==========================");

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();

        treeMap1.put(3, "i'm three");
        treeMap1.put(4, "i'm three");
        treeMap1.put(0, "i'm three");
        treeMap1.put(6, "i'm three");

        System.out.println(treeMap1.containsKey(3));

        //全是log(n)级别的
        System.out.println(treeMap1.firstKey());
        System.out.println(treeMap1.lastKey());

        // <=5 离5最近的key
        System.out.println(treeMap1.floorKey(5));
        // >=5 离5最近的key
        System.out.println(treeMap1.ceilingKey(5));

    }
}
