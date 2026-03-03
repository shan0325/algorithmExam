package com.algorithm.codingTest.kit.dynamicProgramming.ex03;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */
public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] temp = new int[m + 1][n + 1];

        // 웅덩이는 -1
        for (int i = 0; i < puddles.length; i++) {
            temp[puddles[i][0]][puddles[i][1]] = -1;
        }

        temp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(temp[i][j] == -1) {
                    temp[i][j] = 0;
                } else {
                    temp[i][j] = (temp[i-1][j] + temp[i][j-1]) % MOD;
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        return temp[m][n];
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        Solution solution = new Solution();
        int answer = solution.solution(m, n, puddles);
        System.out.println(answer);
    }
}
