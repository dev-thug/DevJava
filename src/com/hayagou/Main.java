package com.hayagou;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // 스택에 데이터를 저장
        stack.push("첫번째 데이터");
        stack.push("두번째 데이터");
        stack.push("세번째 데이터");

        // 세번째 데이터가 출력됨
        System.out.println(stack.peek());

        // 가장 마지막에 들어온 데이터 반환후 제거
        String data = stack.pop();

        stack.push("네번째 데이터");
        // 네번째 데이터가 출력됨
        System.out.println(stack.peek());

        System.out.println();
        // 두번째 데이터 저장
        stack.push(data);

        // 스택이 없을때 까지 반복
        while(!stack.isEmpty()){
            System.out.println("모든데이터 출력 : "+stack.pop());
        }
    }
}
