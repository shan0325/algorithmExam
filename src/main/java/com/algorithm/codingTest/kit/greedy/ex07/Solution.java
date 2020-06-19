package com.algorithm.codingTest.kit.greedy.ex07;

import java.util.Arrays;

public class Solution {
	
	public int solution(int[] weight) {
        Arrays.sort(weight);
        int answer = weight[0] + 1;
        for (int i = 1; i < weight.length; i++) {
			if(answer >= weight[i]) {
				answer += weight[i];
				continue;
			}
			break;
		}
        return answer;
    }

	public static void main(String[] args) {
		int[] weight = {3, 1, 6, 2, 7, 30, 1}; // 21
//		int[] weight = {1,2,3,4}; //
		
		Solution solution = new Solution();
		int answer = solution.solution(weight);
		System.out.println("=========================");
		System.out.println(answer);
		
	}
}
