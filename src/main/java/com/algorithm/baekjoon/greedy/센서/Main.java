package com.algorithm.baekjoon.greedy.센서;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        if (N <= K) {
            System.out.println(0);
            return;
        }

        Integer[] diff = new Integer[N - 1];
        for (int i = 1; i < N; i++) {
            diff[i - 1] = arr[i] - arr[i - 1];
        }
        Arrays.sort(diff, (o1, o2) -> o2 - o1);

        int sum = 0;
        for (int i = K - 1; i < diff.length; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}
