package com.algorithm.codingTest.kit.alignment.ex03;

import java.util.Arrays;

public class Solution {
	
	public int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		int maxNum = citations[citations.length-1];
		for(int i = 0; i < maxNum; i++) {
			int upCnt = 0;
			for(int j = 0; j < citations.length; j++) {
				if(i <= citations[j]) {
					upCnt++;
				}
			}
			System.out.println("i : " + i + " // upCnt : " + upCnt);
			
			if(i <= upCnt) {
				answer = i;
			} else {
				break;
			}
		}
		
		return answer;
	}
	
	public int solution2(int[] citations) {
        Arrays.sort(citations);

        int result = 0;
        for(int i = 0; i < citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            result = Math.max(result, smaller);
        }
        return result;
    }
	
	public int solution3(int[] citations) {
		int answer = 0;
        Arrays.sort(citations);

        for (int i = citations.length-1; i >= 0; i--) {
            if(citations.length - i > citations[i]) {
            	break;
            }
            answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
//		int[] citations = {3,0,6,1,5};
//		int[] citations = {1, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7, 8, 8, 9, 9, 10, 10, 10};
//		int[] citations = {2,7,5};
//		int[] citations = {0,0,0,0};
		int[] citations = {22,42};
		
		Solution solution = new Solution();
		int answer = solution.solution3(citations);
		System.out.println("asnwer : " + answer);
	}
}
