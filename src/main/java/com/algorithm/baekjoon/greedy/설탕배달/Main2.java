package com.algorithm.baekjoon.greedy.설탕배달;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int m = n / 5;
        while (m >= 0) {
            int k = n - (m * 5);
            if (k % 3 == 0) {
                System.out.println(m + (k / 3));
                return;
            }
            m--;
        }
        System.out.println(-1);
    }
}
