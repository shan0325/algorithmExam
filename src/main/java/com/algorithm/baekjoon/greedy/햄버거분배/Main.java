package com.algorithm.baekjoon.greedy.햄버거분배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] ca = br.readLine().toCharArray();

        int count = 0;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != 'P') continue;

            for (int j = i - K; j <= i + K; j++) {
                if (j < 0) continue;
                if (j >= N) break;
                if (ca[j] == 'H') {
                    count++;
                    ca[j] = 'X';
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
