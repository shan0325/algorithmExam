package com.algorithm.baekjoon.greedy.폴리오미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String replace = line.replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");
        if (replace.contains("X")) {
            System.out.println("-1");
        } else {
            System.out.println(replace);
        }
    }
}
