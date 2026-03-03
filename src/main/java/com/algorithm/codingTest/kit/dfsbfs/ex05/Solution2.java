package com.algorithm.codingTest.kit.dfsbfs.ex05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs 방식
 */
public class Solution2 {
    int[] calcX = {1, -1, 0, 0};
    int[] calcY = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] visited = new int[n][m];
        visited[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int step = current[2];

            if (y == n - 1 && x == m - 1) {
                // 최단 거리 반환 (bfs: 가장 처음 return 되는게 최단 거리)
                return step;
            }

            for (int i = 3; i >= 0; i--) {
                int nextX = x + calcX[i];
                int nextY = y + calcY[i];

                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                    if (maps[nextY][nextX] == 1 && visited[nextY][nextX] != 1) {
                        visited[nextY][nextX] = 1;
                        queue.add(new int[]{nextX, nextY, step + 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

//        int[][] maps = {
//                {1,0,1,1,1},
//                {1,0,1,0,1},
//                {1,0,1,1,1},
//                {1,1,1,0,0},
//                {0,0,0,0,1}
//        };

        Solution2 solution = new Solution2();
        System.out.println(solution.solution(maps));
    }
}
