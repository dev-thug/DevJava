package com.hayagou.kakao;

import java.util.Stack;
import java.util.StringTokenizer;

public class DartGame {
    public static int solution(String dartResult) {
        int answer = 0;

        // 알고리즘 시작
        StringTokenizer st = new StringTokenizer(dartResult, "SDT*#", true);

        Stack<Integer> stack = new Stack<>();
        while (st.hasMoreTokens()){
            String token = st.nextToken();
            switch (token){
                case "S":
                    break;
                case "D":
                    stack.push((int) Math.pow(stack.pop(),2));
                    break;
                case "T":
                    stack.push((int) Math.pow(stack.pop(),3));
                    break;
                case "*":
                    int value = stack.pop()*2;
                    if(!stack.isEmpty()){
                        stack.push(stack.pop()*2);
                    }
                    stack.push(value);
                    break;
                case "#":
                    stack.push(stack.pop()*-1);
                    break;
                default:
                    stack.push(Integer.valueOf(token));

            }
        }

        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        String dartResult = "1D2S3T*";
        System.out.println(solution(dartResult));
    }
}
