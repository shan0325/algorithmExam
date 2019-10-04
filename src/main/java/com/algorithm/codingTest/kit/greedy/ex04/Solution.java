package com.algorithm.codingTest.kit.greedy.ex04;

import java.util.stream.IntStream;

public class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		
		int[] sPeople = IntStream.of(people).sorted().toArray();
		
		for(int p : sPeople) {
			System.out.println(p);
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		Solution solution = new Solution();
		int answer = solution.solution(people, limit);
		System.out.println(answer);
	}
}
