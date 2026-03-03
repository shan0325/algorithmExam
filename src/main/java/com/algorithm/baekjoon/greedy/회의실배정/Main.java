package com.algorithm.baekjoon.greedy.회의실배정;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 11
 * 1 4
 * 3 5
 * 0 6
 * 5 7
 * 3 8
 * 5 9
 * 6 10
 * 8 11
 * 8 12
 * 2 13
 * 12 14
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int before = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= before) {
                count++;
                before = arr[i][1];
            }
        }
        System.out.println(count);
    }
}
