package com.algorithm.baekjoon.greedy.게임을만든동준이;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }

        int count = 0;
        int lastScore = scores[scores.length - 1];
        for (int i = N - 2; i >= 0; i--) {
            int num = lastScore - scores[i];
            if (num <= 0) {
                int temp = Math.abs(num) + 1;
                count += temp;
                scores[i] = scores[i] - temp;
            }
            lastScore = scores[i];
        }
        System.out.println(count);
    }
}
