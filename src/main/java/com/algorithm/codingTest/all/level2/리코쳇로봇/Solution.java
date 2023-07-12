package com.algorithm.codingTest.all.level2.리코쳇로봇;

import java.util.Arrays;

public class Solution {
    int answer = Integer.MAX_VALUE;

    // G의 위치
    int gx = 0;
    int gy = 0;

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
        dfs(boards, visited, ry, rx, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(String[][] boards, int[][] visited, int ry, int rx, int count) {
        int yLen = boards.length;
        int xLen = boards[0].length;

        if (ry == gy && rx == gx) {
            answer = Math.min(answer, count);
            return;
        }

        // 0 : 상, 1 : 하, 2 : 좌, 3 : 우
        for (int i = 0; i < 4; i++) {
            int nextRy = ry;
            int nextRx = rx;

            if (i == 0) {
                while (true) {
                    int tempNextRy = nextRy - 1;
                    if (tempNextRy < 0 || "D".equals(boards[tempNextRy][nextRx])) {
                        break;
                    }
                    nextRy = tempNextRy;
                }
            } else if (i == 1) {
                while (true) {
                    int tempNextRy = nextRy + 1;
                    if (tempNextRy >= yLen || "D".equals(boards[tempNextRy][nextRx])) {
                        break;
                    }
                    nextRy = tempNextRy;
                }
            } else if (i == 2) {
                while (true) {
                    int tempNextRx = nextRx - 1;
                    if (tempNextRx < 0 || "D".equals(boards[nextRy][tempNextRx])) {
                        break;
                    }
                    nextRx = tempNextRx;
                }
            } else if (i == 3) {
                while (true) {
                    int tempNextRx = nextRx + 1;
                    if (tempNextRx >= xLen || "D".equals(boards[nextRy][tempNextRx])) {
                        break;
                    }
                    nextRx = tempNextRx;
                }
            }

            if (visited[nextRy][nextRx] <= count + 1) {
                continue;
            }
            visited[nextRy][nextRx] = count + 1;

            dfs(boards, visited, nextRy, nextRx, count + 1);
        }
    }

    public static void main(String[] args) {
        // 7
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        Solution solution = new Solution();
        int answer = solution.solution(board);
        System.out.println("answer = " + answer);
    }
}
