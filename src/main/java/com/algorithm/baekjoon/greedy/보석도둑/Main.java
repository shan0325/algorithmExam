package com.algorithm.baekjoon.greedy.보석도둑;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[][] infos = new int[N][2];
        for (int i = 0; i < N; i++) {
            infos[i][0] = in.nextInt();
            infos[i][1] = in.nextInt();
        }
        int[] bagWeights = new int[K];
        for (int i = 0; i < K; i++) {
            bagWeights[i] = in.nextInt();
        }
        Arrays.sort(bagWeights);
        Arrays.sort(infos, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(infos[i]));
        }

        long sum = 0;
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < K; i++) {
            while (index < N) {
                if (bagWeights[i] < infos[index][0]) break;
                queue.add(infos[index][1]);
                index++;
            }
            if (!queue.isEmpty()) {
                sum += queue.poll();
            }
        }
        System.out.println(sum);
    }
}
