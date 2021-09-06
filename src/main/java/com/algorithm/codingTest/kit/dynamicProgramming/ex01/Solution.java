package com.algorithm.codingTest.kit.dynamicProgramming.ex01;

import java.util.*;

public class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] setArr = new Set[9];
        int t = N;
        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }
        System.out.println(Arrays.toString(setArr));

        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                if(j > i - j) break;
                for(Integer a : setArr[j]) {
                    for(Integer b : setArr[i - j]) {
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if(b != 0) {
                            setArr[i].add(a / b);
                        }
                        if(a != 0) {
                            setArr[i].add(b / a);
                        }
                    }
                }
            }
        }
        for (Set<Integer> arr : setArr) {
            System.out.println(arr);
        }

        for(int i = 1; i < 9; i++) {
            if(setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        Solution solution = new Solution();
        int answer = solution.solution(N, number);
        System.out.println(answer);
    }
}
