package com.algorithm.baekjoon.greedy.강의실배정;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
        // 성공하지만 BufferedReader보다 속도가 오래걸림
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] classes = new int[N][2];

        for (int i = 0; i < N; i++) {
            classes[i][0] = scanner.nextInt();
            classes[i][1] = scanner.nextInt();
        }

        Arrays.sort(classes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(0);
        for (int i = 0; i < N; i++) {
            if (pq.peek() <= classes[i][0]) {
                pq.poll();
            }
            pq.offer(classes[i][1]);
        }
        System.out.println(pq.size());
    }
}
