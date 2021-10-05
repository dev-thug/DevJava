package com.hayagou.kakao;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Friends4Block {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        int removed = 0;
        // 종료 조건
        boolean flag = true;
        // 소문자를 필터링하기위한 정규표현식
        String pattern = "^[A-Z]*$";
        // 입력 데이터를 보관할 배열
        String[][] array = new String[m][n];

        // 입력데이터를 2차원 배열에 저장
        for (int i = 0; i < m; i++) {
            String[] temp = board[i].split("");
            for (int j = 0; j < n; j++) {
                array[i][j] = temp[j];
            }
        }

        // ??: 입력된 2차원 배열을 반시계반향으로 90도 회전후 넣을 자료구조, 리스트형 배열을 만들고 싶어서 썻는데, 선언 구조가 이상함
        List<String>[] list = new List[n];

        // 배열형 리스트에 데이터 저장
        for (int j = 0; j < n; j++) {
            list[j] = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                list[j].add(0, array[i][j]);
            }
        }

        // 더 이상 바뀌는 블럭이 없을때 까지 반복
        while (flag) {
            flag = false;

            // 행 전체 크기의 -1 만큼 반복
            for (int i = 0; i < n - 1; i++) {

                // 두개의 리스트중 사이즈가 작은 리스트의 길이를 가져온다
                int len = Math.min(list[i].size(), list[i + 1].size());

                // 인접한 리스트와 비교
                for (int j = 0; j < len - 1; j++) {
                    String a = list[i].get(j);
                    String b = list[i].get(j + 1);
                    String c = list[i + 1].get(j);
                    String d = list[i + 1].get(j + 1);

                    // 대소문자 구분없이 논리적 값이 같다면 전부 소문자로 변환
                    if (a.equalsIgnoreCase(b) && a.equalsIgnoreCase(c) && a.equalsIgnoreCase(d)) {
                        list[i].set(j, a.toLowerCase());
                        list[i].set(j + 1, a.toLowerCase());
                        list[i + 1].set(j, a.toLowerCase());
                        list[i + 1].set(j + 1, a.toLowerCase());

                        flag = true;
                    }
                }
            }

            // 탐색이 끝난후 리스트의 소문자로된 데이터를 필터링
            for (int i = 0; i < n; i++) {
                list[i] = list[i].stream().filter(s -> Pattern.matches(pattern, s)).collect(Collectors.toCollection(LinkedList::new));
            }
        }


        // 삭제된 블록의 총 합을 구함
        for (int i = 0; i < n; i++) {
            removed += list[i].size();
        }

        // 모든 블럭 - 삭제된 블록 = 남은 블럭
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
