package com.hayagou.kakao;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NewsClustering {

    public static int solution(String str1, String str2) {
        int answer = 0;

        List<String> set1 = getSet(str1);
        List<String> set2 = getSet(str2);

        List<String> intersection = new ArrayList<>();

        int set1Size = set1.size();
        int set2Size = set2.size();


//        교집합
        for (String i : set1) {
            for (String j : set2) {
                if (i.equals(j)) {
                    intersection.add(j);
                    set2.remove(j);
                    break;
                }
            }
        }

        int intersectionValue = intersection.size();

        int unionValue = set1Size + set2Size - intersectionValue;

        if (unionValue == 0) {
            return 65536;
        }

        Float f = (float) intersectionValue / (float) unionValue;


        answer = (int) (f * 65536);
        return answer;
    }

    public static List<String> getSet(String str) {
        String[] token = str.toLowerCase().split("");

        List<String> set = new ArrayList<>();

        for (int i = 0; i < token.length - 1; i++) {
            String e = token[i] + token[i + 1];

            if (Pattern.matches("^[a-zA-Z]*$", e)) {
                set.add(e);
            }
        }

        return set;
    }

    public static void main(String[] args) {
        String str1 = "aaabb";
        String str2 = "aabbb";
        System.out.println(solution(str1, str2));
    }

}
