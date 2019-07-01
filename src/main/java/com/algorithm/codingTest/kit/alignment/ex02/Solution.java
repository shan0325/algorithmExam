package com.algorithm.codingTest.kit.alignment.ex02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	
	public String solution(int[] numbers) { 
		List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).sorted((a, b) -> (b+a).compareTo(a+b)).collect(Collectors.toList());
		return list.get(0).equals("0") ? "0" : list.toString().replaceAll("[^0-9]", "");
	}
	
	public String solution2(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			for(int j = i+1; j < numbers.length; j++) {
				int num = numbers[i];
				int num2 = numbers[j];
				String numStr = String.valueOf(num) + String.valueOf(num2);
				String numStr2 = String.valueOf(num2) + String.valueOf(num);
				System.out.println("numStr : " + numStr + " // numStr2 : " + numStr2);
				
				if(numStr.compareTo(numStr2) < 0) {
					numbers[i] = num2;
					numbers[j] = num;
				}
			}
		}
		
		List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
		return list.get(0).equals("0") ? "0" : list.toString().replaceAll("[^0-9]", "");
	}
	
	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2}; //6210
//		6102, 6210, 1062, 1026, 2610,2106
//		61023, 62310, 63102, 10236, 10362, 10623 
		
		
		int[] numbers = {3, 30, 34, 5, 9}; //9534330
//		int[] numbers = {12, 121}; //12121
//		int[] numbers = {0, 0, 0, 0}; //0
		
		Solution solution = new Solution();
		String answer = solution.solution2(numbers);
		System.out.println(answer);
	}
}
