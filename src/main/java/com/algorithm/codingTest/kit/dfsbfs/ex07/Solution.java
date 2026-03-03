package com.algorithm.codingTest.kit.dfsbfs.ex07;

import java.util.*;

/**
 * 퍼즐 조각 채우기
 *
 * 테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈 공간에 적절히 올려놓으려 합니다. 게임 보드와 테이블은 모두 각 칸이 1x1 크기인 정사각 격자 모양입니다. 이때, 다음 규칙에 따라 테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈칸에 채우면 됩니다.
 *
 * 조각은 한 번에 하나씩 채워 넣습니다.
 * 조각을 회전시킬 수 있습니다.
 * 조각을 뒤집을 수는 없습니다.
 * 게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 됩니다.
 * 다음은 퍼즐 조각을 채우는 예시입니다.
 *
 * puzzle_5.png
 *
 * 위 그림에서 왼쪽은 현재 게임 보드의 상태를, 오른쪽은 테이블 위에 놓인 퍼즐 조각들을 나타냅니다. 테이블 위에 놓인 퍼즐 조각들 또한 마찬가지로 [상,하,좌,우]로 인접해 붙어있는 경우는 없으며, 흰 칸은 퍼즐이 놓이지 않은 빈 공간을 나타냅니다. 모든 퍼즐 조각은 격자 칸에 딱 맞게 놓여있으며, 격자 칸을 벗어나거나, 걸쳐 있는 등 잘못 놓인 경우는 없습니다.
 *
 * 이때, 아래 그림과 같이 3,4,5번 조각을 격자 칸에 놓으면 규칙에 어긋나므로 불가능한 경우입니다.
 *
 * puzzle_6.png
 *
 * 3번 조각을 놓고 4번 조각을 놓기 전에 위쪽으로 인접한 칸에 빈칸이 생깁니다.
 * 5번 조각의 양 옆으로 인접한 칸에 빈칸이 생깁니다.
 * 다음은 규칙에 맞게 최대한 많은 조각을 게임 보드에 채워 넣은 모습입니다.
 *
 * puzzle_7.png
 *
 * 최대한 많은 조각을 채워 넣으면 총 14칸을 채울 수 있습니다.
 *
 * 현재 게임 보드의 상태 game_board, 테이블 위에 놓인 퍼즐 조각의 상태 table이 매개변수로 주어집니다. 규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 3 ≤ game_board의 행 길이 ≤ 50
 * game_board의 각 열 길이 = game_board의 행 길이
 * 즉, 게임 보드는 정사각 격자 모양입니다.
 * game_board의 모든 원소는 0 또는 1입니다.
 * 0은 빈칸, 1은 이미 채워진 칸을 나타냅니다.
 * 퍼즐 조각이 놓일 빈칸은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
 * table의 행 길이 = game_board의 행 길이
 * table의 각 열 길이 = table의 행 길이
 * 즉, 테이블은 game_board와 같은 크기의 정사각 격자 모양입니다.
 * table의 모든 원소는 0 또는 1입니다.
 * 0은 빈칸, 1은 조각이 놓인 칸을 나타냅니다.
 * 퍼즐 조각은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
 * game_board에는 반드시 하나 이상의 빈칸이 있습니다.
 * table에는 반드시 하나 이상의 블록이 놓여 있습니다.
 * 입출력 예
 * game_board	table	result
 * [[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]	[[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]	14
 * [[0,0,0],[1,1,0],[1,1,1]]	[[1,1,1],[1,0,0],[0,0,0]]	0
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 입력은 다음과 같은 형태이며, 문제의 예시와 같습니다.
 *
 * puzzle_9.png
 *
 * 입출력 예 #2
 *
 * 블록의 회전은 가능하지만, 뒤집을 수는 없습니다.
 */
public class Solution {
    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> emptySpace = new ArrayList<>();
        List<List<int[]>> blocks = new ArrayList<>();

        int row = game_board.length;
        int col = game_board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]) {
                    emptySpace.add(extractShape(i, j, row, col, game_board, visited, 0));
                }
            }
        }

        row = table.length;
        col = table[0].length;
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(table[i][j] == 1 && !visited[i][j]) {
                    blocks.add(extractShape(i, j, row, col, table, visited, 1));
                }
            }
        }

        return match(emptySpace, blocks);
    }

    private static int[][] DIR = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    private List<int[]> extractShape(int startX, int startY, int row, int col, int[][] board, boolean[][] visited, int target) {
        List<int[]> result = new ArrayList<>();
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {startX, startY});

        visited[startX][startY] = true;

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            result.add(cur);

            for(int i = 0; i < 4; i++) {
                int dx = cur[0] + DIR[i][0];
                int dy = cur[1] + DIR[i][1];

                if(dx < 0 || dy < 0 || dx >= row || dy >= col) continue;
                if(visited[dx][dy]) continue;
                if(board[dx][dy] != target) continue;

                visited[dx][dy] = true;
                que.add(new int[] {dx, dy});
            }
        }

        return normalize(result);
    }


    private List<int[]> normalize(List<int[]> data) {
        if(data == null || data.isEmpty()) return data;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int[] d : data) {
            minX = Math.min(minX, d[0]);
            minY = Math.min(minY, d[1]);
        }

        for(int[] d : data) {
            d[0] -= minX;
            d[1] -= minY;
        }

        return data;
    }

    private int match(List<List<int[]>> emptySpace, List<List<int[]>> blocks) {
        int result = 0;
        boolean[] used = new boolean[blocks.size()];

        for(int i = 0; i < emptySpace.size(); i++) {
            List<int[]> space = emptySpace.get(i); // 빈 공간

            for(int j = 0; j < blocks.size(); j++) {
                if(used[j]) continue;

                List<int[]> block = blocks.get(j); // 블록
                if(rotateAndCompare(space, block)) {
                    result += block.size();
                    used[j] = true;
                    break;
                }
            }
        }

        return result;
    }

    private boolean rotateAndCompare(List<int[]> space, List<int[]> block) {
        if(space.size() != block.size()) return false; // 사이즈가 틀린 경우

        List<int[]> rotated = block;
        for(int i = 0; i < 4; i++) { // 회전
            if(compare(space, rotated)) {
                return true;
            }

            if(i < 3) {
                rotated = rotate(rotated);
            }
        }

        return false;
    }

    private List<int[]> rotate(List<int[]> block) {
        List<int[]> result = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int[] b : block) {
            int x = b[1];
            int y = -b[0];

            result.add(new int[] {x, y});

            if(x < minX) minX = x;
            if(y < minY) minY = y;
        }

        for(int[] r : result) {
            r[0] -= minX;
            r[1] -= minY;
        }

        return result;
    }


    private boolean compare(List<int[]> space, List<int[]> block) {
        Collections.sort(space, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // x가 같다면 y 오름차순
        Collections.sort(block, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for(int i = 0; i < space.size(); i++) {
            int[] s = space.get(i);
            int[] b = block.get(i);
            if(s[0] != b[0] || s[1] != b[1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] game_board = {
                {1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0}
        };

        int[][] table = {
                {1, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0}
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(game_board, table));
    }
}