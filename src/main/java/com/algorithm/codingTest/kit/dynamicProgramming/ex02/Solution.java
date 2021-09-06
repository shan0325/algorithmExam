package com.algorithm.codingTest.kit.dynamicProgramming.ex02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class Solution {
    
    // bottom-up 으로 해결
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] temp = new int[triangle.length][triangle.length];

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(i == 0) {
                    temp[i][j] = triangle[i][j];
                    break;
                } else if(j == 0) {
                    temp[i][j] = temp[i - 1][j] + triangle[i][j];
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j - 1] + triangle[i][j], temp[i - 1][j] + triangle[i][j]);
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        answer = Arrays.stream(temp[temp.length - 1]).max().getAsInt();
        return answer;
    }

    // top-down recursive로 해결
    public int solution2(int[][] triangle) {
        int answer = 0;
        int[][] memo = new int[triangle.length][triangle.length];

        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            recur(triangle, memo, triangle.length - 1, i);
        }

        for (int i = 0; i < memo.length; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }

        answer = Arrays.stream(memo[memo.length - 1]).max().getAsInt();
        return answer;
    }

    public int recur(int[][] triangle, int[][] memo, int i, int j) {
        if(i == 0) {
            memo[i][0] = triangle[i][0];
            return memo[i][j];
        } else if(memo[i][j] > 0) {
            return memo[i][j];
        } else if(triangle[i].length - 1 < j) {
            return 0;
        }

        if(j == 0) {
            memo[i][j] = triangle[i][j] + recur(triangle, memo, i - 1, j);
        } else {
            memo[i][j] = triangle[i][j] + Math.max(recur(triangle, memo, i - 1, j - 1), recur(triangle, memo, i - 1, j));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0},{2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        Solution solution = new Solution();
        int answer = solution.solution2(triangle);
        System.out.println(answer);
    }
}
