package com.algorithm.codingTest.kit.completeSearch.ex03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public int solution(int[][] baseball) {
		int answer = 0;
		
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		Set<String> possibleNumbers = new HashSet<String>();
		doPermutation(numbers, 9, 3, 0, possibleNumbers);
		System.out.println(possibleNumbers);
		
		Set<String> list = new HashSet<String>();
		for(int i = 0; i < baseball.length; i++) {
			String userNum = String.valueOf(baseball[i][0]);
			String firstNum = userNum.substring(0, 1);
			String secondNum = userNum.substring(1, 2);
			String third = userNum.substring(2);
			
			int strike = baseball[i][1];
			int ball = baseball[i][2];
			System.out.println("userNum : " + userNum + " / strike : " + strike + " / ball : " + ball);
		
			for(String possibleNum : possibleNumbers) {
				String firstNum2 = possibleNum.substring(0, 1);
				String secondNum2 = possibleNum.substring(1, 2);
				String third2 = possibleNum.substring(2);
				
				if(strike == 1) {
					if(firstNum.equals(firstNum2)) {
						list.add(possibleNum);
					}
					if(secondNum.equals(secondNum2)) {
						list.add(possibleNum);
					}
					if(third.equals(third2)) {
						list.add(possibleNum);
					}
				} else if(strike == 2) {
					if((firstNum + secondNum).equals(firstNum2 + secondNum2)) {
						list.add(possibleNum);
					}
					if((secondNum + third).equals(secondNum2 + third2)) {
						list.add(possibleNum);
					}
					if((firstNum + third).equals(firstNum2 + third2)) {
						list.add(possibleNum);
					}
				}
				
				if(ball == 1) {
					if(possibleNum.contains(firstNum)) {
						list.add(possibleNum);
					}
					if(possibleNum.contains(secondNum)) {
						list.add(possibleNum);
					}
					if(possibleNum.contains(third)) {
						list.add(possibleNum);
					}
				} else if(ball == 2) {
					if((secondNum + firstNum).equals(secondNum2 + firstNum2)) {
						list.add(possibleNum);
					}
					if((third + secondNum).equals(third2 + secondNum2)) {
						list.add(possibleNum);
					}
					if((third + firstNum).equals(third2 + firstNum2)) {
						list.add(possibleNum);
					}
				} else if(ball == 3) {
					if((third + firstNum + secondNum).equals(third2 + firstNum2 + secondNum2)){
						list.add(possibleNum);
					}
					if((secondNum + third + firstNum).equals(secondNum2 + third2 + firstNum2)) {
						list.add(possibleNum);
					}
				}
			}
			System.out.println("list : " + list);
		}
		
		return answer;
	}
	
	public void doPermutation(int[] numbers, int n, int r, int target, Set<String> possibleNumbers) {
		if(target == r) {
			String temp = "";
			for(int i = 0; i < r; i++) {
				temp += numbers[i];
			}
			possibleNumbers.add(temp);
			return;
		}
		
		for(int i = target; i < numbers.length; i++) {
			swap(numbers, target, i);
			doPermutation(numbers, n, r, target + 1, possibleNumbers);
			swap(numbers, target, i);
		}
	}
	
	public void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1},{356, 1, 0},{327, 2, 0},{489, 0, 1}};
		
		Solution solution = new Solution();
		int answer = solution.solution(baseball);
		System.out.println(answer);
	}
}


//127
//이때 가능한 답은 324와 328 두 가지입니다.