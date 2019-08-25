package com.algorithm.codingTest.kit.completeSearch.ex02;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

입출력 예
numbers		return
17			3
011			2

입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.
 * 
 *
 */
public class Solution {

	public int solution(String numbers) {
		int answer = 0;
		
		int[] numArr = new int[numbers.length()];
		for(int i = 0; i < numbers.length(); i++) {
			numArr[i] = Integer.parseInt(numbers.charAt(i) + "");
		}
		
		Set<Integer> numList = new HashSet<Integer>();
		for(int i = 1; i <= numArr.length; i++) {
			doPermutation(numArr, numArr.length, i, 0, numList);
		}
		
		for(Integer num : numList) {
			if(isPrime(num)) {
				answer++;
			}
		}
		
		return answer;
	}
	
	public void doPermutation(int[] arr, int n, int r, int startIdx, Set<Integer> numList) {
		if(startIdx == r) {
			String temp = "";
			for(int i = 0; i < r; i++) {
				temp += arr[i];
			}
			numList.add(Integer.parseInt(temp));
			return;
		}
		
		for(int i = startIdx; i < n; i++) {
			swap(arr, startIdx, i);
			doPermutation(arr, n, r, startIdx + 1, numList);
			swap(arr, startIdx, i);
		}
	}
	
	public void swap(int[] arr, int n1, int n2) {
		int temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
	}
	
	public boolean isPrime(int number) {
		boolean isPrime = true;
		
		if(number <= 1) isPrime = false;
		
		for(int i = 2; i <= (number / 2); i++) {
			if(number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	public static void main(String[] args) {
		String numbers = "17";
		
		Solution solution = new Solution();
		int answer = solution.solution(numbers);
		System.out.println(answer);
	}
}
