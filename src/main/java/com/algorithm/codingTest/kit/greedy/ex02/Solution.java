package com.algorithm.codingTest.kit.greedy.ex02;

public class Solution {

	public int solution(String name) {
		int answer = 0;
		int loc = 0;
		char[] names = name.toCharArray();
		
		int index = 0;
		while(true) {
			int endCnt = 0;
			for(int i = 0; i < names.length; i++) {
				if(names[i] == '-') {
					endCnt++;
				}
			}
			if(endCnt == names.length) break;

			int front = 0;
			int back = index;
			for(int i = index; i < names.length; i++) {
				int engIndex2 = names[i] - 65;
				if(engIndex2 == 0) {
					front++;
				} else {
					break;
				}
			}
			for(int i = names.length - 1; i >= index; i--) {
				int engIndex2 = names[i] - 65;
				if(engIndex2 == 0) {
					back++;
				} else {
					break;
				}
			}
			System.out.println("front : " + front + " / back : " + back);
			
			if(front == back) {
				answer++;
				names[index++] = '-';
			} else if(front < back) {
				answer += front;
				for(int i = index; i < names.length; i++) {
					int engIndex2 = names[i] - 65;
					if(engIndex2 == 0) {
						names[i++] = '-';
					} else {
						break;
					}
				}
			} else {
				answer += back;
				for(int i = names.length - 1; i >= index; i--) {
					int engIndex2 = names[i] - 65;
					if(engIndex2 == 0) {
						names[i--] = '-';
					} else {
						break;
					}
				}
			}
			
			int engIndex = names[index] - 65;
			
			if(engIndex <= 12) {
				answer += engIndex;
			} else {
				answer += 26 - engIndex;
			}
			System.out.println(names[index] + " : " + engIndex + " / answer : " + answer);
			
			
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String name = "ABAAAAAAABA"; // 6
		
		Solution solution = new Solution();
		int answer = solution.solution(name);
		System.out.println(answer);
	}
}
