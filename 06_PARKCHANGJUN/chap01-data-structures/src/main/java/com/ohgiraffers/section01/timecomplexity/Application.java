package com.ohgiraffers.section01.timecomplexity;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 15, 4, 9, 10, 7};
        System.out.println(getFirst(arr));
        System.out.println(binarySearch(arr, 1));
        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(fibonacci(10));
    }

    /* 상수 시간(Constant Time) - 시간 복잡도 표기 : O(1) : 입력값에 대한 내용들이 몇개가 되든 간에 결과값에 대한 처리 내용을 동일하다. */
    private static int getFirst(int[] arr) {

        return arr[0];
    }

    /* 로그 시간(Logarithmic Time) - 시간 복잡도 표기 : O(log n) : 입력 데이터보다 적게 연산 하는 경우. ex) 이진 트리 */
    private static int binarySearch(int[] arr, int target) {

        /* 초기 세팅(배열을 오름차순으로 정렬) */
        /* 내부적으로 nlogn 만큼의 시간이 걸리지만 지금은 제외 */
        Arrays.sort(arr); // 정렬을 했기 때문에 정렬 후에 위치를 생각해야 한다.

        // java에서는 같은 자료형이면 ,(콤마)로 이어서 쓸 수 있다.
        /* 배열의 처음과 끝은 지정하는 인덱스를 담은 변수 (포인터) */
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // mid는 값이 아니라 위치를 나타내는 것이다.
            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // 값이 없는 것에 대해 -1을 리턴
    }

    /* 선형시간(Linear Time) O(n) : 입력의 증가에 선형적으로 연산하는 경우. ex) 단순(1중) 반복문 */
    private static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    /* 지수 시간(Exponential Time) O(2^n) : 입력 데이터가 증가할 때마다 시간이 2배로 증가하는 경우. ex) 재귀 피보나치   */
    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}