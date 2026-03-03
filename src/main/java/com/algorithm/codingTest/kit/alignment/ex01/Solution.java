package com.algorithm.codingTest.kit.alignment.ex01;

import java.util.Arrays;

public class Solution {
	
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for(int i = 0; i < commands.length; i++) {
			int start = commands[i][0] - 1;
			int end = commands[i][1] - 1;
			int loc = commands[i][2] - 1;
			int[] list = new int[end - start + 1];
			int index = 0;
			
			for(int j = 0; j < array.length; j++) {
				if(j >= start && j <= end) {
					list[index] = array[j];
					index++;
				}
			}
			Arrays.sort(list);
			answer[i] = list[loc];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		// answer : [5,6,3]
		
		Solution solution = new Solution();
		int[] answer = solution.solution(array, commands);
		for (int i : answer) {
			System.out.println(i);
		}
	}

}
