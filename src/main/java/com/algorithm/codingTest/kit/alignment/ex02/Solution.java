package com.algorithm.codingTest.kit.alignment.ex02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

	public String solution(int[] numbers) { 
//		String answer = Arrays.toString(numbers).replaceAll("[^0-9]", "");
//		System.out.println("answer : " + answer);
//		numbers = Stream.of(answer.split("")).sorted((a, b) -> b.compareTo(a)).mapToInt(Integer::parseInt).toArray();
//		return Arrays.toString(numbers).replaceAll("[^0-9]", "");
		
		String answer = "";
		
		String[] temp = IntStream.of(numbers)
								.mapToObj(String::valueOf)
								.sorted((a, b) -> {
									
									
									return 0;
								})
								.toArray(String[]::new);
		System.out.println(Arrays.asList(temp).toString());
		return answer;
	}
	
	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2}; //6210
		int[] numbers = {3, 30, 34, 5, 9}; //9534330
		
		Solution solution = new Solution();
		String answer = solution.solution(numbers);
		System.out.println(answer);
	}
}
