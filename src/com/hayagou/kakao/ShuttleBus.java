package com.hayagou.kakao;

import java.text.ParseException;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;


public class ShuttleBus {

    public static String solution(int n, int t, int m, String[] timetable) {

        LocalTime start = LocalTime.parse("09:00");
        LocalTime end = start.plusMinutes((n - 1) * t);
        int bus = 0;

        List<LocalTime> list = Arrays.asList(timetable).stream().map(LocalTime::parse)
                .filter(time -> time.compareTo(end) <= 0).sorted().collect(Collectors.toList());


        Map<Integer, List<LocalTime>> busTable = new HashMap<>();
        for (int i = 0; i < n; i++) {
            busTable.put(i, new ArrayList<>(m));
        }

        while (bus != n && !list.isEmpty()) {
            if (list.get(0).compareTo(start.plusMinutes(bus * t)) <= 0 && busTable.get(bus).size() < m) {
                List<LocalTime> temp = busTable.get(bus);
                temp.add(list.get(0));
                busTable.put(bus, temp);
                list.remove(0);
            } else {
                bus++;
            }

        }

        if (busTable.get(n - 1).size() == m) {
            return busTable.get(n - 1).get(m - 1).minusMinutes(1L).toString();
        }

        return end.toString();
    }

    public static void main(String[] args) throws ParseException {

        int n = 2;
        int t = 60;
        int m = 5;
        String[] timetable = {"00:02", "00:01", "00:01", "09:06", "09:06",
                "09:06", "09:06", "09:06", "09:06", "09:08", "18:01"};

        System.out.println(solution(n, t, m, timetable));
    }
}
