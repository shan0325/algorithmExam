package com.algorithm.baekjoon.greedy.뒤집기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int[] arr = new int[2];

        String before = "";
        for (int i = 0; i < S.length(); i++) {
            String num = String.valueOf(S.charAt(i));
            if (!before.equals(num)) {
                arr[Integer.parseInt(num)] += 1;
                before = num;
            }
        }

        if (arr[0] == 0 || arr[1] == 0) {
            System.out.println(0);
        } else {
            System.out.println(Math.min(arr[0], arr[1]));
        }
    }
}
