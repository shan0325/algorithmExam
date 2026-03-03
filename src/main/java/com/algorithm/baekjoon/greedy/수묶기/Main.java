package com.algorithm.baekjoon.greedy.수묶기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = in.nextInt();
            if (num <= 0) {
                minus.add(num);
            } else {
                plus.add(num);
            }
        }
        Collections.sort(minus);
        plus.sort(Comparator.reverseOrder());

        long sum = 0;
        for (int i = 0; i < minus.size(); i += 2) {
            Integer num = minus.get(i);
            Integer num2 = i + 1 < minus.size() ? minus.get(i + 1) : null;
            sum += num2 == null ? num : (long) num * num2;
        }
        for (int i = 0; i < plus.size(); i += 2) {
            Integer num = plus.get(i);
            Integer num2 = i + 1 < plus.size() ? plus.get(i + 1) : null;

            if (num2 == null) {
                sum += num;
            } else if (num == 1 || num2 == 1) {
                sum += num + num2;
            } else {
                sum += (long) num * num2;
            }
        }
        System.out.println(sum);
    }
}
