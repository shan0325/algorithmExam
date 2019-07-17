package com.algorithm.codingTest.kit.completeSearch.ex01;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Solution {

	public int[] solution(int[] answers) {
		int[] answer = {};
		
		int[] answer1 = {1,2,3,4,5};
		int[] answer2 = {2,1,2,3,2,4,2,5};
		int[] answer3 = {3,3,1,1,2,2,4,4,5,5};
		
		int[] a = new int[answers.length];
		int[] b = new int[answers.length];
		int[] c = new int[answers.length];
		
		int aCnt = 0;
		int bCnt = 0;
		int cCnt = 0;
		
		for(int i = 0; i < answers.length; i++) {
			if(i < 5) {
				a[i] = answer1[i];
			} else {
				a[i] = answer1[i / 5];
			}
			
			if(i < 8) {
				b[i] = answer2[i];
			} else {
				b[i] = answer2[i / 8];
			}
			
			if(i < 10) {
				c[i] = answer3[i];
			} else {
				c[i] = answer3[i / 10];
			}
		}
		
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == a[i]) aCnt++;
			if(answers[i] == b[i]) bCnt++;
			if(answers[i] == c[i]) cCnt++;
		}
		
//		if(aCnt == bCnt && aCnt == cCnt && bCnt == cCnt) {
//			int[] answer = {1,2,3};
//			return answer;
//		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		
		Solution solution = new Solution();
		int[] answer = solution.solution(answers);
		
		IntStream.of(answer).forEach((a) -> System.out.print(a + " "));
	}
}
