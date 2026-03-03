package com.algorithm.baekjoon.greedy.캠핑;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int number = 1;
        while (true) {
            int L = scanner.nextInt();
            int P = scanner.nextInt();
            int V = scanner.nextInt();

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int answer = (V / P) * L + Math.min(V % P, L);
            sb.append("Case ").append(number).append(": ").append(answer).append("\n");
            number++;
        }
        System.out.println(sb.toString());
    }
}
