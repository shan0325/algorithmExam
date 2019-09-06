package com.algorithm.codingTest.kit.completeSearch.ex03;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author dev1
 * 
 * 문제 설명
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기

각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃
예를 들어, 아래의 경우가 있으면

A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항
질문의 수는 1 이상 100 이하의 자연수입니다.
baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.

입출력 예
baseball													return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]		2

입출력 예 설명
문제에 나온 예와 같습니다.


 *
 */
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
			String thirdNum = userNum.substring(2);
			
			int strike = baseball[i][1];
			int ball = baseball[i][2];
			System.out.println("userNum : " + userNum + " / strike : " + strike + " / ball : " + ball);

			Set<String> set = new HashSet<String>();
			for(String possibleNum : possibleNumbers) {
				String firstNum2 = possibleNum.substring(0, 1);
				String secondNum2 = possibleNum.substring(1, 2);
				String thirdNum2 = possibleNum.substring(2);
				
				if(!userNum.equals(possibleNum)) {
					if(strike == 0) {
						if(ball == 0) {
							if(possibleNum.contains(firstNum) || possibleNum.contains(secondNum) || possibleNum.contains(thirdNum)) {
								set.add(possibleNum);
							}
						}
						else if(ball == 1) {
							if(!possibleNum.contains(secondNum) && !possibleNum.contains(thirdNum) && (firstNum.equals(secondNum2) || firstNum.equals(thirdNum2))) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && !possibleNum.contains(thirdNum) && (secondNum.equals(firstNum2) || secondNum.equals(thirdNum2))) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && !possibleNum.contains(secondNum) && (thirdNum.equals(firstNum2) || thirdNum.equals(secondNum2))) {
								set.add(possibleNum);
							}
						}
						else if(ball == 2) {
							if(!possibleNum.contains(thirdNum) && (firstNum + secondNum).equals(secondNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(thirdNum) && (secondNum + firstNum).equals(firstNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(thirdNum) && (secondNum + firstNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && (thirdNum + secondNum).equals(secondNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && (thirdNum + secondNum).equals(firstNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && (secondNum + thirdNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(secondNum) && (thirdNum + firstNum).equals(firstNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(secondNum) && (thirdNum + firstNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(secondNum) && (thirdNum + firstNum).equals(secondNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
						}
						else if(ball == 3) {
							if((secondNum + thirdNum + firstNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
							else if((thirdNum + firstNum + secondNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
						}
					}
					else if(strike == 1) {
						if(ball == 0) {
							if(!possibleNum.contains(secondNum) && !possibleNum.contains(thirdNum) && firstNum.equals(firstNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && !possibleNum.contains(thirdNum) && secondNum.equals(secondNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && !possibleNum.contains(secondNum) && thirdNum.equals(thirdNum2)) {
								set.add(possibleNum);
							}
						}
						else if(ball == 1) {
							if(!possibleNum.contains(secondNum) && (firstNum + thirdNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(thirdNum) && (firstNum + secondNum).equals(firstNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && (thirdNum + secondNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(thirdNum) && (secondNum + firstNum).equals(secondNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(firstNum) && (secondNum + thirdNum).equals(firstNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if(!possibleNum.contains(secondNum) && (firstNum + thirdNum).equals(secondNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
						} 
						else if(ball == 2) {
							if((firstNum + thirdNum + secondNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
							else if((thirdNum + secondNum + firstNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
							else if((secondNum + firstNum + thirdNum).equals(possibleNum)) {
								set.add(possibleNum);
							}
						}
					} 
					else if(strike == 2) {
						if(ball == 0) {
							if((firstNum + secondNum).equals(firstNum2 + secondNum2)) {
								set.add(possibleNum);
							}
							else if((secondNum + thirdNum).equals(secondNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
							else if((firstNum + thirdNum).equals(firstNum2 + thirdNum2)) {
								set.add(possibleNum);
							}
						}
					}
				}
			}
			System.out.println("set : " + set);
			
			if(strike == 0 && ball == 0) {
				for(String num : set) {
					possibleNumbers.remove(num);
				}
			} else {
				possibleNumbers.clear();
				for(String num : set) {
					possibleNumbers.add(num);
				}
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
	
	public int solution2(int[][] baseball) {
		Stack<String> stack = new Stack<>();
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				for(int k = 1; k < 10; k++) {
					if(i != j && j != k && i != k) {
						stack.add(String.valueOf(i * 100 + j * 10 + k));
					}
				}
			}
		}
		
		Stack<String> temp = new Stack<>();
		boolean flag = true;
		while(!stack.isEmpty()) {
			String num = stack.pop();
			for(int i = 0; i < baseball.length; i++) {
				int strike = strike(num, String.valueOf(baseball[i][0]));
				int ball = ball(num, String.valueOf(baseball[i][0])) - strike;
				System.out.println("num : " + num + " / baseball : " + baseball[i][0] + " / strike : " + strike + " / ball : " + ball);
				
				if(strike != baseball[i][1] || ball != baseball[i][2]) {
					flag = false;
				}
			}
			if(flag) {
				temp.add(num);
			}
			flag = true;
			System.out.println("----------------------------------------------------------");
		}
		System.out.println("temp : " + temp);
		return temp.size();
	}
	
	public int strike(String num, String target) {
		int cnt = 0;
		for(int i = 0; i < target.length(); i++) {
			cnt = num.charAt(i) == target.charAt(i) ? cnt + 1 : cnt;
		}
		return cnt;
	}
	
	public int ball(String num, String target) {
		int cnt = 0;
		for(int i = 0; i < target.length(); i++) {
			cnt = num.contains(String.valueOf(target.charAt(i))) ? cnt + 1 : cnt;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1},{356, 1, 0},{327, 2, 0},{489, 0, 1}};
		
		Solution solution = new Solution();
		int answer = solution.solution2(baseball);
		System.out.println(answer);
	}
}
