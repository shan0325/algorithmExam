package com.algorithm.baekjoon.greedy.세탁소사장동혁;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] changes = new int[N];

        for (int i = 0; i < N; i++) {
            changes[i] = in.nextInt();
        }

        int[][] count = new int[N][4];
        for (int i = 0; i < N; i++) {
            int change = changes[i];

            count[i][0] = change / 25;
            change = change % 25;

            count[i][1] = change / 10;
            change = change % 10;

            count[i][2] = change / 5;
            change = change % 5;

            count[i][3] = change;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < count[i].length; j++) {
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }
    }
}
