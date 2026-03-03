package com.algorithm.codingTest.kit.dynamicProgramming.ex04;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42897
 */
public class Solution {
    public int solution(int[] money) {
        int[] dp = new int[money.length - 1];
        int[] dp2 = new int[money.length];

        System.out.println(Arrays.toString(money));

        dp[0] = money[0];
        dp[1] = money[0];
        for (int i = 2; i < money.length - 1; i++) {
            dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));

        dp2[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }
        System.out.println(Arrays.toString(dp2));

        return Math.max(dp[dp.length - 1], dp2[dp2.length - 1]);
    }

    public static void main(String[] args) {
//        int[] money = {1, 2, 3, 1}; // 4
//        int[] money = {1,1,4,1,4}; // 8
//        int[] money = {1000,0,0,1000,0,0,1000,0,0,1000}; // 3000
//        int[] money = {1000,1,0,1,2,1000,0}; // 2001
//        int[] money = {1000,0,0,0,0,1000,0,0,0,0,0,1000}; // 2000
//        int[] money = {1,2,3,4,5,6,7,8,9,10}; // 30
//        int[] money = {0,0,0,0,100,0,0,100,0,0,1,1}; // 201
        int[] money = {11,0,2,5,100,100,85,1}; // 198
//        int[] money = {1,2,3}; // 3
//        int[] money = {91,90,5,7,5,7}; // 104
//        int[] money = {90,0,0,95,1,1}; // 185

        Solution solution = new Solution();
        int answer = solution.solution(money);
        System.out.println(answer);
    }
}
