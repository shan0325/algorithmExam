package com.algorithm.codingTest.all.level2.리코쳇로봇;

import java.util.Arrays;

public class Solution {
    int answer = 0;

    // G의 위치
    int gx = 0;
    int gy = 0;
    boolean isBump = false;

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
                    rx = i;
                    ry = j;
                    visited[i][j] = 9;
                }
                if (c == 'G') {
                    gx = i;
                    gy = j;
                    visited[i][j] = 9;
                }
                if (c == 'D') {
                    visited[i][j] = 9;
                }
            }
        }

        for(String[] b : boards) {
            System.out.println(Arrays.toString(b));
        }

        for(int[] v : visited) {
            System.out.println(Arrays.toString(v));
        }

        dfs(boards, visited, rx, ry, "");

        return answer;
    }

    private void dfs(String[][] boards, int[][] visited, int rx, int ry, String direction) {
        isBump = false;
        int xLen = boards[0].length;
        int yLen = boards.length;
        String curLoc = boards[ry][rx];

        if ("D".equals(curLoc) || rx < 0 || rx >= xLen || ry < 0 || ry >= yLen) {
            answer++;
            isBump = true;
            return;
        }

        while (true) {

            if (!direction.isEmpty()) {
                if ("R".equals(direction)) rx++;
                if ("L".equals(direction)) rx--;
                if ("D".equals(direction)) ry++;
                if ("U".equals(direction)) ry--;
            } else {
                if (rx <= 0) {
                    direction = "R";
                    rx++;
                } else if (rx >= xLen - 1) {
                    direction = "L";
                    rx--;
                } else if (ry <= 0) {
                    direction = "D";
                    ry++;
                } else if (ry >= yLen - 1) {
                    direction = "U";
                    ry--;
                }
            }

            if (("R".equals(direction) || "L".equals(direction)) && visited[ry][rx] == 1) {
                direction = "U";
                continue;
            } else if (("U".equals(direction) || "D".equals(direction)) && visited[ry][rx] == 2) {
                direction = "L";
                continue;
            }

            dfs(boards, visited, rx, ry, direction);
            if (isBump) {
                if ("G".equals(curLoc)) {
                    return;
                }
                direction = "";
            }
        }
    }

    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        Solution solution = new Solution();
        int answer = solution.solution(board);
        System.out.println("answer = " + answer);
    }
}
