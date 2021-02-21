package com.algorithm.codingTest.kit.dfsbfs.ex03;


import java.util.Arrays;

public class Solution2 {
	public int solution(String begin, String target, String[] words) {
		int answer = words.length;

		if(!Arrays.asList(words).contains(target)) {
			return 0;
		}

		answer = dfs(0, begin, target, answer, words, new boolean[words.length]);

		return answer;
    }

    public int dfs(int visitCnt, String begin, String target, int answer, String[] words, boolean[] visited) {
		for (int i = 0; i < words.length; i++) {
			if(!visited[i] && change(begin, words[i]) == 1) {
				if(words[i].equals(target)) {
					return Math.min(answer, visitCnt + 1);
				}

				visited[i] = true;
				int num = dfs(visitCnt + 1, words[i], target, answer, words, visited);
				System.out.println("num : " + num + " // visitCnt : " + visitCnt + " // answer : " + answer);
				if(num < answer) answer = num;
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

		Solution2 solution = new Solution2();
		int answer = solution.solution(begin, target, words);
		System.out.println("answer : " + answer);
	}

	public int change(String w1, String w2) {
		int count = 0;
		for (int i = 0; i < w1.length(); i++) {
			if(w1.charAt(i) != w2.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
