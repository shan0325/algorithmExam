package com.algorithm.codingTest.all.level2.리코쳇로봇;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution3 {
    int answer = Integer.MAX_VALUE;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // G의 위치
    int gx = 0;
    int gy = 0;

    // bfs 사용하여 해결
    public int solution(String[] board) {
        // R의 위치
        int rx = 0;
        int ry = 0;

        // 배열로 변경
        String[][] boards = new String[board.length][board[0].length()];
        int[][] visited = new int[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            String b = board[i];
            for (int j = 0; j < b.length(); j++) {
                char c = b.charAt(j);
                boards[i][j] = String.valueOf(c);
                if (c == 'R') {
                    rx = j;
                    ry = i;
                }
                if (c == 'G') {
                    gx = j;
                    gy = i;
                }
            }
        }

        for (int[] visit : visited) {
            Arrays.fill(visit, Integer.MAX_VALUE);
        }

        for(String[] b : boards) {
            System.out.println(Arrays.toString(b));
        }

        for(int[] v : visited) {
            System.out.println(Arrays.toString(v));
        }

        visited[ry][rx] = 0;
        bfs(boards, visited, ry, rx);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void bfs(String[][] boards, int[][] visited, int ry, int rx) {
        int yLen = boards.length;
        int xLen = boards[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ry, rx, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curRy = poll[0];
            int curRx = poll[1];
            int count = poll[2];

            if (curRy == gy && curRx == gx) {
                answer = Math.min(answer, count);
                continue;
            }

            // 0 : 상, 1 : 하, 2 : 좌, 3 : 우
            for (int i = 0; i < 4; i++) {
                int nextRy = curRy;
                int nextRx = curRx;
                while (true) {
                    int tempNextRy = nextRy + directions[i][0];
                    int tempNextRx = nextRx + directions[i][1];

                    if (tempNextRy < 0 || tempNextRy >= yLen || tempNextRx < 0 || tempNextRx >= xLen) {
                        break;
                    }

                    if ("D".equals(boards[tempNextRy][tempNextRx])) {
                        break;
                    }
                    nextRy = tempNextRy;
                    nextRx = tempNextRx;
                }

                if (visited[nextRy][nextRx] <= count + 1) {
                    continue;
                }
                visited[nextRy][nextRx] = count + 1;

                queue.add(new int[]{nextRy, nextRx, count + 1});
            }
        }
    }

    public static void main(String[] args) {
        // 7
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        Solution3 solution = new Solution3();
        int answer = solution.solution(board);
        System.out.println("answer = " + answer);
    }
}
