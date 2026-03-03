package com.algorithm.codingTest.all.level2.광물캐기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    int minVal = Integer.MAX_VALUE;

    // dfs를 사용하여 해결
    public int solution(int[] picks, String[] minerals) {
        int picksCount = Arrays.stream(picks).sum();
        int[][] fatigueScore = {
                {1, 1, 1},
                {5, 1, 1},
                {25, 5, 1}
        };
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < picksCount; i++) {
            if (i * 5 > minerals.length) break;

            int dia = 0;
            int iron = 0;
            int stone = 0;
            for (int j = i * 5; j < (i + 1) * 5; j++) {
                if (j >= minerals.length) break;

                String mineral = minerals[j];
                int val = "diamond".equals(mineral) ? 0 : "iron".equals(mineral) ? 1 : 2;
                dia += fatigueScore[0][val];
                iron += fatigueScore[1][val];
                stone += fatigueScore[2][val];
            }
            list.add(new int[]{dia, iron, stone});
        }
        list.stream().forEach(a -> System.out.println("Arrays.toString(a) = " + Arrays.toString(a)));

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int[] picksClone = picks.clone();
                picksClone[i]--;
                dfs(picksClone, list, i, 0, 0);
            }
        }

        return minVal;
    }

    private void dfs(int[] picks, List<int[]> list, int pick, int loc, int sum) {
        int[] fatigueVals = list.get(loc);
        sum += fatigueVals[pick];
        loc++;

        if (loc >= list.size()) {
            if (minVal > sum) {
                minVal = sum;
            }
            return;
        }

        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            if (minVal > sum) {
                minVal = sum;
            }
            return;
        }

        if (sum >= minVal) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int[] picksClone = picks.clone();
                picksClone[i]--;
                dfs(picksClone, list, i, loc, sum);
            }
        }
    }

    public static void main(String[] args) {
        int[] picks = {1, 3, 2}; // 12
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

//        int[] picks = {0, 1, 1}; // 50
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

//        int[] picks = {1, 0, 0}; // 5
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

//        int[] picks = {0, 0, 1}; // 125
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

//        int[] picks = {1, 0, 1}; // 47
//        String[] minerals = {"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond"};

        Solution3 solution = new Solution3();
        int answer = solution.solution(picks, minerals);
        System.out.println("answer = " + answer);
    }
}
