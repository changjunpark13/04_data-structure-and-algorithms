package com.ohgiraffers.section03.stack;

import java.sql.SQLOutput;
import java.util.Stack;

// 문제 경로 - 백준 9012번
// https://www.acmicpc.net/problem/9012
public class Practice1 {
    // 실제로 코드를 구현
    public String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) { // toCharArray : 한글자씩 빼낸다. 괄호 하나하나가 배열에 하나씩 위치해있다고 생각하면 됨.
            if (c == '(') {
                // 여는 괄호인 경우 stack에 push
                stack.push(c); // 윈도우기준 알트 f8해서 확인해보기
            } else {
                // 스택이 비어서 괄호를 꺼낼 수 없다면 여는 괄호가 부족해서 짝이 안 맞는 상황
                if (stack.isEmpty()) return "NO";
                // 닫는 괄호인 경우 stack에서 pop
                stack.pop();
            }
            // 만약에 문자가 '('인 경우엔 push, ')'인 경우 만약에 그 공간에 아무것도 없으면 'NO'를 리턴
            // 아직 비워있지 않으면 pop, 즉, 마지막에 들어온 값을 빼낸다.
        }

        // 모든 문자에 대해서 처리 했는데 스택에 여는 괄호가 남아있다는 것은 닫는 괄호가 부족해서 짝이 안 맞는 상황
        if (!stack.isEmpty()) return "NO";

        return "YES";

    }
}