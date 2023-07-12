package com.algorithm.codingTest.all.level2.리코쳇로봇;

import java.util.Arrays;

/**
 * 문제 설명
 * 리코쳇 로봇이라는 보드게임이 있습니다.
 *
 * 이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.
 *
 * 이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.
 *
 * 다음은 보드게임판을 나타낸 예시입니다.
 *
 * ...D..R
 * .D.G...
 * ....D.D
 * D....D.
 * ..D....
 * 여기서 "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.
 * 위 예시에서는 "R" 위치에서 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 움직이면 7번 만에 "G" 위치에 멈춰 설 수 있으며, 이것이 최소 움직임 중 하나입니다.
 *
 * 게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때, 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성하세요. 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.
 *
 * 제한 사항
 * 3 ≤ board의 길이 ≤ 100
 * 3 ≤ board의 원소의 길이 ≤ 100
 * board의 원소의 길이는 모두 동일합니다.
 * 문자열은 ".", "D", "R", "G"로만 구성되어 있으며 각각 빈 공간, 장애물, 로봇의 처음 위치, 목표 지점을 나타냅니다.
 * "R"과 "G"는 한 번씩 등장합니다.
 * 입출력 예
 * board	result
 * ["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]	7
 * [".D.R", "....", ".G..", "...D"]	-1
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제 설명의 예시와 같습니다.
 * 입출력 예 #2
 *
 * .D.R
 * ....
 * .G..
 * ...D
 * "R" 위치에 있는 말을 어떻게 움직여도 "G" 에 도달시킬 수 없습니다.
 * 따라서 -1을 return 합니다.
 */
public class Solution {
    int answer = Integer.MAX_VALUE;

    // G의 위치
    int gx = 0;
    int gy = 0;

    // dfs 사용하여 해결
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
