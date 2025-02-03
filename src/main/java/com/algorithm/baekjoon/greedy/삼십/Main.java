package com.algorithm.baekjoon.greedy.삼십;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N = in.next();

        Integer[] numbers = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            numbers[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
        }
        Arrays.sort(numbers, (o1, o2) -> o2 - o1);

        String join = Arrays.stream(numbers).map(String::valueOf).collect(Collectors.joining());
        BigInteger bigInteger = new BigInteger(join);
        BigInteger remainder = bigInteger.remainder(new BigInteger("30"));
        if (!remainder.equals(new BigInteger("0"))) {
            System.out.println(-1);
        } else {
            System.out.println(join);
        }
    }
}
