package com.hayagou.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 배열로 구현된 리스트
 * 조회 성능이 좋지만 삽입 삭제 성능이 좋지 못하다.
 */
public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Spring Boot");
        list.add("Jpa");
        list.add("Entity");
        list.add("Controller");
        list.add("Spring batch");
        list.add("Maria DB");
        list.add("Ubuntu 12");

        int size = list.size();
        System.out.println("총 객체 수: " + size);

        System.out.println();

        int n = 2;
        String skill = list.get(n);
        System.out.println(n + ": " + list.get(n));

        String set = list.set(n, "replace");

        System.out.println("바뀐 객체 : " + set);
        System.out.println(n + ": " + list.get(n));

        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + " : " + str);
        }
        System.out.println();

        String deleted = list.remove(2);
        System.out.println("삭제된 객체 : " + deleted);

        deleted = list.remove(2);
        System.out.println("삭제된 객체 : " + deleted);

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + " : " + str);
        }
        System.out.println();

        // 모든 객체 삭제
        list.clear();


//      Arrays => List
        String[] skills = {"Java", "Spring Boot", "Jpa"};

        list = Arrays.asList(skills);

        for (String str : list) {
            System.out.println(str);
        }

    }
}
