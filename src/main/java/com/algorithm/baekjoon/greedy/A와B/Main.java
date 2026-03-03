package com.algorithm.baekjoon.greedy.A와B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String T = scanner.nextLine();

        while (!T.isEmpty()) {
            String last = T.substring(T.length() - 1);
            T = T.substring(0, T.length() - 1);
            if (last.equals("B")) {
                T = new StringBuffer(T).reverse().toString();
            }

            if (T.equals(S)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
