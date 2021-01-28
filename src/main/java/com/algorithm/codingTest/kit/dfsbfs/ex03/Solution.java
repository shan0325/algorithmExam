package com.algorithm.codingTest.kit.dfsbfs.ex03;


public class Solution {
	public int solution(String begin, String target, String[] words) {
        int answer = words.length + 1;

        answer = dfs(begin, target, words, new boolean[words.length], 0, words.length + 1, words.length);

        return answer == words.length + 1 ? 0 : answer;
    }

    public int dfs(String word, String target, String[] words, boolean[] visited, int n, int answer, int max) {
		for (int i = 0; i < max; i++) {
			if (!visited[i] && conversion(word, words[i])) {
				System.out.println(n + " " + answer + " " + word + " " + words[i]);

				if (words[i].equals(target)) {
					return Math.min(answer, n + 1);
				}

				visited[i] = true;
				int num = dfs(words[i], target, words, visited, n + 1, answer, max);
				if (num < answer) answer = num;
				visited[i] = true;
			}
		}

		return answer;
	}

	public boolean conversion(String w1, String w2) {
		int tmp = 0;
		for (int i = 0; i < w1.length(); i++) {
			if (w1.charAt(i) != w2.charAt(i)) {
				tmp++;
				if (tmp > 1) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String begin = "hit", target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		//String[] words = {"hot", "dot", "dog", "lot", "log"};

		Solution solution = new Solution();
		int answer = solution.solution(begin, target, words);
		System.out.println("answer : " + answer);


	}
}
