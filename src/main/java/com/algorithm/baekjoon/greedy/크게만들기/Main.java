package com.algorithm.baekjoon.greedy.크게만들기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        String num = scanner.next();

        Stack<Integer> stack = new Stack<>();

        int minus = K;
        for (int i = 0; i < N; i++) {
            int n = Character.getNumericValue(num.charAt(i));
            while (!stack.isEmpty() && stack.peek() < n && minus > 0) {
                stack.pop();
                minus--;
            }

            if (stack.size() < N - K) {
                stack.push(n);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}
