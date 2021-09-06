package com.algorithm.codingTest.kit.graph.ex01;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 */
public class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        boolean[][] connect = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < edge.length; i++) {
            connect[edge[i][0]-1][edge[i][1]-1] = true;
            connect[edge[i][1]-1][edge[i][0]-1] = true;
        }

        for (int i = 0; i < connect.length; i++) {
            System.out.println(Arrays.toString(connect[i]));
        }

        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("size : " + size);
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && connect[node][j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
            answer = size;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4},{5, 2}};

        Solution solution = new Solution();
        int answer = solution.solution(n, vertex);
        System.out.println(answer);
    }
}
