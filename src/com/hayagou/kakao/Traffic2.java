package com.hayagou.kakao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Traffic2 {
    public static int solution(String[] lines) throws ParseException {
        int answer = 0;

        // 입력 데이터 포멧
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS");

        // 변수 선언
        long startTime;
        long endTime;
        long processTime;
        // 처리량을 저장하는 맵
        Map<Long, Integer> map = new HashMap<>();

        // 입력데이터 배열의 크기까지 반복
        for (int i = 0; i < lines.length; i++) {
            // 데이터 전치리
            // 모든 데이터를 숫자로 바꾼뒤 계산하기 편하게 변수에 따로 나누어 담는다.
            String[] temp = lines[i].split(" ");
            endTime = sdf.parse(temp[0] + " " + temp[1]).getTime();
            processTime = (long) (Double.parseDouble(temp[2].replace("s", "").trim()) * 1000);
            startTime = (long) (endTime - processTime + 1);

            //            System.out.println("Start Time : " + startTime + "  endTime : " + endTime + "  processTime : " + processTime + "  Date : " + new Date(startTime));

            // 처리량을 변화는 시점은 데이터의 요청 시간과 요청 완료 시간이다.
            // 처리량이 변화는 시점을 key로 사용
            if (!map.keySet().contains(startTime)) {
                map.put(startTime, 0);
            }
            if (!map.containsKey(endTime)) {
                map.put(endTime, 0);
            }

            // 필터링을하기위한 상수 선언
            long finalEndTime = endTime;
            long finalStartTime = startTime;

            // 조건에 맞게 키를 필터링후, 처리량을 늘려준다,
            for (Long s : map.keySet().stream().filter(k -> k <= finalEndTime).filter(k -> finalStartTime - 1000 < k).collect(Collectors.toList())) {
                map.put(s, map.get(s)+1);
            }

        }

        // 최대 처리량을 구하는 반복문
        for (Long key : map.keySet()) {
            if (answer < map.get(key)) {
                answer = map.get(key);
            }
        }

        return answer;
    }


    public static void main(String[] args) throws ParseException {
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"

        }; // result 7
//        String[] lines = {
//                "2016-09-15 01:00:04.001 3s", "2016-09-15 01:00:04.001 2s"//"2016-09-15 01:00:07.000 2s"
//        }; // result 2

        System.out.println(solution(lines));
    }

}
