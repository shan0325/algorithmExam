package com.algorithm.codingTest.kit.binaraySearch.ex02;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43236
 */
public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int start = 0;
        int end = distance;
        while (start <= end) {
            int mid = (start + end) / 2;
            int before = 0;
            int cnt = 0;

            for (int i = 0; i < rocks.length; i++) {
                if(rocks[i] - before < mid) {
                    cnt++;
                } else {
                    before = rocks[i];
                }
            }

            if(distance - before < mid) cnt++;

            if(cnt <= n) {
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 13, 11, 21, 17};
        int n = 2;

        Solution solution = new Solution();
        int answer = solution.solution(distance, rocks, n);
        System.out.println(answer);
    }

}
