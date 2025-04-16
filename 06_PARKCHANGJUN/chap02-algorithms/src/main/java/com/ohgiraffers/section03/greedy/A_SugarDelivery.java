package com.ohgiraffers.section03.greedy;

/*
 * 설탕 배달 문제
 * 매 단계마다 즉각적으로 최적이라고 생각되는 선택을 반복해서
 * 전체 문제의 해답(최소 봉지의 수)를 구하는 문항
 * 3kg, 5kg의 봉지로 최소 봉지 수를 가져갈 수 있게 만들기
 * 백준 2839번
 * https://www.acmicpc.net/problem/2839
 */
public class A_SugarDelivery {


    public static int solution(int n) {

        /* 3kg와 5kg로 봉지로 가져갈 수 있는 최소 봉지 수 */
        int count = 0;
//        Example
//        1. n = 18 → 18 % 5 != 0 → n -= 3 → n = 15, count = 1
//        2. n = 15 → 15 % 5 == 0 → return 15/5 + 1 = 3 + 1 = 4
//        --> 3kg 1개 + 5kg 3개 = 총 4봉지 --> 최소 봉지 수!

        while(true) {
            if(n % 5 == 0) {
                return n / 5 + count;
            } else if (n < 0) { // 3 or 5 조합으로 해결 안되는 상황
                return -1; // 안되는경우 -1 반환
            } else if(n == 0) { // 3kg 봉지로만 해결
                return count ;
            }
            n = n - 3;
            count++;
        }
    }
}
