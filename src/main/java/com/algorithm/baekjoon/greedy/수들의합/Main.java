package com.algorithm.baekjoon.greedy.수들의합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long S = in.nextLong();

        long N = 1;
        while (S >= N) {
            S -= N++;
        }
        System.out.println(N - 1);
    }
}
