package com.hayagou.kakao;

public class SecretMap {

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        // 결과 배열 생성
        String[] answer = new String[n];
        // 결과의 자릿수 설정
        String form = "%" + n + "s";

        for (int i = 0; i < n; i++) {
            // or 연산 후 replace
            answer[i] = String.format(form, Integer.toBinaryString(arr1[i] | arr2[i])).replace("1", "#").replace("0", " ");
        }
        return answer;
    }

    public static void main(String[] args) {

        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};

        String[] answer = solution(n, arr1, arr2);
    }
}
