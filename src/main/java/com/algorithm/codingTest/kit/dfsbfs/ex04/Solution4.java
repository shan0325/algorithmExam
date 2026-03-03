package com.algorithm.codingTest.kit.dfsbfs.ex04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution4 {
    static boolean[] visited;
    static List<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    public void dfs(int cnt, String icn, String word, String[][] tickets) {
        if (cnt == tickets.length) {
            list.add(word);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(icn)) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], word + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "CCC"}, {"CCC", "QQQ"}, {"AAA", "ICN"}}; //{"ICN", "AAA", "ICN", "AAA", "CCC", "QQQ"}
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}; //{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
//        String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}}; //{"ICN", "B", "ICN", "A", "D", "A"}
//        String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"},{"SFO", "JFK"}}; //{"ICN", "SFO", "ICN", "SFO", "JFK"}
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"},{"A", "C"}}; //{"ICN", "A", "ICN", "A", "C"}
//        String[][] tickets = {{"ICN", "A"}, {"A", "ICN"}, {"A", "B"},{"ICN", "A"}}; //{"ICN", "A", "ICN", "A", "B"}
//        String[][] tickets = {{"ICN", "BBB"}, {"AAA", "ICN"}, {"ICN", "AAA"}}; //{"ICN", "AAA", "ICN", "BBB"}
//        String[][] tickets = {{"ICN", "ABB"}, {"AAA", "ICN"}, {"ICN", "AAA"}, {"ICN", "ADD"}, {"ABB", "ICN"}}; //{"ICN", "AAA", "ICN", "ABB", "ICN", "ADD"}
//        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"},{"AAA", "ICN"}, {"AAA", "ICN"}}; //{"ICN", "AAA", "ICN", "AAA", "ICN", "AAA"}

        Solution4 solution = new Solution4();
        String[] answer = solution.solution(tickets);
        System.out.println(Arrays.toString(answer));
    }
}
