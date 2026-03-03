package com.algorithm.baekjoon.greedy.국회의원선거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int result = 0;
        while (true) {
            list.sort(Comparator.reverseOrder());
            if (K > list.get(0)) {
                break;
            } else {
                result++;
                K++;
                list.set(0, list.get(0) - 1);
            }
        }
        System.out.println(result);
    }
}
