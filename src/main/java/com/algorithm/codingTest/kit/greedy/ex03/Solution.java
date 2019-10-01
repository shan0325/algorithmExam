package com.algorithm.codingTest.kit.greedy.ex03;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public String solution(String number, int k) {
		String answer = "";
		List<Integer> numberList = new ArrayList<>();
		for(int i = 0; i < number.length(); i++) {
			numberList.add(Integer.parseInt(number.charAt(i) + ""));
		}
		System.out.println(numberList);
	
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < numberList.size() - 1; j++) {
				if(numberList.get(j) < numberList.get(j + 1)) {
					numberList.remove(j);
					break;
				}
			}
		}
		System.out.println(numberList);
		
		for(Integer num : numberList) {
			answer += num;
		}
		
		return answer;
	}
	
	public String solution2(String number, int k) {
		String answer = "";
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < number.length() - 1; j++) {
				System.out.println(number.substring(j, j + 1) + " < " + number.substring(j + 1, j + 2));
				if(Integer.parseInt(number.substring(j, j + 1)) < Integer.parseInt(number.substring(j + 1, j + 2))) {
					number = number.substring(j, j + 1) + number.substring(j + 1);
					break;
				}
			}
			System.out.println(number);
		}
		System.out.println(number);
		
		return answer;
	}
	
	public static void main(String[] args) {
		String number = "4177252841"; // 775841
		int k = 4;
		
//		String number = "1010"; // 775841
//		int k = 2;
		
		Solution solution = new Solution();
		String answer = solution.solution2(number, k);
		System.out.println("answer : " + answer);
	}
}
