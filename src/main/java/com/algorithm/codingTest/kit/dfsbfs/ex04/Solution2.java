package com.algorithm.codingTest.kit.dfsbfs.ex04;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        boolean[][] visited = new boolean[tickets.length][tickets.length];
        String[][] ticketsTable = new String[tickets.length][tickets.length];
        int[] indexTable = new int[tickets.length];
        int start = 0;
        int count = 0;

        for (int i = 0; i < tickets.length; i++) {
            count = 0;
            for (int j = 0; j < start; j++) {
                if (tickets[i][0].equals(ticketsTable[j][0])) {
                    count = 1;
                    ticketsTable[j][indexTable[j]] = tickets[i][1];
                    indexTable[j]++;
                }
            }
            if (count == 0) {
                ticketsTable[start][0] = tickets[i][0];
                ticketsTable[start][1] = tickets[i][1];
                indexTable[start] = 2;
                start++;
            }
        }

        for (int i = 0; i < ticketsTable.length; i++) {
            for (int j = 1; j < ticketsTable[i].length; j++) {
                for (int k = j + 1; k < ticketsTable[i].length; k++) {
                    if(ticketsTable[i][j] == null || ticketsTable[i][k] == null) continue;
                    if(ticketsTable[i][j].compareTo(ticketsTable[i][k]) > 0) {
                        String temp = ticketsTable[i][j];
                        ticketsTable[i][j] = ticketsTable[i][k];
                        ticketsTable[i][k] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < ticketsTable.length; i++) {
            for (int j = 0; j < ticketsTable[i].length; j++) {
                System.out.print(ticketsTable[i][j] + ", ");
            }
            System.out.println();
        }

        int answerCnt = 1;
        answer[0] = "ICN";
        dfs(0, "ICN", ticketsTable, answer, answerCnt, visited);

        System.out.println();
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
        System.out.println();

        return answer;
    }

    public boolean dfs(int n, String start, String[][] ticketsTable, String[] answer, int answerCnt, boolean[][] visited) {
        if(n == ticketsTable.length) {
            return true;
        }

        boolean search = false;
        for (int i = 0; i < ticketsTable.length; i++) {
            if(ticketsTable[i][0] == null) break;
            if(start.equals(ticketsTable[i][0])) {
                for (int j = 1; j < ticketsTable[i].length; j++) {
                    if(ticketsTable[i][j] == null) break;
                    if(!visited[i][j]) {
                        search = true;
                        visited[i][j] = true;
                        answer[answerCnt] = ticketsTable[i][j];
                        boolean result = dfs(n + 1, ticketsTable[i][j], ticketsTable, answer, answerCnt + 1, visited);
                        if(!result) {
                            visited[i][j] = false;
                            answer[answerCnt] = null;
                            search = false;
                        }
                    }
                }
            }
        }
        return search;
    }

    public static void main(String[] args) {
        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        //String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "CCC"}, {"CCC", "QQQ"}, {"AAA", "ICN"}}; //{"ICN", "AAA", "ICN", "AAA", "CCC", "QQQ"}
        //String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}; //{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
        //String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}}; //{"ICN", "B", "ICN", "A", "D", "A"}
        //String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"},{"SFO", "JFK"}}; //{"ICN", "SFO", "ICN", "SFO", "JFK"}
        //String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"},{"A", "C"}}; //{"ICN", "A", "ICN", "A", "C"}
        //String[][] tickets = {{"ICN", "A"}, {"A", "ICN"}, {"A", "B"},{"ICN", "A"}}; //{"ICN", "A", "ICN", "A", "B"}
        //String[][] tickets = {{"ICN", "BBB"}, {"AAA", "ICN"}, {"ICN", "AAA"}}; //{"ICN", "AAA", "ICN", "BBB"}
        //String[][] tickets = {{"ICN", "ABB"}, {"AAA", "ICN"}, {"ICN", "AAA"}, {"ICN", "ADD"}, {"ABB", "ICN"}}; //{"ICN", "AAA", "ICN", "ABB", "ICN", "ADD"}
        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"},{"AAA", "ICN"}, {"AAA", "ICN"}}; //{"ICN", "AAA", "ICN", "AAA", "ICN", "AAA"}

        Solution2 solution = new Solution2();
        solution.solution(tickets);

    }
}
