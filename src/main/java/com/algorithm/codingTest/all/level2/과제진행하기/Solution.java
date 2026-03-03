package com.algorithm.codingTest.all.level2.과제진행하기;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution {

    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (p1, p2) -> {
            LocalTime time1 = LocalTime.parse(p1[1], DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime time2 = LocalTime.parse(p2[1], DateTimeFormatter.ofPattern("HH:mm"));
            return time1.compareTo(time2);
        });

        Queue<String[]> plansQueue = new LinkedList<>();
        for (String[] plan : plans) {
            plansQueue.offer(plan);
            System.out.println("Arrays.toString(plan) = " + Arrays.toString(plan));
        }

        List<String> result = new ArrayList<>();
        Stack<String[]> stopPlans = new Stack<>();
        int nextMinute = 0;
        while (!plansQueue.isEmpty()) {
            String[] curPlan = plansQueue.poll();
            LocalTime curTime = LocalTime.parse(curPlan[1], DateTimeFormatter.ofPattern("HH:mm"));
//            int curEndMinute = curTime.plusMinutes(Integer.parseInt(curPlan[2])).toSecondOfDay() / 60; // 이걸로 하면 안됨.. 왜 안되는지 모르겠음
            int curEndMinute = (curTime.toSecondOfDay() / 60) + Integer.parseInt(curPlan[2]);

            if (plansQueue.peek() != null) {
                String[] nextPlan = plansQueue.peek();
                LocalTime nextTime = LocalTime.parse(nextPlan[1], DateTimeFormatter.ofPattern("HH:mm"));
                nextMinute = nextTime.toSecondOfDay() / 60;
                if (curEndMinute > nextMinute) {
                    int remainingMinute = curEndMinute - nextMinute;
                    curPlan[2] = String.valueOf(remainingMinute);
                    stopPlans.add(curPlan);
                    continue;
                }
            }
            result.add(curPlan[0]);

            // 남은 시간 동안 멈춘 과제를 할 수 있는지 체크
            while (!stopPlans.isEmpty()) {
                int curRemainingMinute = nextMinute - curEndMinute;
                String[] plan = stopPlans.pop();
                int stopRemainingMinute = Integer.parseInt(plan[2]);

                if (curRemainingMinute >= stopRemainingMinute) {
                    result.add(plan[0]);
                    curEndMinute += stopRemainingMinute;
                } else {
                    int remainingMinute = stopRemainingMinute - curRemainingMinute;
                    plan[2] = String.valueOf(remainingMinute);
                    stopPlans.add(plan);
                    break;
                }
            }
        }

        while (!stopPlans.isEmpty()) {
            result.add(stopPlans.pop()[0]);
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
//        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
//        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};

        Solution solution = new Solution();
        String[] answer = solution.solution(plans);
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
