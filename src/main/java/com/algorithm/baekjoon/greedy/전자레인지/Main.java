package com.algorithm.baekjoon.greedy.전자레인지;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        int[] sec = new int[3];
        sec[0] = T / 300;
        T = T % 300;

        sec[1] = T / 60;
        T = T % 60;

        sec[2] = T / 10;
        T = T % 10;

        if (T > 0) {
            System.out.println(-1);
        } else {
            for (int s : sec) {
                System.out.print(s + " ");
            }
        }
    }
}
