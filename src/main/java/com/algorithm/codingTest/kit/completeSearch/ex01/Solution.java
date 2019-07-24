package com.algorithm.codingTest.kit.completeSearch.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

	public int[] solution(int[] answers) {
		int[] user1 = {1,2,3,4,5};
		int[] user2 = {2,1,2,3,2,4,2,5};
		int[] user3 = {3,3,1,1,2,2,4,4,5,5};
		int[] userCnt = new int[3];

		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == user1[i % 5]) {
				userCnt[0]++; 
			}
			if(answers[i] == user2[i % 8]) {
				userCnt[1]++;
			}
			if(answers[i] == user3[i % 10]) {
				userCnt[2]++;
			}
		}
		
		IntStream.of(userCnt).forEach(cnt -> System.out.print(cnt +" "));
		System.out.println();
		
		int maxCnt = IntStream.of(userCnt).max().orElse(0);
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < userCnt.length; i++) {
			if(maxCnt == userCnt[i]) {
				list.add(i+1);
			}
		}
		
		int[] answer = list.stream().mapToInt(i -> i).toArray();
		Arrays.sort(answer);
		return answer;
	}
	
	public static void main(String[] args) {
//		int[] answers = {1,2,3,4,5};
//		int[] answers = {1,3,2,4,2};
		int[] answers = {9,9,9,9,9,9,9,3};
		
		Solution solution = new Solution();
		int[] answer = solution.solution(answers);
		
		IntStream.of(answer).forEach((a) -> System.out.print(a + " "));
	}
	
}
