package com.algorithm.baekjoon.greedy.설탕배달;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int count = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                count += n / 5;
                System.out.println(count);
                return;
            }
            if (n < 3) {
                System.out.println(-1);
                return;
            }
            n -= 3;
            count++;
        }
    }
}
