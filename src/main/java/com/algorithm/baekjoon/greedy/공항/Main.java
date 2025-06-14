package com.algorithm.baekjoon.greedy.공항;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[P];
        for (int i = 0; i < P; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] next = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            next[i] = i;
        }

        int count = 0;
        for (int i = 0; i < P; i++) {
            Integer gi = arr[i];
            int gate = find(next, gi);
            if (gate == 0) break;

            count++;
            union(next, gate, gate - 1);
        }
        System.out.println(count);
    }

    public static int find(int[] next, int gi) {
        if (next[gi] == gi) {
            return gi;
        }
        return next[gi] = find(next, next[gi]);
    }

    public static void union(int[] next, int x, int y) {
        x = find(next, x);
        y = find(next, y);

        if (x != y) {
            next[x] = y;
        }
    }
}
