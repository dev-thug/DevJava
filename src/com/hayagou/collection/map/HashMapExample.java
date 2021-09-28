package com.hayagou.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 객체 저장
        map.put("김현중", 92);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        System.out.println("총 Entry 수 : " + map.size());

        // 객체 찾기
        String key = "홍길동";
        System.out.println("\t" + key + " : " + map.get(key));

        Set<String> keys = map.keySet();

        for (String str : keys) {
            System.out.println(str);
        }

        System.out.println();

        int deleted = map.remove(key);
        System.out.println("삭제된 " + key + " 의 값은 " + deleted);
        System.out.println("총 Entry 수 : " + map.size());

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        for (Map.Entry<String, Integer> value: entrySet){
            System.out.println("\t"+value.getKey()+ " : " + value.getValue());
        }

    }

}
