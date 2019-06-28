package com.algorithm.codingTest.kit.alignment.ex02;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public String solution(int[] numbers) { 
//		String answer = Arrays.toString(numbers).replaceAll("[^0-9]", "");
//		System.out.println("answer : " + answer);
//		numbers = Stream.of(answer.split("")).sorted((a, b) -> b.compareTo(a)).mapToInt(Integer::parseInt).toArray();
//		return Arrays.toString(numbers).replaceAll("[^0-9]", "");
		
		String answer = "";
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < numbers.length; i++) {
			String number = String.valueOf(numbers[i]);
			for(int j = 0; j < numbers.length; j++) {
				if(i != j) {
					
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2}; //6210
//		6102, 6210, 1062, 1026, 2610,2106
//		int[] numbers = {3, 30, 34, 5, 9}; //9534330
		
		Solution solution = new Solution();
		String answer = solution.solution(numbers);
		System.out.println(answer);
	}
}
