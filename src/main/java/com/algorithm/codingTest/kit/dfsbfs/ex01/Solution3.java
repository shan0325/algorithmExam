package com.algorithm.codingTest.kit.dfsbfs.ex01;

import java.util.Arrays;

public class Solution3 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0);
    }

    public int dfs(int[] numbers, int target, int index) {
        if (index == numbers.length) {
            if (Arrays.stream(numbers).sum() == target) {
                return 1;
            }
            return 0;
        }

        int plusResult = dfs(numbers, target, index + 1);

        numbers[index] = -numbers[index];
        int minusResult = dfs(numbers, target, index + 1);
        numbers[index] = -numbers[index];

        return plusResult + minusResult;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
//        int[] numbers = {4, 1, 2, 1};
        int target = 3;

        Solution3 solution = new Solution3();
        System.out.println(solution.solution(numbers, target));
    }

}
