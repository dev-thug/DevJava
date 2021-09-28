package com.hayagou.collection.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList와 사용 방법은 같지만 내부 구조는 완전히 다르다.
 * 내부적으로 노드들은 링크로 연결 되어있다, 링크의 연결관계는 양방향연결리스트이다.
 * 그렇기 때문에 빈번한 삽입 삭제가 일어나는 데이터구조일 경우 좋은 성능을 보인다.
 */
public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

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
