package com.algorithm.codingTest.all.level2.광물캐기;

public class Solution2 {
    int minVal = Integer.MAX_VALUE;

    // dfs를 사용하여 해결
    public int solution(int[] picks, String[] minerals) {
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int[] picksClone = picks.clone();
                picksClone[i]--;
                dfs(picksClone, minerals, i, 0, 0);
            }
        }
        return minVal;
    }

    private void dfs(int[] picks, String[] minerals, int pick, int loc, int sum) {
        int maxIndex = loc + 5;
        while (loc < maxIndex) {
            if (loc >= minerals.length) {
                break;
            }

            if (pick == 0) {
                sum++;
            } else if (pick == 1) {
                if ("diamond".equals(minerals[loc])) {
                    sum += 5;
                } else {
                    sum++;
                }
            } else {
                if ("diamond".equals(minerals[loc])) {
                    sum += 25;
                } else if ("iron".equals(minerals[loc])) {
                    sum += 5;
                } else {
                    sum++;
                }
            }
            loc++;
        }

        if (loc >= minerals.length) {
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

        // 이전에 구한 값보다 크면 return
        if (sum >= minVal) {
            return;
        }

        for (int i= 0; i < 3; i++) {
            if (picks[i] > 0) {
                int[] pickClone = picks.clone();
                pickClone[i]--;
                dfs(pickClone, minerals, i, loc, sum);
            }
        }
    }

    public static void main(String[] args) {
//        int[] picks = {1, 3, 2}; // 12
//        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

//        int[] picks = {0, 1, 1}; // 50
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

//        int[] picks = {1, 0, 0}; // 5
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

//        int[] picks = {0, 0, 1}; // 125
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        int[] picks = {1, 0, 1}; // 47
        String[] minerals = {"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond"};

        Solution2 solution = new Solution2();
        int answer = solution.solution(picks, minerals);
        System.out.println("answer = " + answer);
    }
}
