package com.hayagou.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformance {
    public static void main(String[] args) {
        // 배열 리트스 생성
        List<String> arrayList = new ArrayList<>();
        // 연결 리스트 생성
        List<String> linkedList = new LinkedList<>();

        long startTime, endTime;
        int n = 10000;

        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();

        System.out.println("ArrayList 수행 시간 : " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();

        System.out.println("LinkedList 수행 시간 : " + (endTime - startTime));
    }
}
