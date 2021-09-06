package com.algorithm.codingTest.kit.graph.ex03;

import org.apache.tomcat.jni.Proc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int solution(int[] arrows) {
        int answer = 0;
        int n = 10;
        int[][] graph = new int[n][n];
        int num = 0;
        List<List<Integer>> list = new ArrayList<>();

        int rowLoc = (n / 2) - 1;
        int colLoc = (n / 2) - 1;
        graph[rowLoc][colLoc] = 1;

        List<Integer> log = new ArrayList<>();
        log.add(rowLoc);
        log.add(colLoc);
        list.add(log);
        for (int i = 0; i < arrows.length; i++) {
            switch (arrows[i]) {
                case 0: rowLoc--; break;
                case 1: rowLoc--; colLoc++; break;
                case 2: colLoc++; break;
                case 3: rowLoc++; colLoc++; break;
                case 4: rowLoc++; break;
                case 5: rowLoc++; colLoc--; break;
                case 6: colLoc--; break;
                case 7: rowLoc--; colLoc--; break;
            }
            graph[rowLoc][colLoc] = 1;

            log = new ArrayList<>();
            log.add(rowLoc);
            log.add(colLoc);

            if(list.contains(log)) {
                answer++;
            }

            list.add(log);
        }

        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        System.out.println("======================================");

        System.out.println(list);

        return answer;
    }

    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        Solution solution = new Solution();
        int answer = solution.solution(arrows);
        System.out.println(answer);
    }
}
