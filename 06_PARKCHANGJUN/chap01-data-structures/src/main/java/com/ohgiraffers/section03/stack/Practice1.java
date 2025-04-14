package com.ohgiraffers.section03.stack;

import java.util.Stack;

// 문제 경로 - 백준 9012번
// https://www.acmicpc.net/problem/9012
public class Practice1 {
    // 실제로 코드를 구현
    public String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                // 여는 괄호인 경우 stack에 push
                stack.push(c); // 윈도우기준 알트 f8해서 확인해보기
            } else {
                // 스택이 비어서 괄호를 꺼낼 수 없다면 여는 괄호가 부족해서 짝이 안 맞는 상황
                if (stack.isEmpty()) return "NO";
                // 닫는 괄호인 경우 stack에서 pop
                stack.pop();
            }
        }

        // 모든 문자에 대해서 처리 했는데 스택에 여는 괄호가 남아있다는 것은 닫는 괄호가 부족해서 짝이 안 맞는 상황
        if (!stack.isEmpty()) return "NO";

        return "YES";
    }
}
//
//        for (char ch : input.toCharArray()) {
//            if (ch == '(') {
//                stack.push(ch);
//            } else if (ch == ')') {
//                if (stack.isEmpty()) {
//                    return "NO"; // 닫는 괄호가 더 많음
//                }
//                stack.pop();
//            }
//        }
//          // 모두 짝지어졌다면 스택은 비어 있어야 함
//        return stack.isEmpty() ? "YES" : "NO";
//    }
//}

















/**
 * package com.ohgiraffers.section03.stack;
 *
 * import java.util.Stack;
 *
 * public class Practice1 {
 *     // 괄호 문자열이 VPS인지 확인하는 메서드
 *     public String solution(String input) {
 *         Stack<Character> stack = new Stack<>();
 *
 *         for (char ch : input.toCharArray()) {
 *             if (ch == '(') {
 *                 stack.push(ch);
 *             } else if (ch == ')') {
 *                 if (stack.isEmpty()) {
 *                     return "NO"; // 닫는 괄호가 더 많음
 *                 }
 *                 stack.pop();
 *             }
 *         }
 *
 *         // 모두 짝지어졌다면 스택은 비어 있어야 함
 *         return stack.isEmpty() ? "YES" : "NO";
 *     }
 * }
 */