package com.algorithm.baekjoon.greedy.ATOB;

import java.util.*;

public class Main {
    private static List<Long> successList = new ArrayList<>();

    /**
     * 재귀함수로 풀기
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N = in.nextLine();
        String[] arr = N.split(" ");

        recursive(1, Long.parseLong(arr[0]), Long.parseLong(arr[1]));
        if (successList.size() > 0) {
            System.out.println(successList.stream().mapToLong(Long::longValue).min().getAsLong());
        } else {
            System.out.println(-1);
        }
    }

    public static void recursive(long depth, long a, long b) {
        for (int i = 0; i < 2; i++) {
            long val = i == 0 ? a * 2 : Long.parseLong(a + "1");

            if (val == b) {
                successList.add(depth + 1);
                return;
            }
            if (val > b) return;
            recursive(depth + 1, val, b);
        }
    }
}
