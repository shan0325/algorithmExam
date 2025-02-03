package com.algorithm.baekjoon.greedy.로프;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int w = 0;
        for (int i = 0; i < N; i++) {
            w = Math.max(w, arr[i] * (i + 1));
        }
        System.out.println(w);
    }
}
