package com.algorithm.baekjoon.greedy.잃어버린괄호;

import javax.script.ScriptException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);
        String q = in.next();
        String[] mArr = q.split("-");

        int result = 0;
        for (int i = 0; i < mArr.length; i++) {
            String[] pArr = mArr[i].split("\\+");
            int sum = pArr.length == 1 ? Integer.parseInt(mArr[i]) : Arrays.stream(pArr).mapToInt(Integer::parseInt).sum();
            result = i == 0 ? sum : result - sum;
        }
        System.out.println(result);
    }
}
