package com.algorithm.codingTest.kit.dfsbfs.ex01;

import java.util.Arrays;

public class Solution2 {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        for (int i = 0; i < numbers.length; i++) {
            answer += dfs(numbers, target, 0, 0, i + 1);
        }
        return answer;
    }

    public int dfs(int[] numbers, int target, int start, int depth, int targetDepth) {
        if (depth == targetDepth) {
            int sum = Arrays.stream(numbers).sum();
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        for (int i = start; i < numbers.length; i++) {
            numbers[i] = -numbers[i];
            result += dfs(numbers, target, i + 1, depth + 1, targetDepth);
            numbers[i] = -numbers[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
//        int[] numbers = {4, 1, 2, 1};
        int target = 3;

        Solution2 solution = new Solution2();
        System.out.println(solution.solution(numbers, target));
    }

}
