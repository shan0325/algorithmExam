package com.algorithm.codingTest.kit.greedy.ex03;

/**
 * 문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.

입출력 예
number			k		return
1924			2		94
1231234			3		3234
4177252841		4		775841

 * @author ykc
 *
 */
public class Solution {
	
	// 10번에서 속도 초과
	public String solution(String number, int k) {
		int index = 0;
		while(k > 0) {
			if(Integer.parseInt(number.substring(index, index + 1)) < Integer.parseInt(number.substring(index + 1, index + 2))) {
				number = number.substring(0, index) + number.substring(index + 1);
				k--;
				index = 0;
				continue;
			}
			if(index == number.length() - 2) {
				number = number.substring(0, number.length() - k);
				break;
			}
			index++;
		}
		return number;
	}
	
	// 10번에서 속도 초과
	public String solution2(String number, int k) {
		int j = 0;
		for(int i = 0; i < k; i++) {
			for(j = 0; j < number.length() - 1; j++) {
				if(Integer.parseInt(number.substring(j, j + 1)) < Integer.parseInt(number.substring(j + 1, j + 2))) {
					break;
				}
			}
			number = number.substring(0, j) + number.substring(j + 1);
			System.out.println(number);
		}
		return number;
	}
	
	// 성공소스
	public String solution3(String number, int k) {
		StringBuilder sb = new StringBuilder(number);
		System.out.println(sb);
		int j = 0;
		for(int i = 0; i < k; i++) {
			for(j = 0; j < sb.length() - 1; j++) {
				if(sb.charAt(j) < sb.charAt(j + 1)) {
					break;
				}
			}
			sb.deleteCharAt(j);
			System.out.println(sb);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String number = "4177252841"; // 775841
		int k = 4;
		
//		String number = "765432100";
//		int k = 5;
		
		Solution solution = new Solution();
		String answer = solution.solution3(number, k);
		System.out.println("answer : " + answer);
	}
}
