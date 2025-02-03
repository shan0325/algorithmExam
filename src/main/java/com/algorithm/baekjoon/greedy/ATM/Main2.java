package com.algorithm.baekjoon.greedy.ATM;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int prev = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += prev + arr[i];
            prev += arr[i];
        }
        System.out.println(sum);
    }
}
