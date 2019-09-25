package com.algorithm.codingTest.kit.greedy.ex02;

public class Solution {

	public int solution(String name) {
		int answer = 0;
		int ascStart = 65;
		boolean back = false;
		char[] names = name.toCharArray();
		
		for(int i = 0; i < names.length; i++) {
			int seq = names[i] - ascStart;
			
			if(seq == 0 && i - 1 == 0) {
				answer++;
				back = true;
			}

			if(i > 0 && !back) {
				answer++;
			}
			
			if(seq > 0) {
				if(seq <= 12) {
					answer += seq;
				} else {
					answer += 26 - seq;
				}
			}
			
			System.out.println(names[i] + " : " + seq + " / answer : " + answer);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String name = "JAN";
		
		Solution solution = new Solution();
		int answer = solution.solution(name);
		System.out.println(answer);
	}
}
