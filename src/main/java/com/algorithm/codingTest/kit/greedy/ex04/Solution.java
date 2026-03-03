package com.algorithm.codingTest.kit.greedy.ex04;

import java.util.Arrays;

public class Solution {
	
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		
		int j = 0;
		for(int i = people.length - 1; i >= 0; i--) {
			if(people[i] == -1) break;
			
			if(j == i || people[i] + people[j] > limit) {
				people[i] = -1;
				answer++;
			} else {
				people[i] = -1;
				people[j] = -1;
				answer++;
				j++;
			}
		}
		return answer;
	}
	
	public int solution2(int[] people, int limit) {
		Arrays.sort(people);
		
		int j = 0;
		for(int i = people.length - 1; i > j; i--) {
			if(people[i] + people[j] <= limit) {
				j++;
			}
		}
		return people.length - j;
	}
	
	public static void main(String[] args) {
//		int[] people = {70, 50, 80, 50};
		int[] people = {70, 70, 50, 30, 20};
		int limit = 100;
		
		Solution solution = new Solution();
		int answer = solution.solution2(people, limit);
		System.out.println(answer);
	}
}
