package com.algorithm.codingTest.kit.dynamicProgramming.ex01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static long count;

    // 일반
    public int fibo(int index) {
        count++;

        if(index == 0) {
            return 0;
        } else if(index <= 2) {
            return 1;
        } else {
            return fibo(index - 1) + fibo(index - 2);
        }
    }

    // 동적계획법으로 처리
    public int fiboDP(Map<Integer, Integer> memo, int index) {
        count++;

        if(index == 0) {
            return 0;
        } else if(index <= 2) {
            return 1;
        } else {
            if(memo.containsKey(index)) {
                return memo.get(index);
            }

            int val = fiboDP(memo, index - 1) + fiboDP(memo, index - 2);
            memo.put(index, val);

            return val;
        }
    }

    // bottom-up 방식
    public int fiboBottomUp(int index) {
        int[] temp = new int[index];
        temp[0] = 1;
        temp[1] = 1;

        for (int i = 2; i < index; i++) {
            temp[i] = temp[i-1] + temp[i-2];
        }

        return temp[index - 1];
    }

    public static void main(String[] args) {
        int index = 30;
        long start = 0;
        long result = 0;
        long end = 0;

        Fibonacci fibonacci = new Fibonacci();

        start = System.currentTimeMillis();
        result = fibonacci.fibo(index);
        end = System.currentTimeMillis();

        System.out.println("일반 : " + result);
        System.out.println("함수 호출 수: " + count + ", 처리시간: " + (end - start) + "ms");

        count = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        start = System.currentTimeMillis();
        result = fibonacci.fiboDP(memo, index);
        end = System.currentTimeMillis();

        System.out.println("====================================");
        System.out.println("동적계획법 : " + result);
        System.out.println("함수 호출 수: " + count + ", 처리시간: " + (end - start) + "ms");
        System.out.println("====================================");

        start = System.currentTimeMillis();
        result = fibonacci.fiboBottomUp(index);
        end = System.currentTimeMillis();

        System.out.println("동적계획법 : " + result);
        System.out.println("처리시간: " + (end - start) + "ms");
    }

}
