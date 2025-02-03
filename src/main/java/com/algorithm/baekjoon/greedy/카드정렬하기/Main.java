package com.algorithm.baekjoon.greedy.카드정렬하기;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.add(in.nextLong());
        }

        long sum = 0;
        while (queue.size() > 1) {
            Long poll1 = queue.poll();
            Long poll2 = queue.poll();

            long curSum = poll1 + poll2;
            sum += curSum;
            queue.add(curSum);
        }
        System.out.println(sum);
    }
}
