package com.algorithm.codingTest.kit.completeSearch.ex02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {

	public int solution(String numbers) {
		int answer = 0;
		
//		String[] numArr = new String[numbers.length()];
		int[] numArr = new int[numbers.length()];
		for(int i = 0; i < numbers.length(); i++) {
//			numArr[i] = numbers.charAt(i) + "";
			numArr[i] = Integer.parseInt(numbers.charAt(i) + "");
		}
		
		Stream.of(numArr).forEach(num -> System.out.print(num + " "));
		System.out.println();
		
//		Set<Integer> numList = doPermutation(numArr, numArr.length, 1, 0, new HashSet<Integer>());
		
//		System.out.println(numList);
		
		doPermutation(numArr, numArr.length, 1, 0);
		
		return answer;
	}
	
	public void doPermutation(int[] arr, int n, int r, int startIdx) {
		if(startIdx == n - 1) {
			for(int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = startIdx; i < n; i++) {
			swap(arr, startIdx, i);
			doPermutation(arr, n, r, startIdx + 1);
			swap(arr, startIdx, i);
		}
	}
	
	public void swap(int[] arr, int n1, int n2) {
		int temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
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
		String numbers = "1234";
		
		Solution solution = new Solution();
		int answer = solution.solution(numbers);
		System.out.println(answer);
	}
}
