package com.algorithm.codingTest.all.level2.당구연습;

import java.util.Arrays;

public class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            int targetX = ball[0];
            int targetY = ball[1];

            int now = 0;
            int result = Integer.MAX_VALUE;

            // 좌
            if (startY != targetY || startX < targetX) {
                now = distance(startX, startY, targetX * (-1), targetY);
                result = Math.min(now, result);
            }

            // 우
            if (startY != targetY || startX > targetX) {
                now = distance(startX, startY, m + (m - targetX), targetY);
                result = Math.min(now, result);
            }

            // 상
            if (startX != targetX || startY > targetY) {
                now = distance(startX, startY, targetX, n + (n - targetY));
                result = Math.min(now, result);
            }

            // 하
            if (startX != targetX || startY < targetY) {
                now = distance(startX, startY, targetX, targetY * (-1));
                result = Math.min(now, result);
            }

            answer[i] = result;
        }

        return answer;
    }

    public int distance(int sx, int sy, int tx, int ty) {
        return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = {{7, 7}, {2, 7}, {7, 3}};

        Solution solution = new Solution();
        int[] result = solution.solution(m, n, startX, startY, balls);
        System.out.println(Arrays.toString(result));
    }
}
