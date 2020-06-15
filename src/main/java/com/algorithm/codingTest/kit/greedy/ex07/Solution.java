package com.algorithm.codingTest.kit.greedy.ex07;

import java.util.Arrays;

public class Solution {
	
	public int solution(int[] weight) {
        int answer = 1;
        int sum = Arrays.stream(weight).sum();
        
        for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < weight.length; j++) {
				if(weight[i] > weight[j]) {
					int temp = weight[i];
					weight[i] = weight[j];
					weight[j] = temp;
				}
			}
		}
        
        for (int i = 0; i < weight.length; i++) {
			System.out.print(weight[i] + ",");
		}
        System.out.println();
        
        while(answer <= sum) {
        	boolean isFound = false;
        	
        	int temp = answer;
        	for (int i = 0; i < weight.length; i++) {
        		if(temp - weight[i] >= 0) {
        			temp -= weight[i];
        			if(temp == 0) {
        				isFound = true;
        				break;
        			}
        		}
			}
        	
        	if(!isFound) {
        		break;
        	} else {
        		answer++;
        	}
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
