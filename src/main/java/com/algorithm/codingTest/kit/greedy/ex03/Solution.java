package com.algorithm.codingTest.kit.greedy.ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public String solution(String number, int k) {
		int[] numbers = new int[number.length()];
		for(int i = 0; i < number.length(); i++) {
			numbers[i] = Integer.parseInt(number.charAt(i) + ""); 
		}
		
		List<Integer> permt = new ArrayList<>();
		
		doPermutation(numbers, number.length() -  k, 0, permt);
		System.out.println(permt);
		
		return String.valueOf(Collections.max(permt));
	}
	
	public void doPermutation(int[] array, int r, int target, List<Integer> permt) {
		if(target == r) {
			String num = "";
			for(int i = 0; i < r; i++) {
				num += array[i];
			}
			permt.add(Integer.parseInt(num));
			return;
		}
		
		for(int i = target; i < array.length; i++) {
			swap(array, i, target);
			doPermutation(array, r, target + 1, permt);
			swap(array, i, target);
		}
	}
	
	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public String solution2(String number, int k) {
		String answer = "";
		List<Integer> numberList = new ArrayList<>();
		for(int i = 0; i < number.length(); i++) {
			numberList.add(Integer.parseInt(number.charAt(i) + ""));
		}
		System.out.println(numberList);
		
		int index = 0;
		while(index < k) {
			int minIndex = 0;
			int min = numberList.get(0);
			for(int i = 1; i < numberList.size(); i++) {
				if(min > numberList.get(i)) {
					min = numberList.get(i);
					minIndex = i;
				}
			}
			numberList.remove(minIndex);
			index++;
		}
		System.out.println(numberList);
		
		for(Integer num : numberList) {
			answer += num;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		
		Solution solution = new Solution();
		String answer = solution.solution2(number, k);
		System.out.println("answer : " + answer);
	}
}
