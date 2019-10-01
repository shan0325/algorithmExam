package com.algorithm.codingTest.kit.greedy.ex03;

public class Solution {
	
	public String solution(String number, int k) {
		int index = 0;
		while(k > 0) {
			if(Integer.parseInt(number.substring(index, index + 1)) < Integer.parseInt(number.substring(index + 1, index + 2))) {
				number = number.substring(0, index) + number.substring(index + 1);
				k--;
				index = 0;
				continue;
			}
			if(index == number.length() - 2) {
				number = number.substring(0, number.length() - k);
				break;
			}
			index++;
		}
		return number;
	}
	
	public String solution2(String number, int k) {
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < number.length() - 1; j++) {
				if(Integer.parseInt(number.substring(j, j + 1)) < Integer.parseInt(number.substring(j + 1, j + 2))) {
					number = number.substring(0, j) + number.substring(j + 1);
					break;
				}
				if(j == number.length() - 2) {
					number = number.substring(0, number.length() - k);
					break;
				}
			}
			System.out.println(number);
		}
		return number;
	}
	
	public String solution3(String number, int k) {
		
		int length = number.length();
		int startIndex = 0;
		while(length - k < number.length()) {
			String numStr = number.substring(startIndex, number.length() - k);
			
			
		}
		
		return number;
	}
	
	public static void main(String[] args) {
		String number = "4177252841"; // 775841
		int k = 4;
		
//		String number = "765432100";
//		int k = 5;
		
		Solution solution = new Solution();
		String answer = solution.solution2(number, k);
		System.out.println("answer : " + answer);
	}
}
