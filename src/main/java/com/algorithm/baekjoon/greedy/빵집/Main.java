package com.algorithm.baekjoon.greedy.빵집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, cnt;
    static int[][] matrix = null;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        matrix = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] line = reader.readLine().split("");
            for (int j = 0; j < C; j++) {
                if ("x".equals(line[j])) {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            flag = false;
            dfs(i, 0);
        }
        System.out.println(cnt);
    }

    public static void dfs(int row, int column) {
        matrix[row][column] = 2; // 방문 표시

        if (column == C - 1) {
            cnt++;
            flag = true;
            return;
        }

        for (int[] d : dir) {
            int nextRow = row + d[0];
            int nextColumn = column + d[1];

            if (isOk(nextRow, nextColumn) && matrix[nextRow][nextColumn] == 0) {
                dfs(nextRow, nextColumn);
                if (flag) return;
            }
        }
    }

    public static boolean isOk(int row, int column) {
        return row >= 0 && column >= 0 && row < R && column < C;
    }
}
