package com.algorithm.codingTest.kit.dfsbfs.ex03;

import java.util.Stack;

public class Solution {
	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean isExist = false;
        for (int i = 0; i < words.length; i++) {
			if(words[i].equals(target)) {
				isExist = true;
				break;
			}
		}
        if(!isExist) 
        	return answer;
        
        Stack<String> stack = new Stack<>();
        stack.push(begin);
        
        for (int i = 0; i < words.length; i++) {
			if(stack.contains(target)) 
				break;
        	
        	find(i, 0, stack, target, words);
        	answer++;
		}
        System.out.println("stack : " + stack);
        
        return answer + 1;
    }
	
	public void find(int index, int node, Stack<String> stack, String target, String[] words) {
		
		String word = words[index];
		if(node >= word.length()) {
			return;
		}
		
		String compWord = word.substring(0, node) + word.substring(node + 1);
		System.out.println("word : " + word + " // compWord : " + compWord);
		
		for (int i = 0; i < target.length(); i++) {
			String compWord2 = target.substring(0, i) + target.substring(i + 1);
			System.out.println("target : " + target + " // compWord2 : " + compWord2);
			
			if(compWord.equals(compWord2)) {
				stack.push(target);
				return;
			}
		}
		
		String word2 = stack.peek();
		for (int i = 0; i < word2.length(); i++) {
			String compWord2 = word2.substring(0, i) + word2.substring(i + 1);
			System.out.println("target : " + word2 + " // compWord2 : " + compWord2);
			
			if(compWord.equals(compWord2)) {
				stack.push(word);
				return;
			}
		}
		
		find(index, node + 1, stack, target, words);
	}

	public static void main(String[] args) {
		String begin = "hit", target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		Solution solution = new Solution();
		int answer = solution.solution(begin, target, words);
		System.out.println("answer : " + answer);


	}
}
