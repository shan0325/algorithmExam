package com.algorithm.codingTest.kit.graph.ex02;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */
public class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n][n];

        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]-1][results[i][1]-1] = 1;
            graph[results[i][1]-1][results[i][0]-1] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        System.out.println();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == j || graph[i][j] != 0) continue;
                    if(graph[i][k] == graph[k][j]) {
                        graph[i][j] = graph[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }

        for (int i = 0; i < n; i++) {
            if(Arrays.stream(graph[i]).filter((v) -> v == 0).count() == 1) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        Solution solution = new Solution();
        int answer = solution.solution(n, results);
        System.out.println(answer);
    }
}
