package com.algorithm.codingTest.kit.dfsbfs.ex03;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!Arrays.asList(words).contains(target)) {
            return answer;
        }

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[] {begin, 0, new int[words.length]});

        while (!queue.isEmpty()) {
            Object[] poll = queue.poll();
            String beginStr = (String) poll[0];
            Integer step = (Integer) poll[1];
            int[] visited = (int[]) poll[2];

            if (beginStr.equals(target)) {
                return step;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i] == 1) continue;
                String word = words[i];

                int count = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (count > 1) break;
                    if (beginStr.charAt(j) != word.charAt(j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    visited[i] = 1;
                    int[] copyVisited = visited.clone();
                    queue.offer(new Object[]{word, step + 1, copyVisited});
                }
            }
        }

        return answer;
    }

	public static void main(String[] args) {
		String begin = "hit", target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		//String[] words = {"hot", "dot", "dog", "cog"};
		//String[] words = {"hot", "dot", "lot", "cog"};
		//String[] words = {"hot", "dot", "dog", "lot", "log"};

		Solution3 solution = new Solution3();
		int answer = solution.solution(begin, target, words);
		System.out.println("answer : " + answer);
	}
}
