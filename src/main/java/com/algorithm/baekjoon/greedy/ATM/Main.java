package com.algorithm.baekjoon.greedy.ATM;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int time = arr[0];
        for (int i = 1; i < n; i++) {
            time = time + arr[i];
            arr[i] = time;
        }
        System.out.println(Arrays.stream(arr).sum());
    }
}
