package com.algorithm.baekjoon.greedy.ATOB;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N = in.nextLine();
        String[] arr = N.split(" ");
        long A = Long.parseLong(arr[0]);
        long B = Long.parseLong(arr[1]);

        long count = 1;
        while (A != B) {
            if (A > B) {
                System.out.println(-1);
                return;
            }

            if (B % 10 == 1) {
                B /= 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                System.out.println(-1);
                return;
            }
            count++;
        }
        System.out.println(count);
    }
}
