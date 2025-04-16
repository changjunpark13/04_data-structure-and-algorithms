package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class C_MeetingRoomScheduler {

    public static int solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));

        int N = Integer.parseInt(br.readLine()); // 회의의 갯수
        /*
            time[][0]은 시작시점을 의미
            time[][1]은 종료시점을 의미
        */
        int[][] time = new int[N][2]; // 회의 갯수 * (시작시간 / 종료시간)
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // 끝나는 시간을 기준으로 정렬하기 위해 compare 정의
        /* 기본적인 조건은 종료시간이 빠른 회의 순서로 데이터 정렬 */
        Arrays.sort(time, (t1, t2) -> {
            if(t1[1] == t2[1]) return t1[0] - t2[0]; // 두 값의 차이를 반환해서 오름차순 정렬. 내림차순은 t2[0] - t1[0]으로 쓰면 됨
            return t1[1] - t2[1];
        });

        int endTime = 0;
        int count = 0;

        /* time 배열 안에 있는 회의를 반복하며 회의 시간표에 넣을지 확인 */
        for (int i = 0; i < N; i++) {
            if(time[i][0] >= endTime) {
                count++;
                endTime = time[i][1]; // 이후 회의 확인을 위해 종료 시간을 수정
            }
        }
        return count;
    }
}
