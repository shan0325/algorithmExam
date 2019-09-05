package com.algorithm.codingTest.kit.completeSearch.ex03;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int solution(int[][] baseball) {
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		Set<String> possibleNumbers = new HashSet<String>();
		doPermutation(numbers, 9, 3, 0, possibleNumbers);
		System.out.println(possibleNumbers);
		
		for(int i = 0; i < baseball.length; i++) {
			String userNum = String.valueOf(baseball[i][0]);
			String firstNum = userNum.substring(0, 1);
			String secondNum = userNum.substring(1, 2);
			String third = userNum.substring(2);
			
			int strike = baseball[i][1];
			int ball = baseball[i][2];
			System.out.println("userNum : " + userNum + " / strike : " + strike + " / ball : " + ball);

			Set<String> set = new HashSet<String>();
			for(String possibleNum : possibleNumbers) {
				String firstNum2 = possibleNum.substring(0, 1);
				String secondNum2 = possibleNum.substring(1, 2);
				String third2 = possibleNum.substring(2);
				
				if(!userNum.equals(possibleNum)) {
					if(strike == 0) {
						if(ball == 0) {
							if(possibleNum.contains(firstNum) || possibleNum.contains(secondNum) || possibleNum.contains(third)) {
								possibleNumbers.remove(possibleNum);
							}
						}
						else if(ball == 1) {
							if(!firstNum.equals(firstNum2) && possibleNum.contains(firstNum)) {
								set.add(possibleNum);
							}
							if(!secondNum.equals(secondNum2) && possibleNum.contains(secondNum)) {
								set.add(possibleNum);
							}
							if(!third.equals(third2) && possibleNum.contains(third)) {
								set.add(possibleNum);
							}
						}
						else if(ball == 2) {
							if((secondNum + firstNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							if((third + secondNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							if((third + secondNum).equals(secondNum2 + third2)) {
								set.add(possibleNum);
							}
							if((third + firstNum).equals(secondNum2 + third2)) {
								set.add(possibleNum);
							}
							if((third + firstNum).equals(firstNum2 + third2)) {
								set.add(possibleNum);
							}
						}
						else if(ball == 3) {
							if((secondNum + third + firstNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
							if((third + firstNum + secondNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
						}
					}
					else if(strike == 1) {
						if(ball == 0) {
							if(firstNum.equals(firstNum2) && !possibleNum.contains(secondNum) && !possibleNum.contains(third)) {
								set.add(possibleNum);
							}
							if(secondNum.equals(secondNum2) && !possibleNum.contains(firstNum) && !possibleNum.contains(third)) {
								set.add(possibleNum);
							}
							if(third.equals(third2) && !possibleNum.contains(firstNum) && !possibleNum.contains(secondNum)) {
								set.add(possibleNum);
							}
						}
						else if(ball == 1) {
							if((firstNum + third).equals(firstNum2 + secondNum2) && !possibleNum.contains(secondNum)) {
								set.add(possibleNum);
							}
							if((secondNum + firstNum).equals(secondNum2 + third2)) {
								set.add(possibleNum);
							}
							if((third + secondNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							if((firstNum + third).equals(secondNum2 + third2)) {
								set.add(possibleNum);
							}
							if((secondNum + third).equals(firstNum2 + third2)) {
								set.add(possibleNum);
							}
							
						} 
						else if(ball == 2) {
							if((firstNum + third + secondNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
							if((third + secondNum + firstNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
							if((secondNum + firstNum + third).equals(possibleNum)) {
								set.add(possibleNum);
							}
						}
					} 
					else if(strike == 2) {
						if(ball == 0) {
							if((firstNum + secondNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							if((secondNum + third).equals(secondNum2 + third2)) {
								set.add(possibleNum);
							}
							if((firstNum + third).equals(firstNum2 + third2)) {
								set.add(possibleNum);
							}
						}
					}
				}
			}
			System.out.println("set : " + set);
			
			possibleNumbers.clear();
			for(String num : set) {
				possibleNumbers.add(num);
			}
		}
		
		System.out.println("possibleNumbers : " + possibleNumbers);
		return possibleNumbers.size();
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