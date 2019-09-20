package com.algorithm.codingTest.kit.completeSearch.ex04;

import java.util.ArrayList;
import java.util.List;

/**
 * 카펫
 * 
문제 설명
Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 빨간색으로 칠해져 있고 모서리는 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.

image.png

Leo는 집으로 돌아와서 아까 본 카펫의 빨간색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 빨간색 격자의 수 red가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
빨간색 격자의 수 red는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

입출력 예
brown	red		return
10		2		[4, 3]
8		1		[3, 3]
24		24		[8, 6]
 * 
 * 
 * @author dev1
 *
 */
public class Solution {

	public int[] solution1(int brown, int red) {
		int[] answer = new int[2];
		int totalGrid = brown + red;
		
		for(int i = 1; i <= totalGrid; i++) {
			if(multiplication(i, 1, brown, red, answer)) {
				break;
			}
		}
		return answer;
	}
	
	public boolean multiplication(int num1, int num2, int brown, int red, int[] answer) {
		if(num1 < num2) return false;
		if(num1 * num2 == brown + red) {
			if((num1 * 2) + ((num2 - 2) * 2) == brown) {
				answer[0] = num1;
				answer[1] = num2;
				return true;
			}
		}
		return multiplication(num1, num2 + 1, brown, red, answer);
	}
	
	public int[] solution2(int brown, int red) {
		for(int i = 2; i < brown; i++) {
			if((brown + red) % i == 0) {
				int height = (brown + red) / i;
				if(i >= height && (i * 2) + ((height - 2) * 2) == brown) {
					return new int[] {i, height};
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		int brown = 24;
		int red = 24;
		
		Solution solution = new Solution();
		int[] answer = solution.solution2(brown, red);
		
		System.out.println(answer[0] + " " + answer[1]);
	}
}
