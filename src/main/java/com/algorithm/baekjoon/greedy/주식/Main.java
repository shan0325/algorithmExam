package com.algorithm.baekjoon.greedy.주식;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] arr = new int[T][];
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] innerArr = new int[N];
            for (int j = 0; j < N; j++) {
                innerArr[j] = scanner.nextInt();
            }
            arr[i] = innerArr;
        }

        long[] profits = new long[T];
        for (int i = 0; i < T; i++) {
            int[] iArr = arr[i];

            long profit = 0;
            long max = iArr[iArr.length - 1];
            for (int j = iArr.length - 2; j >= 0 ; j--) {
                int num = iArr[j];

                if (max > num) {
                    profit += max - num;
                } else {
                    max = num;
                }
            }
            profits[i] = profit;
        }
        for (int i = 0; i < T; i++) {
            System.out.println(profits[i]);
        }
    }
}
