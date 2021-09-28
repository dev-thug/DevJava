package com.hayagou.collection.list;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * ArrayList와 기능이 같음,
 * 다른점은 동기화된 메소드로 구성되어 있어 멀티스레드가 동시에 이 메소드를 실행할 수 없음
 * 즉, Thread Safe 한 ArrayList이다.
 */
public class VectorExample {
    public static void main(String[] args) {
        List<String> list = new Vector<>();

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
