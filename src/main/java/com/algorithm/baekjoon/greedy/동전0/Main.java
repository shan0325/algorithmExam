package com.algorithm.baekjoon.greedy.동전0;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 10 4200
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 *
 * N = 10
 * K = 4200
 * arr = [1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000]
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K >= arr[i]) {
                count += K / arr[i];
                K = K % arr[i];
            }
        }
        System.out.println(count);
    }
}
