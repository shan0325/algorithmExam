package com.algorithm.baekjoon.greedy.거스름돈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = {500, 100, 50, 10, 5, 1};
        int money = 1000 - n;
        int count = 0;

        for (int i : arr) {
            if (money == 0) break;
            count += money / i;
            money = money % i;
        }
        System.out.println(count);
    }
}
