package com.algorithm.codingTest.kit.dfsbfs.ex04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * 문제 설명
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
 * 주어진 공항 수는 3개 이상 10,000개 이하입니다.
 * tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
 * 주어진 항공권은 모두 사용해야 합니다.
 * 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
 * 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 *
 * 입출력 예
 * tickets	                                                                            return
 * [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	                                    ["ICN", "JFK", "HND", "IAD"]
 * [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	    ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 *
 * 입출력 예 설명
 * 예제 #1
 * ["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.
 *
 * 예제 #2
 * ["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
 */
public class Solution {

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

        dfs(0, "ICN", ticketsTable, answer, visited);

        System.out.println();
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
        System.out.println();

        return answer;
    }

    // answer에 담았을때
    /*public void dfs(int n, String start, String[][] ticketsTable, String[] answer, boolean[][] visited) {
        Stack<List<String>> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        list.add(start);
        list.add("0");
        list.add("1");
        stack.push(list);

        int answerCnt = 0;
        int i = 0;
        int j = 1;
        while (!stack.isEmpty()) {
            System.out.println(stack);

            List<String> tList = stack.peek();
            String t = tList.get(0);

            if(answerCnt == ticketsTable.length) {
                answer[answerCnt] = t;
                break;
            }

            boolean search = false;
            for (; i < ticketsTable.length; i++) {
                if(ticketsTable[i][0] == null || search) break;

                if(t.equals(ticketsTable[i][0])) {
                    for (; j < ticketsTable.length; j++) {
                        if(ticketsTable[i][j] == null) break;

                        if(!visited[i][j]) {
                            search = true;
                            visited[i][j] = true;
                            answer[answerCnt++] = t;

                            List<String> list2 = new ArrayList<>();
                            list2.add(ticketsTable[i][j]);
                            list2.add(String.valueOf(i));
                            list2.add(String.valueOf(j));
                            stack.push(list2);
                            break;
                        }
                    }
                }
            }
            i = 0;
            j = 1;
            if (!search) {
                System.out.println("끝남!! : " + tList);
                visited[Integer.parseInt(tList.get(1))][Integer.parseInt(tList.get(2))] = false;
                i = Integer.parseInt(tList.get(1));
                j = Integer.parseInt(tList.get(2)) + 1;
                answerCnt--;
                stack.pop();
            }
        }
    }*/

    // stack에 담았을때
    public void dfs(int n, String start, String[][] ticketsTable, String[] answer, boolean[][] visited) {
        Stack<List<String>> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        list.add(start);
        list.add("0");
        list.add("1");
        stack.push(list);

        int i = 0;
        int j = 1;
        while (stack.size() < ticketsTable.length + 1) {
            System.out.println(stack);

            List<String> tList = stack.peek();
            String t = tList.get(0);

            boolean search = false;
            for (; i < ticketsTable.length; i++) {
                if(ticketsTable[i][0] == null || search) break;

                if(t.equals(ticketsTable[i][0])) {
                    for (; j < ticketsTable.length; j++) {
                        if(ticketsTable[i][j] == null) break;

                        if(!visited[i][j]) {
                            search = true;
                            visited[i][j] = true;

                            List<String> list2 = new ArrayList<>();
                            list2.add(ticketsTable[i][j]);
                            list2.add(String.valueOf(i));
                            list2.add(String.valueOf(j));
                            stack.push(list2);
                            break;
                        }
                    }
                }
            }
            i = 0;
            j = 1;
            if (!search) {
                System.out.println("끝남!! : " + tList);
                visited[Integer.parseInt(tList.get(1))][Integer.parseInt(tList.get(2))] = false;
                i = Integer.parseInt(tList.get(1));
                j = Integer.parseInt(tList.get(2)) + 1;
                stack.pop();
            }
        }
        System.out.println(stack);
    }

    public static void main(String[] args) {
        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "CCC"}, {"CCC", "QQQ"}, {"AAA", "ICN"}}; //{"ICN", "AAA", "ICN", "AAA", "CCC", "QQQ"}
        //String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}; //{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
        //String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}}; //{"ICN", "B", "ICN", "A", "D", "A"}
        //String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"},{"SFO", "JFK"}}; //{"ICN", "SFO", "ICN", "SFO", "JFK"}
        //String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"},{"A", "C"}}; //{"ICN", "A", "ICN", "A", "C"}
        //String[][] tickets = {{"ICN", "A"}, {"A", "ICN"}, {"A", "B"},{"ICN", "A"}}; //{"ICN", "A", "ICN", "A", "B"}
        //String[][] tickets = {{"ICN", "BBB"}, {"AAA", "ICN"}, {"ICN", "AAA"}}; //{"ICN", "AAA", "ICN", "BBB"}
        //String[][] tickets = {{"ICN", "ABB"}, {"AAA", "ICN"}, {"ICN", "AAA"}, {"ICN", "ADD"}, {"ABB", "ICN"}}; //{"ICN", "AAA", "ICN", "ABB", "ICN", "ADD"}
        //String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"},{"AAA", "ICN"}, {"AAA", "ICN"}}; //{"ICN", "AAA", "ICN", "AAA", "ICN", "AAA"}

        Solution solution = new Solution();
        solution.solution(tickets);

    }
}
