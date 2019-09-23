package com.algorithm.codingTest.kit.greedy.ex01;

public class Solution {
	
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					answer++;
					lost[i] = -9;
					reserve[j] = -9;
					break;
				}
			}
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
					answer++;
					lost[i] = -9;
					reserve[j] = -9;
					break;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 7;
		int[] lost = {2,3,4};
		int[] reserve = {1,2,3,6};
		
		Solution solution = new Solution();
		int answer = solution.solution(n, lost, reserve);
		System.out.println(answer);
		
	}
}
