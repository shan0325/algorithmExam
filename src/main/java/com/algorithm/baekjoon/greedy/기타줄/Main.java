package com.algorithm.baekjoon.greedy.기타줄;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int packageAmount = Integer.MAX_VALUE;
        int amount = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            packageAmount = Math.min(packageAmount, in.nextInt());
            amount = Math.min(amount, in.nextInt());
        }
        boolean isPACheaper = packageAmount / 6 < amount;

        long sum = 0;
        while (N > 0) {
            if (isPACheaper && N >= 6) {
                sum += (long) N / 6 * packageAmount;
                N = N % 6;
            } else {
                int temp = N * amount;
                if (N < 6 && temp > packageAmount) {
                    temp = packageAmount;
                }
                sum += temp;
                N = 0;
            }
        }
        System.out.println(sum);
    }
}
