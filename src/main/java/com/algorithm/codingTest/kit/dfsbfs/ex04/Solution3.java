package com.algorithm.codingTest.kit.dfsbfs.ex04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 안풀림
 */
public class Solution3 {
    private List<String> result;

    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                int[] visitedIndex = new int[tickets.length];
                visitedIndex[i] = 1;

                List<String> visitedStr = new ArrayList<>();
                visitedStr.add(tickets[i][0]);
                visitedStr.add(tickets[i][1]);

                dfs(tickets, i, visitedIndex, visitedStr, 1);
            }
        }
        return result.toArray(new String[0]);
    }

    public boolean dfs(String[][] tickets, int index, int[] visitedIndex, List<String> visitedStr, int depth) {
        if (depth >= tickets.length) {
            if (result == null) {
                result = visitedStr;
                return true;
            }

            for (int i = 0; i < visitedStr.size(); i++) {
                String before = result.get(i);
                String current = visitedStr.get(i);
                if (before.compareTo(current) < 0) {
                    result = visitedStr;
                    return true;
                }
            }
            return true;
        }

        String dest = tickets[index][1];
        boolean find = false;
        for (int i = 0; i < tickets.length; i++) {
            if (visitedIndex[i] != 1 && tickets[i][0].equals(dest)) {
                find = true;
                visitedIndex[i] = 1;
                visitedStr.add(tickets[i][1]);
                boolean resultFind = dfs(tickets, i, visitedIndex, visitedStr, depth + 1);
                if (!resultFind) {
                    visitedIndex[i] = 0;
                    visitedStr.remove(visitedStr.size() - 1);
                    find = false;
                }
            }
        }
        return find;
    }

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "CCC"}, {"CCC", "QQQ"}, {"AAA", "ICN"}}; //{"ICN", "AAA", "ICN", "AAA", "CCC", "QQQ"}
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}; //{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
//        String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}}; //{"ICN", "B", "ICN", "A", "D", "A"}
//        String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"},{"SFO", "JFK"}}; //{"ICN", "SFO", "ICN", "SFO", "JFK"}
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"},{"A", "C"}}; //{"ICN", "A", "ICN", "A", "C"}
//        String[][] tickets = {{"ICN", "A"}, {"A", "ICN"}, {"A", "B"},{"ICN", "A"}}; //{"ICN", "A", "ICN", "A", "B"}
//        String[][] tickets = {{"ICN", "BBB"}, {"AAA", "ICN"}, {"ICN", "AAA"}}; //{"ICN", "AAA", "ICN", "BBB"}
//        String[][] tickets = {{"ICN", "ABB"}, {"AAA", "ICN"}, {"ICN", "AAA"}, {"ICN", "ADD"}, {"ABB", "ICN"}}; //{"ICN", "AAA", "ICN", "ABB", "ICN", "ADD"}
//        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"},{"AAA", "ICN"}, {"AAA", "ICN"}}; //{"ICN", "AAA", "ICN", "AAA", "ICN", "AAA"}

        Solution3 solution = new Solution3();
        String[] answer = solution.solution(tickets);
        System.out.println(Arrays.toString(answer));
    }
}
