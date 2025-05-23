package com.ohgiraffers.section04.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class A_FibonacciTests {

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.arguments(10, 55),
                Arguments.arguments(40, 102334155)
        );
    }

    @DisplayName("기본 재귀 피보나치")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void fibonacciTest1(int input, int output) {
        int result = A_Fibonacci.getFibonacciNumber(input);
        assertEquals(output, result);
    }

    @DisplayName("DP-Top Down 피보나치")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void fibonacciTest2(int input, int output) {
        int result = A_Fibonacci.getFibonacciNumberDP(input);
        assertEquals(output, result);
    }

    @DisplayName("DP-Bottom Up 피보나치")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void fibonacciTest3(int input, int output) {
        int result = A_Fibonacci.getFibonacciNumberIter(input);
        assertEquals(output, result);
    }

}