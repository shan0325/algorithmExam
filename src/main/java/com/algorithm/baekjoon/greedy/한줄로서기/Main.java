package com.algorithm.baekjoon.greedy.한줄로서기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> answer = new ArrayList<>();

        for (int i = N - 1; i >= 0 ; i--) {
            answer.add(array[i], i + 1);
        }

        answer.forEach(n -> System.out.print(n + " "));
    }
}
