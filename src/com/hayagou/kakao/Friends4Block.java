package com.hayagou.kakao;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Friends4Block {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        int removed = 0;
        boolean flag = true;
        String pattern = "^[A-Z]*$";
        String[][] array = new String[m][n];

        for (int i = 0; i < m; i++) {
            String[] temp = board[i].split("");
            for (int j = 0; j < n; j++) {
                array[i][j] = temp[j];
            }
        }
        List<String>[] list = new List[n];

        for (int j = 0; j < n; j++) {
            list[j] = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                list[j].add(0, array[i][j]);
            }
        }


        while (flag) {
            flag = false;
            for (int i = 0; i < n - 1; i++) {

                int len = Math.min(list[i].size(), list[i + 1].size());
                for (int j = 0; j < len - 1; j++) {
                    String a = list[i].get(j);
                    String b = list[i].get(j + 1);
                    String c = list[i + 1].get(j);
                    String d = list[i + 1].get(j + 1);

                    if (a.equalsIgnoreCase(b) && a.equalsIgnoreCase(c) && a.equalsIgnoreCase(d)) {
                        list[i].set(j, a.toLowerCase());
                        list[i].set(j + 1, a.toLowerCase());
                        list[i + 1].set(j, a.toLowerCase());
                        list[i + 1].set(j + 1, a.toLowerCase());

                        flag = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                list[i] = new LinkedList<>(list[i].stream().filter(s -> Pattern.matches(pattern, s)).collect(Collectors.toList()));
            }
        }


        for (int i = 0; i < n; i++) {
            removed += list[i].size();
        }

        answer = (m * n) - removed;
        return answer;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m, n, board));
    }
}
