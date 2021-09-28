package com.hayagou.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("Spring Boot");
        set.add("Jpa");
        set.add("Entity");
        set.add("Controller");
        set.add("Spring batch");
        set.add("Maria DB");
        set.add("Ubuntu 12");

        int size = set.size();
        System.out.println("총 객체수 : " + size);

        // 이터레이터 사용
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        set.remove("Spring batch");
        set.remove("Maria DB");

        System.out.println();

        // foreach 문
        for (String str : set) {
            System.out.println(str);
        }

        set.clear();

        System.out.println();

        Set<Member> memberSet = new HashSet<>();
        memberSet.add(new Member("김현중", 27));
        memberSet.add(new Member("김현중", 27));

        size = memberSet.size();
        System.out.println("총 객체수 : " + size);

    }
}
