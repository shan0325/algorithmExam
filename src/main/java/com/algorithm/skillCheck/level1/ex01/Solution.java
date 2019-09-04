package com.algorithm.skillCheck.level1.ex01;

public class Solution {
	public String solution(String phone_number) {
		String answer = "";
		
		char[] phoneNumberArray = phone_number.toCharArray();
		for(int i = 0; i < phoneNumberArray.length - 4; i++) {
			phoneNumberArray[i] = '*';
		}
		answer = String.valueOf(phoneNumberArray);
		
		return answer;
	}
	
	public static void main(String[] args) {
		String phone_number = "027778888";
		
		Solution solution = new Solution();
		String answer = solution.solution(phone_number);
		System.out.println("answer : " + answer);
	}

}
