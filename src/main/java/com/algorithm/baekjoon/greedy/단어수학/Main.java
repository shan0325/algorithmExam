package com.algorithm.baekjoon.greedy.단어수학;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[26];
        for (int i = 0; i < N; i++) {
            String str = in.next();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                arr[c - 'A'] += Math.pow(10, str.length() - 1 - j);
            }
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);

        int num = 9;
        int ans = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans += arr[i] * num;
            num--;
        }
        System.out.println(ans);
    }
}
