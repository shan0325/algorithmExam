package com.algorithm.codingTest.kit.alignment.ex02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public String solution(int[] numbers) { 
//		String answer = Arrays.toString(numbers).replaceAll("[^0-9]", "");
//		System.out.println("answer : " + answer);
//		numbers = Stream.of(answer.split("")).sorted((a, b) -> b.compareTo(a)).mapToInt(Integer::parseInt).toArray();
//		return Arrays.toString(numbers).replaceAll("[^0-9]", "");
		
		String answer = "";
		
		Queue<String> queue = new LinkedList<String>();
		for (int number : numbers) {
			queue.add(String.valueOf(number));
		}
		System.out.println(queue);
		
		int size = numbers.length;
		int index = 0;
		int index2 = 0;
		while(true) {
			String numStr = queue.poll();
			System.out.println("numStr : " + numStr);
			
			while(true) {
				String numStr2 = queue.poll();
				
				
				
				break;
			}
			
			break;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2}; //6210
//		6102, 6210, 1062, 1026, 2610,2106
//		61023, 62310, 63102, 10236, 10362, 10623 
		
		
//		int[] numbers = {3, 30, 34, 5, 9}; //9534330
		
		Solution solution = new Solution();
		String answer = solution.solution(numbers);
		System.out.println(answer);
	}
}
