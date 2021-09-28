package com.hayagou.kakao;

import java.util.*;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        final int HIT = 1;
        final int MISS = 5;

        if (cacheSize == 0) {
            return cities.length * MISS;
        }

        Queue<String> list = new LinkedList<>();

        for (String city : cities) {
            String value = city.toLowerCase();
            if (list.contains(value)) {
                answer += HIT;
                list.remove(value);
                list.offer(value);
            } else {
                answer += MISS;
                if (list.size() == cacheSize) {
                    list.poll();
                }
                list.offer(value);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int result = new Cache().solution(cacheSize, cities);
        System.out.println(result);
    }
}
