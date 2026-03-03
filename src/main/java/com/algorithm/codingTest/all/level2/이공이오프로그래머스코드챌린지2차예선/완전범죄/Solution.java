package com.algorithm.codingTest.all.level2.이공이오프로그래머스코드챌린지2차예선.완전범죄;

import java.util.Arrays;

public class Solution {
    static final int INF = 100000;
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        int [][] dp = new int [size+1][m];
        for(int i = 0; i <= size; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        for(int i = 1; i <= size; i++){
            int a = info[i-1][0];
            int b = info[i-1][1];
            for(int j = 0; j < m; j++){
                // a 선택
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                // b 선택
                if(j + b < m){
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
                }
            }
        }
        int min = INF;
        for(int j = 0; j < m; j++){
            min = Math.min(dp[size][j], min);
        }
        return min >= n ? -1 : min;
    }

    public static void main(String[] args) {
//        int[][] info = {{1, 2},{2, 3},{2, 1}};
//        int n = 4;
//        int m = 4;

//        int[][] info = {{1, 2},{2, 3},{2, 1}};
//        int n = 1;
//        int m = 7;

//        int[][] info = {{3, 3},{3, 3}};
//        int n = 7;
//        int m = 1;

        int[][] info = {{3, 3},{3, 3}};
        int n = 6;
        int m = 1;

        Solution solution = new Solution();
        int result = solution.solution(info, n, m);
        System.out.println("result = " + result); // 예시 출력
    }
}
