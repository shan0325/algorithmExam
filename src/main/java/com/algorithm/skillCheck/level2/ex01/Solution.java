package com.algorithm.skillCheck.level2.ex01;

public class Solution {
	
	int solution(int[][] land) {
		int answer = 0;
		
		int index = -1;
		for(int i = 0; i < land.length; i++) {
			int max = 0;
			int maxIndex = -1;
			for(int k = 0; k < land[i].length; k++) {
				if(max < land[i][k]) {
					max = land[i][k];
					maxIndex = k;
				}
			}
			
			
			
			index = maxIndex;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		//int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		int[][] land = {{1,2,3,5},{5,6,7,15},{4,3,2,2}};
		
		Solution solution = new Solution();
		int answer = solution.solution(land);
		System.out.println(answer);
		
	}
}
