package com.algorithm.codingTest.kit.completeSearch.ex02;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int solution(String numbers) {
		int answer = 0;
		
		String[] numArr = new String[numbers.length()];
		for(int i = 0; i < numbers.length(); i++) {
			numArr[i] = numbers.charAt(i) + "";
		}
		
		//Stream.of(numArr).forEach(num -> System.out.print(num + " "));
		//System.out.println();
		
		Set<Integer> numList = new HashSet<Integer>();
		for(int i = 0; i < numArr.length; i++) {
			numList.add(Integer.parseInt(numArr[i]));
			for(int j = 0; j < numArr.length; j++) {
				if(i != j) {
					numList.add(Integer.parseInt(numArr[i] + numArr[j]));
				}
			}
		}
		
		System.out.println(numList);
		
		return answer;
	}
	
	public boolean isMinority(int number) {
		boolean isMinority = true;
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				isMinority = false;
				break;
			}
		}
		return isMinority;
	}
	
	public static void main(String[] args) {
		String numbers = "123";
		
		Solution solution = new Solution();
		int answer = solution.solution(numbers);
		System.out.println(answer);
	}
}
