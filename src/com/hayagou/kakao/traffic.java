package com.hayagou.kakao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class traffic {
    public static int solution(String[] lines) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS");
        Date to = sdf.parse("2016-09-15 20:59:57.421");
        Date up = sdf.parse("2016-09-15 20:59:57.426");
        System.out.println(to.getTime());
        System.out.println(to);
        System.out.println(up.getTime());
        int answer = 0;
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

        solution(lines);
    }

}
